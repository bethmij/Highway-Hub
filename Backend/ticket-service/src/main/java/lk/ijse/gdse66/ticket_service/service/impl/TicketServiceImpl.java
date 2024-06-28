package lk.ijse.gdse66.ticket_service.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse66.ticket_service.dto.TicketDTO;
import lk.ijse.gdse66.ticket_service.entity.TicketEntity;
import lk.ijse.gdse66.ticket_service.repo.TicketRepo;
import lk.ijse.gdse66.ticket_service.service.TicketService;
import lk.ijse.gdse66.ticket_service.service.exception.DuplicateRecordException;
import lk.ijse.gdse66.ticket_service.service.exception.NotFoundException;
import lk.ijse.gdse66.ticket_service.service.util.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepo ticketRepo;

    @Autowired
    Transformer transformer;

    @Autowired
    public RestTemplate restTemplate;

    @Override
    public List<TicketDTO> getAllTickets() {

        List<TicketEntity> tickets = ticketRepo.findAll();

        if (tickets.isEmpty()) {
            throw new NotFoundException("No Tickets Exist");
        }
        return tickets.stream().map(ticketEntity -> transformer.fromTicketEntity(ticketEntity)).toList();
    }

    @Override
    public TicketDTO getTicketById(String ticketId) {

        if (!ticketRepo.existsById(ticketId)) {
            throw new NotFoundException("Ticket nic : " + ticketId + " doesn't exist");
        }
        return transformer.fromTicketEntity(ticketRepo.findById(ticketId)
                .orElseThrow(() -> new NotFoundException("Ticket nic : " + ticketId + " doesn't exist")));
    }

    @Override
    public Boolean isTicketExit(String ticketId) {
        return ticketRepo.existsById(ticketId);
    }

    @Override
    public TicketDTO saveTicket(TicketDTO ticketDTO) {

        if (ticketRepo.existsById(String.valueOf(ticketDTO.getTicketNum()))) {
            throw new DuplicateRecordException("Ticket id : " + ticketDTO.getTicketNum() + " already exist");
        }

        Boolean isUserExit = restTemplate.getForObject("http://user-service/user/isExit/" + ticketDTO.getUserNIC(), Boolean.class);
        if(Boolean.FALSE.equals(isUserExit)){
            throw new NotFoundException("User Nic : "+ticketDTO.getUserNIC()+" doesn't exist");
        }

        if (ticketDTO.getTicketNum() == null || ticketDTO.getTicketNum().isEmpty()) {
            ticketDTO.setTicketNum(UUID.randomUUID().toString());
        }

        return transformer.fromTicketEntity(ticketRepo.save(transformer.toTicketEntity(ticketDTO)));
    }

    @Override
    public void updateTicket(TicketDTO ticketDTO) {
        if (!ticketRepo.existsById(ticketDTO.getTicketNum())) {
            throw new NotFoundException("Ticket id : " + ticketDTO.getTicketNum() + " doesn't exist");
        }

        TicketEntity ticketData = ticketRepo.findById(ticketDTO.getTicketNum()).orElseThrow(
                () -> new NotFoundException("Ticket Id : "+ticketDTO.getTicketNum()+" doesn't exist")
        );
        TicketEntity ticketEntity = transformer.toTicketEntity(ticketDTO);
        ticketEntity.setIssuedDate(ticketData.getIssuedDate());
        ticketRepo.save(ticketEntity);
    }

    @Override
    public void deleteTicket(String ticketId) {
        if (!ticketRepo.existsById(ticketId)) {
            throw new NotFoundException("Ticket id : " + ticketId + " doesn't exist");
        }
        ticketRepo.deleteById(ticketId);
    }

}

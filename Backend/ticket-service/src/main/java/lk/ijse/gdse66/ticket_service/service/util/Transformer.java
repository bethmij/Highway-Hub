package lk.ijse.gdse66.ticket_service.service.util;

import lk.ijse.gdse66.ticket_service.dto.TicketDTO;
import lk.ijse.gdse66.ticket_service.entity.TicketEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Transformer {

    private final ModelMapper mapper;

    public Transformer(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public TicketDTO fromTicketEntity(TicketEntity ticketEntity) {
        return mapper.map(ticketEntity, TicketDTO.class);
    }

    public TicketEntity toTicketEntity(TicketDTO ticketDTO) {
        return mapper.map(ticketDTO, TicketEntity.class);
    }



}

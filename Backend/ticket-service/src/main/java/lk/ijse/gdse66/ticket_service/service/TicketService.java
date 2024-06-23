package lk.ijse.gdse66.ticket_service.service;

import lk.ijse.gdse66.ticket_service.dto.TicketDTO;

import java.util.List;

public interface TicketService {

    List<TicketDTO> getAllTickets();

    TicketDTO getTicketById(String ticketId);

    TicketDTO saveTicket (TicketDTO ticketDTO);

    void updateTicket(TicketDTO ticketDTO);

    void deleteTicket(String ticketId);
}

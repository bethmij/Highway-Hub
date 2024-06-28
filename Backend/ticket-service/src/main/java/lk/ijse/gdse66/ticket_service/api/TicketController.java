package lk.ijse.gdse66.ticket_service.api;

import jakarta.validation.Valid;
import jakarta.ws.rs.core.MediaType;
import lk.ijse.gdse66.ticket_service.dto.TicketDTO;
import lk.ijse.gdse66.ticket_service.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    public RestTemplate restTemplate;

    @Autowired
    private TicketService ticketService;

    @GetMapping(path = "getAll", produces = MediaType.APPLICATION_JSON)
    public List<TicketDTO> getAllTicket() {
        return ticketService.getAllTickets();
    }

    @GetMapping(path = "/{ticketId}", produces = MediaType.APPLICATION_JSON)
    public TicketDTO getTicketByID(@PathVariable("ticketId") String ticketId) {
        return ticketService.getTicketById(ticketId);
    }

    @GetMapping(path = "isExit/{ticketId}")
    public Boolean isTicketExit(@PathVariable("ticketId") String ticketId){
        return ticketService.isTicketExit(ticketId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.CREATED)
    public TicketDTO saveTicket(@Valid @RequestBody TicketDTO ticketDTO){
        return ticketService.saveTicket(ticketDTO);
    }

    @PatchMapping(consumes = MediaType.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTicket(@Valid @RequestBody TicketDTO ticketDTO){
        ticketService.updateTicket(ticketDTO);
    }

    @DeleteMapping(path = "/{ticketId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTicket(@PathVariable("ticketId") String ticketId){
        ticketService.deleteTicket(ticketId);
    }
}

package lk.ijse.gdse66.ticket_service.repo;

import lk.ijse.gdse66.ticket_service.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<TicketEntity, String> {

}

package lk.ijse.gdse66.payment_service;

import lk.ijse.gdse66.ticket_service.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<TicketEntity, String> {

    Boolean existsByUserNIC(String userId);
}

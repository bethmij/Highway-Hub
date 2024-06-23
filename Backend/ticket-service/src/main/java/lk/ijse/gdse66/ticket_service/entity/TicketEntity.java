package lk.ijse.gdse66.ticket_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.util.UUID;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ticket_service")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ticket_num")
    private UUID ticketNum;

    @Column(name = "user_nic", nullable = false)
    private String userNIC;

    @CreationTimestamp
    @Column(name = "issued_date", nullable = false)
    private Date issuedDate;

    @Column(name = "price")
    private double totalPrice;

    @Column(name = "entrancePoint")
    private String entrancePoint;

    @Column(name = "exit_point")
    private String exitPoint;

    @Column(name = "departure_time")
    private Date departureTime;

    @Column(name = "arrival_time")
    private Date arrivalTime;

}

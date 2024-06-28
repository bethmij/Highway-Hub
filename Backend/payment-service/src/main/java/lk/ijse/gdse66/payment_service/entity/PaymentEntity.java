package lk.ijse.gdse66.payment_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "payment_service")
public class PaymentEntity {

    @Id
    @Column(name = "payment_id", columnDefinition = "varchar(36)")
    private String paymentId;

    @CollectionTable(name = "payment_service", joinColumns = @JoinColumn(name = "ticket_num"))
    @Column(unique = true, name = "ticket_num")
    private String ticketNum;

    private double amount;

    @CreationTimestamp
    @Column(name = "purchased_date")
    private Date purchasedDate;

    @Column(name = "type")
    private String paymentType;

}

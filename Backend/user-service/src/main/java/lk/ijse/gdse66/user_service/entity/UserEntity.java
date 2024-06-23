package lk.ijse.gdse66.user_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_service")
public class UserEntity {

    @Id
    @Column(name = "user_nic")
    private String userNIC;

    @ElementCollection
    @CollectionTable(name = "vehicle_service", joinColumns = @JoinColumn(name = "user_nic"))
    private List<String> vehicleId = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "ticket_service", joinColumns = @JoinColumn(name = "user_nic"))
    private List<UUID> ticketNum = new ArrayList<>();

    @Column(name = "name", nullable = false)
    private String userName;

    private Long address;

    @Column(name = "contact_number" , length = 10 , nullable = false)
    private int contactNumber;

    private String email;


}

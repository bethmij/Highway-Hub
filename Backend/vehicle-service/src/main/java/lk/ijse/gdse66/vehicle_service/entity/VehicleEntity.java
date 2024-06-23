package lk.ijse.gdse66.vehicle_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "vehicle_service")
public class VehicleEntity {

    @Id
    @Column(name = "vehicle_id")
    private String vehicleId;

    @Column(name = "user_nic")
    private String userNIC;

    @Column(name = "car_type")
    private String carType;
}

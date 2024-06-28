package lk.ijse.gdse66.vehicle_service.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VehicleDTO {

    @NotBlank(message = "vehicle ID can not be null")
    private String vehicleId;

    @NotBlank(message = "user nic can not be null")
    private String userNIC;

    private String carType;
}


package lk.ijse.gdse66.ticket_service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TicketDTO {

    private String ticketNum;

    @NotBlank(message = "user nic can not be null")
    private String userNIC;

    @DecimalMin(value = "0.0", inclusive = false, message = "total price must be greater than zero")
    private double totalPrice;

    @NotBlank(message = "entrance point can not be null")
    private String entrancePoint;

    @NotBlank(message = "exit point can not be null")
    private String exitPoint;

    @JsonFormat(pattern = "yyyyMMdd")
    private Time departureTime;

    @JsonFormat(pattern = "yyyyMMdd")
    private Time arrivalTime;


}

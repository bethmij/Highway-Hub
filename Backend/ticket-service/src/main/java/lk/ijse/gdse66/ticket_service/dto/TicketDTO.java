package lk.ijse.gdse66.ticket_service.dto;

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

    private String userNIC;

    private double totalPrice;

    private String entrancePoint;

    private String exitPoint;

    private Time departureTime;

    private Time arrivalTime;


}

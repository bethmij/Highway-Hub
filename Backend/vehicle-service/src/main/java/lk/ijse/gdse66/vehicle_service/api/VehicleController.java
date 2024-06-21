package lk.ijse.gdse66.vehicle_service.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @GetMapping
    public String getMethod(){
        return "request received";
    }
}

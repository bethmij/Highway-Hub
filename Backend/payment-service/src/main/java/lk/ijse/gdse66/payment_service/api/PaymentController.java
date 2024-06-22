package lk.ijse.gdse66.payment_service.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class PaymentController {

    @GetMapping
    public String getMethod(){
        return "request received";
    }
}

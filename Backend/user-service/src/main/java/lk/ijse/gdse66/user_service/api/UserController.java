package lk.ijse.gdse66.user_service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public RestTemplate restTemplate;

    @GetMapping
    public String getMethod() {
        return restTemplate.getForObject("http://vehicle-service/vehicle", String.class);
    }

    @PostMapping
    public String saveMethod(){
        return "saved method";
    }

}

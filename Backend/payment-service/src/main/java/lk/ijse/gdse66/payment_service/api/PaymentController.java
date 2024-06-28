package lk.ijse.gdse66.payment_service.api;

import jakarta.validation.Valid;
import jakarta.ws.rs.core.MediaType;
import lk.ijse.gdse66.payment_service.dto.PaymentDTO;
import lk.ijse.gdse66.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    public RestTemplate restTemplate;

    @Autowired
    private PaymentService paymentService;

    @GetMapping(path = "getAll", produces = MediaType.APPLICATION_JSON)
    public List<PaymentDTO> getAllPayment() {
        return paymentService.getAllPayments();
    }

    @GetMapping(path = "/{paymentId}", produces = MediaType.APPLICATION_JSON)
    public PaymentDTO getPaymentByID(@PathVariable("paymentId") String paymentId) {
        return paymentService.getPaymentById(paymentId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentDTO savePayment(@Valid @RequestBody PaymentDTO paymentDTO){
        return paymentService.savePayment(paymentDTO);
    }

    @PatchMapping(consumes = MediaType.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePayment(@Valid @RequestBody PaymentDTO paymentDTO){
        paymentService.updatePayment(paymentDTO);
    }

    @DeleteMapping(path = "/{paymentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePayment(@PathVariable("paymentId") String paymentId){
        paymentService.deletePayment(paymentId);
    }
}

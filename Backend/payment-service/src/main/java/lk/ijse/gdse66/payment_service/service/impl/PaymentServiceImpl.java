package lk.ijse.gdse66.payment_service.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse66.payment_service.dto.PaymentDTO;
import lk.ijse.gdse66.payment_service.entity.PaymentEntity;
import lk.ijse.gdse66.payment_service.repo.PaymentRepo;
import lk.ijse.gdse66.payment_service.service.PaymentService;
import lk.ijse.gdse66.payment_service.service.exception.DuplicateRecordException;
import lk.ijse.gdse66.payment_service.service.exception.NotFoundException;
import lk.ijse.gdse66.payment_service.service.util.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    Transformer transformer;

    @Autowired
    public RestTemplate restTemplate;

    @Override
    public List<PaymentDTO> getAllPayments() {

        List<PaymentEntity> payments = paymentRepo.findAll();

        if (payments.isEmpty()) {
            throw new NotFoundException("No Payments Exist");
        }
        return payments.stream().map(paymentEntity -> transformer.fromPaymentEntity(paymentEntity)).toList();
    }

    @Override
    public PaymentDTO getPaymentById(String paymentId) {

        if (!paymentRepo.existsById(paymentId)) {
            throw new NotFoundException("Payment nic : " + paymentId + " doesn't exist");
        }
        return transformer.fromPaymentEntity(paymentRepo.findById(paymentId)
                .orElseThrow(() -> new NotFoundException("Payment nic : " + paymentId + " doesn't exist")));
    }

    @Override
    public PaymentDTO savePayment(PaymentDTO paymentDTO) {

        Boolean isTicketNumExist = restTemplate.getForObject("http://ticket-service/ticket/isExit/" + paymentDTO.getTicketNum(), Boolean.class);
        if(Boolean.FALSE.equals(isTicketNumExist)){
            throw new NotFoundException("Ticket Num : "+paymentDTO.getTicketNum()+" doesn't exist");
        }

        if (paymentDTO.getPaymentId() == null || paymentDTO.getPaymentId().isEmpty()) {
            paymentDTO.setPaymentId(UUID.randomUUID().toString());
        }

        if (paymentRepo.existsById(paymentDTO.getPaymentId())) {
            throw new DuplicateRecordException("Payment id : " + paymentDTO.getPaymentId() + " already exist");
        }


        return transformer.fromPaymentEntity(paymentRepo.save(transformer.toPaymentEntity(paymentDTO)));
    }

    @Override
    public void updatePayment(PaymentDTO paymentDTO) {
        if (!paymentRepo.existsById(paymentDTO.getPaymentId())) {
            throw new NotFoundException("Payment id : " + paymentDTO.getPaymentId() + " doesn't exist");
        }

        PaymentEntity payment = paymentRepo.findById(paymentDTO.getPaymentId()).orElseThrow(
                () -> new NotFoundException("PaymentId : "+paymentDTO.getPaymentId()+" doesn't exist")
        );

        payment.setPurchasedDate(payment.getPurchasedDate());
        paymentRepo.save(payment);
    }

    @Override
    public void deletePayment(String paymentId) {
        if (!paymentRepo.existsById(paymentId)) {
            throw new NotFoundException("Payment id : " + paymentId + " doesn't exist");
        }
        paymentRepo.deleteById(paymentId);
    }

}

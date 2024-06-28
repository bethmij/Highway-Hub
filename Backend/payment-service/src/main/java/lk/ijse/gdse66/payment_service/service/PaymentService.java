package lk.ijse.gdse66.payment_service.service;

import lk.ijse.gdse66.payment_service.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {

    List<PaymentDTO> getAllPayments();

    PaymentDTO getPaymentById(String paymentId);

    PaymentDTO savePayment (PaymentDTO paymentDTO);

    void updatePayment(PaymentDTO paymentDTO);

    void deletePayment(String paymentId);
}

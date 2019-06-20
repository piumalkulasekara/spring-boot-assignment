package lk.piumalkulasekara.spring.boot.assignment.service;

import lk.piumalkulasekara.spring.boot.assignment.model.Account;
import lk.piumalkulasekara.spring.boot.assignment.model.Payment;

import java.util.Date;

public interface PaymentService {
    Iterable<Payment> getAllPayments();

    Iterable<Payment> filterPaymentsByAccountIdAndDate(Integer accountId, Date startDate, Date endDate);

    Payment getPayment(Integer id);

    Payment addPayment(Payment payment);
}
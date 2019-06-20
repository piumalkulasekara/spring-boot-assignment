package lk.piumalkulasekara.spring.boot.assignment.service;

import lk.piumalkulasekara.spring.boot.assignment.exception.AccountNotFoundException;
import lk.piumalkulasekara.spring.boot.assignment.exception.PaymentNotFoundException;
import lk.piumalkulasekara.spring.boot.assignment.model.Account;
import lk.piumalkulasekara.spring.boot.assignment.model.Payment;
import lk.piumalkulasekara.spring.boot.assignment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Iterable<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Iterable<Payment> filterPaymentsByAccountIdAndDate(Integer accountId, Date startDate, Date endDate) {
        Iterable<Payment> payments =  paymentRepository.findAll();
        Iterator<Payment> itr = payments.iterator();

        List<Payment> newPayments = new ArrayList<Payment>();

        while (itr.hasNext()) {
            if(itr.next().getCreatedAt().compareTo(startDate) >= 0 && itr.next().getCreatedAt().compareTo(endDate) <= 0) {
                newPayments.add(itr.next());
            }
        }

        return newPayments;
    }

    @Override
    public Payment getPayment(Integer id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException(id));
    }

    @Override
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
}

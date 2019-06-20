package lk.piumalkulasekara.spring.boot.assignment.exception;

public class PaymentNotFoundException extends RuntimeException {
    public PaymentNotFoundException(Integer id) {
        super("Could not find Payment with ID: " + id);
    }
}
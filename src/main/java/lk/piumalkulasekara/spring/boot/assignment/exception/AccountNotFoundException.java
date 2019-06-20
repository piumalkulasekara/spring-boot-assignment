package lk.piumalkulasekara.spring.boot.assignment.exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(Integer id) {
        super("Could not find Account with ID: " + id);
    }
}
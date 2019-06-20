package lk.piumalkulasekara.spring.boot.assignment.service;

import lk.piumalkulasekara.spring.boot.assignment.model.Account;
import lk.piumalkulasekara.spring.boot.assignment.model.Payment;

public interface AccountService {
    Iterable<Account> getAllAccounts();

    Account getAccount(Integer id);

    Account addAccount(Account account);

    Iterable<Payment> getPayments(Integer id);
}
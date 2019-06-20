package lk.piumalkulasekara.spring.boot.assignment.service;

import lk.piumalkulasekara.spring.boot.assignment.exception.AccountNotFoundException;
import lk.piumalkulasekara.spring.boot.assignment.model.Account;
import lk.piumalkulasekara.spring.boot.assignment.model.Payment;
import lk.piumalkulasekara.spring.boot.assignment.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccount(Integer id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id));
    }

    @Override
    public Account addAccount(Account product) {
        return accountRepository.save(product);
    }

    @Override
    public Iterable<Payment> getPayments(Integer id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id));
        return account.getPayments();
    }
}
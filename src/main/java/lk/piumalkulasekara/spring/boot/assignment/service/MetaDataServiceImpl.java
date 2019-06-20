package lk.piumalkulasekara.spring.boot.assignment.service;

import lk.piumalkulasekara.spring.boot.assignment.model.Account;
import lk.piumalkulasekara.spring.boot.assignment.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class MetaDataServiceImpl implements MetaDataService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private PaymentService paymentService;

    @Override
    public void addAccountMetaData() {

        List<Account> current = (List<Account>) accountService.getAllAccounts();

        if(current.isEmpty()) {
            List<Account> accounts = new ArrayList<Account>();

            Account account1 = new Account();
            account1.setName("Gin");
            accounts.add(account1);

            Account account2 = new Account();
            account2.setName("Tone");
            accounts.add(account2);

            Account account3 = new Account();
            account3.setName("Charge");
            accounts.add(account3);

            Account account4 = new Account();
            account4.setName("World");
            accounts.add(account4);

            Account account5 = new Account();
            account5.setName("Eery");
            accounts.add(account5);

            for (Account account : accounts) {
                accountService.addAccount(account);
            }
        }
    }

    @Override
    public void addPaymentMetaData() {
        List<Payment> current = (List<Payment>) paymentService.getAllPayments();

        if(current.isEmpty()) {
            for (int i = 1; i <= 5; i++) {
                Random rand = new Random();
                int times = rand.nextInt(10);
                Account account = accountService.getAccount(i);

                for (int j = 0; j < times; j++) {
                    Integer amount = rand.nextInt(300000);
                    Payment payment = new Payment();
                    payment.setAccount(account);
                    payment.setAmount(amount.doubleValue());
                    paymentService.addPayment(payment);
                }
            }
        }
    }
}

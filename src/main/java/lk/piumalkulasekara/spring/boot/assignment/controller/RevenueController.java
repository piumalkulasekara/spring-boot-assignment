package lk.piumalkulasekara.spring.boot.assignment.controller;

import lk.piumalkulasekara.spring.boot.assignment.model.Account;
import lk.piumalkulasekara.spring.boot.assignment.model.Payment;
import lk.piumalkulasekara.spring.boot.assignment.model.Revenue;
import lk.piumalkulasekara.spring.boot.assignment.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class RevenueController {

    private static final String VALID_TOKEN = "skjdhaksdh3er82394dsad";

    @Autowired
    private AccountService accountService;

    @GetMapping("/revenue")
    public List<Revenue> getRevenue(@RequestParam ("token") String token,
                                    @RequestParam ("startDate") String startDate,
                                    @RequestParam ("endDate") String endDate) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date _startDate = null;
        Date _endDate = null;

        try {
            _startDate = formatter.parse(startDate);
            _endDate = formatter.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Revenue> revenueList = new ArrayList<Revenue>();

        Iterable<Account> accounts = accountService.getAllAccounts();
        Iterator<Account> accountIterator = accounts.iterator();

        while (accountIterator.hasNext()) {
            Account account = accountService.getAccount(accountIterator.next().getId());
            Double amount = 0.0;
            Revenue revenue = new Revenue();
            revenue.setAccount(account.getName());

            System.out.println("ID:  " + account.getId());
            System.out.println("Name:  " + account.getName());

            if (account.getPayments() != null) {
                for (Payment payment : account.getPayments()) {
                    Date createdDate = null;
                    try {
                        createdDate = formatter.parse(payment.getCreatedAt().toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    System.out.println("createdDate:  " + createdDate);
                    System.out.println("startDate:  " + _startDate);
                    System.out.println("endDate:  " + _endDate);

                    if (createdDate.compareTo(_startDate) >= 0 && createdDate.compareTo(_endDate) <= 0) {
                        System.out.println("Inside:  ");
                        amount += payment.getAmount();
                    }
                }
            }

            revenue.setAmount(amount);
            revenueList.add(revenue);
        }

        return revenueList;
    }
}

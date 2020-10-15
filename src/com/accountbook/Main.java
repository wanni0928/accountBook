package com.accountbook;

import com.accountbook.controller.MoneyController;
import com.accountbook.model.Account;
import com.accountbook.repository.CalendarUtil;
import com.accountbook.repository.MoneyService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MoneyService moneyService = new MoneyService();
        MoneyController moneyController = new MoneyController(moneyService);

        moneyController.addExpand();
        moneyController.addIncome();
        List<Account> accounts = moneyController.findAll();
        CalendarUtil calendarUtil = new CalendarUtil();

        for (Account account : accounts) {
            System.out.println(calendarUtil.getCurrentDate(account.getLocalDateTime()));
            System.out.println(account.getBalance() + " " + account.getAccountStatus());
        }
    }
}

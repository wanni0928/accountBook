package com.accountbook;

import com.accountbook.controller.MoneyController;
import com.accountbook.controller.ScheduleController;
import com.accountbook.model.Account;
import com.accountbook.repository.CalendarUtil;
import com.accountbook.repository.MoneyService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MoneyService moneyService = new MoneyService();
        CalendarUtil calendarUtil = new CalendarUtil();
        MoneyController moneyController = new MoneyController(moneyService);
        ScheduleController scheduleController = new ScheduleController(calendarUtil, moneyService);

        moneyController.addExpand();
        moneyController.addExpand();
        moneyController.addExpand();
        moneyController.addExpand();
        moneyController.addExpand();
        moneyController.addIncome();
        moneyController.addIncome();
        moneyController.addIncome();
        moneyController.addIncome();
        moneyController.addIncome();
        moneyController.addIncome();

        System.out.println("일별 수입 목록 (INCOME)");
        List<Account> dailyIncomeList = scheduleController.dailyIncome(2020, 10, 15);
        for (Account account : dailyIncomeList) {
            System.out.println(account);
        }

        System.out.println("일별 지출 목록 (EXPAND)");
        List<Account> accounts = scheduleController.dailySpent(2020, 10, 15);
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}

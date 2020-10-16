package com.accountbook.controller;

import com.accountbook.domain.Account;
import com.accountbook.service.MoneyService;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

class ScheduleControllerTest {

//    @Test
//    void dailyIncome() throws IOException {
//        MoneyService moneyService = new MoneyService();
//        CalendarUtil calendarUtil = new CalendarUtil();
//        MoneyController moneyController = new MoneyController(moneyService);
//        ScheduleController scheduleController = new ScheduleController(calendarUtil, moneyService);
//
//        int year = calendarUtil.getCurrentYear();
//        int month = calendarUtil.getCurrentMonth();
//        int day = calendarUtil.getCurrentDayOfMonth();
//
//
//        moneyController.addIncome();
//        List<Account> dailyIncomeList = scheduleController.dailyIncome(year, month, day);
//        assertEquals(dailyIncomeList.size(), 1);
//        assertEquals(dailyIncomeList.get(0).getAccountId(), 1L);
//    }

    @Test
    void dailySpent() throws IOException {

//        List<Object> list = sqlSession.selectList("Account.findAll");
        MoneyService moneyService = new MoneyService();
        MoneyController moneyController = new MoneyController(moneyService);
        List<Account> all = moneyController.findAll();
        System.out.println(all);
//        System.out.println(list);
    }
}
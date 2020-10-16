package com.accountbook.controller;

import com.accountbook.domain.Account;
import com.accountbook.service.MoneyService;
import com.accountbook.utils.CalendarUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ScheduleControllerTest {

    @Test
    void dailyIncome() {
        MoneyService moneyService = new MoneyService();
        CalendarUtil calendarUtil = new CalendarUtil();
        MoneyController moneyController = new MoneyController(moneyService);
        ScheduleController scheduleController = new ScheduleController(calendarUtil, moneyService);

        int year = calendarUtil.getCurrentYear();
        int month = calendarUtil.getCurrentMonth();
        int day = calendarUtil.getCurrentDayOfMonth();


        moneyController.addIncome();
        List<Account> dailyIncomeList = scheduleController.dailyIncome(year, month, day);
        Assertions.assertEquals(dailyIncomeList.size(), 1);
    }

    @Test
    void dailySpent() {
    }
}
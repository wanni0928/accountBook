package com.accountbook;

import com.accountbook.controller.MoneyController;
import com.accountbook.repository.CalendarService;
import com.accountbook.repository.MoneyService;

public class Main {
    public static void main(String[] args) {
        MoneyService moneyService = new MoneyService();
        MoneyController moneyController = new MoneyController(moneyService);

        moneyController.addExpand();
        moneyController.addIncome();
        moneyController.findAll();


        CalendarService calendarService = new CalendarService();

        calendarService.setCurrentDate();
        System.out.println(calendarService.getCurrentMonthMaxDay());
        System.out.println(calendarService.getCurrentYear());
        System.out.println(calendarService.getCurrentMonth());
        System.out.println(calendarService.getCurrentDayOfMonth());
    }
}

package com.accountbook.controller;

import com.accountbook.domain.Account;
import com.accountbook.domain.AccountStatus;
import com.accountbook.utils.CalendarUtil;
import com.accountbook.service.MoneyService;

import java.util.List;
import java.util.stream.Collectors;

public class ScheduleController {
    private final CalendarUtil calendarUtil;
    private final MoneyService moneyService;

    public ScheduleController(CalendarUtil calendarUtil, MoneyService moneyService) {
        this.calendarUtil = calendarUtil;
        this.moneyService = moneyService;
    }

    // 일별 수입 - 입력한 날짜를 기준으로, AccountStatus가 INCOME인 것만 모아둔 list를 반환
    public List<Account> dailyIncome(int year, int month, int day) {
        //yyyy-MM-dd
        String compareDate = String.format("%d-%d-%d", year, month, day);
        return moneyService.findAll().stream().filter(account ->
                calendarUtil.getCurrentDate(account.getLocalDateTime())
                        .equals(compareDate) && account.getAccountStatus() == AccountStatus.INCOME
        ).collect(Collectors.toList());
    }

    // 일별 지출
    public List<Account> dailySpent(int year, int month, int day) {
        //yyyy-MM-dd
        String compareDate = String.format("%d-%d-%d", year, month, day);
        return moneyService.findAll().stream().filter(account ->
                calendarUtil.getCurrentDate(account.getLocalDateTime())
                        .equals(compareDate) && account.getAccountStatus() == AccountStatus.EXPAND
        ).collect(Collectors.toList());
    }

}

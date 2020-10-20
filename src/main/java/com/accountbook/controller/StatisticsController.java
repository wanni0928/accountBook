package com.accountbook.controller;

import com.accountbook.domain.Account;
import com.accountbook.service.AccountService;
import com.accountbook.utils.CalendarUtil;

import java.util.List;
import java.util.stream.Collectors;

public class StatisticsController {
    private final CalendarUtil calendarUtil;
    private final AccountService accountService;

    public StatisticsController(CalendarUtil calendarUtil, AccountService accountService) {
        this.calendarUtil = calendarUtil;
        this.accountService = accountService;
    }

    // 전체 합계
    public int totalSum() {
        int total = 0;
        List<Account> accounts = accountService.findAll();
        for (Account account : accounts) {
            if(account.getAccountStatus().equals("수입")){
                total += account.getAccountBalance();
            }else {
                total -= account.getAccountBalance();
            }
        }
        return total;
    }

    // 전체 평균
    public int totalAvg(int total, int length) {
        return total / length;
    }

    // 일별 수입 - 입력한 날짜를 기준으로, AccountStatus가 INCOME인 것만 모아둔 list를 반환
    public List<Account> dailyIncome(int year, int month, int day) {
        //yyyy-MM-dd
        String compareDate = String.format("%d-%d-%d", year, month, day);
        return accountService.findAll().stream().filter(account ->
                calendarUtil.getCurrentDate(account.getAccountDate())
                        .equals(compareDate) && account.getAccountStatus().equals("수입")
        ).collect(Collectors.toList());
    }

    // 일별 수입 합계
    public int dailyIncomeSum(int year, int month, int day, List<Account> accounts) {
        String compareDate = String.format("%d-%d-%d", year, month, day);
        return accounts.stream().filter(account ->
                calendarUtil.getCurrentDate(
                        account.getAccountDate()).equals(compareDate) &&
                        account.getAccountStatus().equals("수입"))
                .mapToInt(Account::getAccountBalance).sum();
    }

    // 일별 수입 평균
    public int dailyIncomeAvg(int year, int month, int day, List<Account> accounts) {
        String compareDate = String.format("%d-%d-%d", year, month, day);
        return (int) accounts.stream().filter(account ->
                calendarUtil.getCurrentDate(
                        account.getAccountDate()).equals(compareDate) &&
                        account.getAccountStatus().equals("수입"))
                .mapToInt(Account::getAccountBalance).average().orElse(-1);
    }

    // 일별 지출
    public List<Account> dailySpent(int year, int month, int day) {
        //yyyy-MM-dd
        String compareDate = String.format("%d-%d-%d", year, month, day);
        return accountService.findAll().stream().filter(account ->
                calendarUtil.getCurrentDate(account.getAccountDate())
                        .equals(compareDate) && account.getAccountStatus().equals("소비")
        ).collect(Collectors.toList());
    }

    // 일별 지출 합계
    public int dailySpentSum(int year, int month, int day, List<Account> accounts) {
        String compareDate = String.format("%d-%d-%d", year, month, day);
        return accounts.stream().filter(account ->
                calendarUtil.getCurrentDate(
                        account.getAccountDate()).equals(compareDate) &&
                        account.getAccountStatus().equals("소비"))
                .mapToInt(Account::getAccountBalance).sum();
    }

    // 일별 지출 평균
    public int dailyExpandAvg(int year, int month, int day, List<Account> accounts) {
        String compareDate = String.format("%d-%d-%d", year, month, day);
        return (int) accounts.stream().filter(account ->
                calendarUtil.getCurrentDate(
                        account.getAccountDate()).equals(compareDate) &&
                        account.getAccountStatus().equals("소비"))
                .mapToInt(Account::getAccountBalance).average().orElse(-1);
    }

    // 카테고리별 합계
//    public int categorySum(List<Account> accounts,String status, String category) {
//        return accounts.stream()
//                .filter(account -> account.getCategory().equals(category) && account.getAccountStatus().equals(status))
//                .mapToInt(Account::getAccountBalance).sum();
//    }
}

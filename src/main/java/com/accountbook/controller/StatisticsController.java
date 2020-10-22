package com.accountbook.controller;

import com.accountbook.domain.Account;
import com.accountbook.domain.Category;
import com.accountbook.service.AccountService;
import com.accountbook.utils.CalendarUtil;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsController {
    private final CalendarUtil calendarUtil;
    private final AccountService accountService;

    public StatisticsController(CalendarUtil calendarUtil, AccountService accountService) {
        this.calendarUtil = calendarUtil;
        this.accountService = accountService;
    }

    // 전체 합계
    public int totalSum(List<Account> accounts) {
        return accounts.stream().mapToInt(Account::getAccountBalance).sum();
    }

    // 연간 목록
    public List<Account> getAnnualList(int year, List<Account> accounts, String accountStatus){
        return accounts.stream().filter(account -> {
            LocalDateTime currentDate = account.getAccountDate();
            LocalDateTime targetDate =
                    calendarUtil
                            .setCurrentDate(
                                    currentDate.getYear(),
                                    currentDate.getMonthValue(),
                                    currentDate.getDayOfMonth());
            return targetDate.getYear() == year && account.getAccountStatus().equals(accountStatus);
        }).collect(Collectors.toList());
    }

    // 연간 합계

    // 월간 목록
    public List<Account> getMonthlyList(int year, int month, List<Account> accounts, String accountStatus){
        return accounts.stream().filter(account -> {
            LocalDateTime currentDate = account.getAccountDate();
            LocalDateTime targetDate =
                    calendarUtil
                            .setCurrentDate(
                                    currentDate.getYear(),
                                    currentDate.getMonthValue(),
                                    currentDate.getDayOfMonth());
            return targetDate.getYear() == year && targetDate.getMonthValue() == month && account.getAccountStatus().equals(accountStatus);
        }).collect(Collectors.toList());
    }

   // 월별 전체 합계
    public int monthlyTotalSum(Map<String, Integer> map, int year, int month) {
        int total = 0;
        List<Account> accounts = accountService.findByMonth(map, year, month);
        for (Account account : accounts) {
            if(account.getAccountStatus().equals("수입")){
                total += account.getAccountBalance();
            }else {
                total -= account.getAccountBalance();
            }
        }
        return total;
    }

    // 일별 전체 합계
    public int dailyTotalSum(Map<String, Integer> map, int year, int month, int day) {
        int total = 0;
        List<Account> accounts = accountService.findByDay(map, year, month, day);
        for (Account account : accounts) {
            if(account.getAccountStatus().equals("수입")){
                total += account.getAccountBalance();
            }else {
                total -= account.getAccountBalance();
            }
        }
        return total;
    }

    // 분야별 수입 합계
    public int totalCategorySum(Map<String, List<Account>> map, Category category) {
        int total = map.get(category.getCategoryName()).stream().mapToInt(Account::getAccountBalance).sum();
        if(category.getAccountStatus().equals("소비")){
            total *= -1;
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

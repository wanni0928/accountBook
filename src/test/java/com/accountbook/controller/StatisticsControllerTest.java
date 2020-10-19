package com.accountbook.controller;

import com.accountbook.domain.Account;
import com.accountbook.repository.AccountRepository;
import com.accountbook.repository.MyBatisAccountRepository;
import com.accountbook.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatisticsControllerTest {

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
    AccountRepository accountRepository = new MyBatisAccountRepository();
    AccountService accountService = new AccountService(accountRepository);
    AccountController accountController = new AccountController(accountService);

    StatisticsControllerTest() throws IOException {
    }
    @BeforeEach
    void opensession() {
    }

    @Test
    void dailySpent() throws IOException {

//        List<Object> list = sqlSession.selectList("Account.findAll");

        List<Account> all = accountController.findAll();
        Account account = accountService.findById(1L);

        assertEquals(all.size(), 2);
        assertEquals(account.getAccountId(), 1L);

//        System.out.println(all);
//        System.out.println(list);
    }

    @Test
    void findByTitle() {
        List<Account> accounts = accountService.findByTitle("소비테스트제목");
        assertEquals(accounts.size(), 1);
    }

    @Test
    void updateById() {
        accountController.updateAccount(1L);
    }

    @Test
    void delete() {
        accountController.delete(1L);
    }

    @Test
    void insert() {
        accountController.addExpand();
    }
}
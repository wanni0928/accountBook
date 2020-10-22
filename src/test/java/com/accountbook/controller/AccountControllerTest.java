package com.accountbook.controller;

import com.accountbook.AppConfig;
import com.accountbook.domain.Account;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AccountControllerTest {

    @Test
    void findByTitle() throws IOException {
        AccountController accountController = new AppConfig().getAccountController();
        String accountTitle = "테스트";
        List<Account> accounts = accountController.findByTitle(accountTitle);
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    void findAll() throws IOException {
        AccountController accountController = new AppConfig().getAccountController();
        List<Account> accounts = accountController.findAll();
        System.out.println(accounts);
    }

    @Test
    void findByMonth() throws IOException {
        AccountController accountController = new AppConfig().getAccountController();
        Map<String, Integer> map = new HashMap<>();
        int year = 2020;
        int month = 9;
        List<Account> accounts = accountController.findByMonth(map, year, month);
        System.out.println(accounts);
    }

    @Test
    void findByDay() throws IOException {
        AccountController accountController = new AppConfig().getAccountController();
        Map<String, Integer> map = new HashMap<>();
        int year = 2020;
        int month = 9;
        int day = 20;
        List<Account> byDay = accountController.findByDay(map, year, month, day);
        System.out.println(byDay);
    }

//    @Test
//    void updateAccount() throws IOException {
//        AccountController accountController = new AppConfig().getAccountController();
//        accountController.updateAccount(3L, 3L, "또 수정된 제목", "다시한번 수정된 내용", 1000000);
//    }

    @Test
    void delete() throws IOException {
        AccountController accountController = new AppConfig().getAccountController();
        accountController.delete(1L);
    }
}
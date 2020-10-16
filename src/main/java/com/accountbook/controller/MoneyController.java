package com.accountbook.controller;

import com.accountbook.domain.Account;
import com.accountbook.service.MoneyService;

import java.time.LocalDateTime;
import java.util.List;

public class MoneyController {
    private final MoneyService moneyService;

    public MoneyController(MoneyService moneyService) {
        this.moneyService = moneyService;
    }

    /*소비 추가*/
    public void addExpand() {
        Account account = new Account();
        account.setAccountTitle("테스트제목");
        account.setAccountContent("의류");
        account.setAccountBalance(10000);
        account.setAccountStatus("소비");
        account.setCategory("의휴");
        account.setAccountDate(LocalDateTime.now());
        moneyService.addExpand(account);
    }

    /*수입 추가*/
    public void addIncome() {
        Account account = new Account();
        account.setAccountTitle("테스트제목");
        account.setAccountContent("테스트 내용. 테스트 내용.");
        account.setAccountBalance(20000);
        account.setAccountStatus("수입");
        account.setCategory("에고...");
        account.setAccountDate(LocalDateTime.now());
        moneyService.addExpand(account);
    }

    public List<Account> findAll() {
        return moneyService.findAll();
    }

    /*삭제*/
    public void delete(){

    }
}

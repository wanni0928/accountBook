package com.accountbook.controller;

import com.accountbook.domain.Account;
import com.accountbook.domain.AccountStatus;
import com.accountbook.domain.Category;
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
        account.setTitle("테스트제목");
        account.setContent("의류");
        account.setBalance(10000);
        account.setAccountStatus(AccountStatus.EXPAND);
        account.setCategory(Category.CLOTH);
        account.setLocalDateTime(LocalDateTime.now());
        moneyService.addExpand(account);
    }

    /*수입 추가*/
    public void addIncome() {
        Account account = new Account();
        account.setTitle("테스트제목");
        account.setContent("테스트 내용. 테스트 내용.");
        account.setBalance(20000);
        account.setAccountStatus(AccountStatus.INCOME);
        account.setLocalDateTime(LocalDateTime.now());
        moneyService.addExpand(account);
    }

    public List<Account> findAll() {
        return moneyService.findAll();
    }

    /*삭제*/
    public void delete(){

    }
}

package com.accountbook.controller;

import com.accountbook.model.Account;
import com.accountbook.model.AccountStatus;
import com.accountbook.repository.MoneyService;

import java.time.LocalDateTime;

public class MoneyController {
    private final MoneyService moneyService;

    public MoneyController(MoneyService moneyService) {
        this.moneyService = moneyService;
    }

    /*소비 추가*/
    public void addExpand() {
        Account account = new Account();
        account.setTitle("테스트제목");
        account.setContent("테스트 내용. 테스트 내용.");
        account.setBalance(10000);
        account.setAccountStatus(AccountStatus.EXPAND);
        account.setLocalDateTime(LocalDateTime.now());
        String status = AccountStatus.EXPAND.toString();
        moneyService.addExpand(account);
        System.out.println("소비 완료");
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
        System.out.println("수입 완료");
    }

    /*삭제*/
    public void delete(){

    }
}

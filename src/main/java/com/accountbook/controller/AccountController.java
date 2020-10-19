package com.accountbook.controller;

import com.accountbook.domain.Account;
import com.accountbook.service.AccountService;

import java.time.LocalDateTime;
import java.util.List;

public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
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
        accountService.addExpand(account);
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
        accountService.addExpand(account);
    }
    // 목록 호춯
    public List<Account> findAll() {
        return accountService.findAll();
    }

    // update account - 고치고 싶은 번호를 CUI로 작성.
    public void updateAccount(Long id) {
        Account account = accountService.findById(id);
        account.setAccountId(1L);
        account.setAccountBalance(1);
        account.setAccountContent("내용수정3");
        account.setAccountTitle("제목수정3");
        accountService.updateById(account);

    }

    /*삭제*/
    public void delete(Long id){
        accountService.deleteById(id);
    }
}

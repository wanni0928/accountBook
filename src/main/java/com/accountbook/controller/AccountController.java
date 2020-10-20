package com.accountbook.controller;

import com.accountbook.domain.Account;
import com.accountbook.domain.Category;
import com.accountbook.service.AccountService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /*소비 추가*/
    public void addExpand(Account account) {
        accountService.addExpand(account);
    }

    /*수입 추가*/
    public void addIncome() {
        Account account = new Account();
        account.setAccountTitle("테스트제목");
        account.setAccountContent("테스트 내용. 테스트 내용.");
        account.setAccountBalance(20000);
        account.setAccountStatus("수입");
//        account.setCategory("에고...");
        account.setAccountDate(LocalDateTime.now());
        accountService.addExpand(account);
    }
    // 목록 호춯
    public List<Account> findAll() {
        return accountService.findAll();
    }

    // 월별 목록 호출
    public List<Account> findByMonth(Map<String, Integer> map, int year, int month) {
        return accountService.findByMonth(map, year, month);
    }

    // 일별 목록 호출
    public List<Account> findByDay(Map<String, Integer> map, int year, int month, int day) {
        return accountService.findByDay(map, year, month, day);
    }

    // 분야별 목록 출력
    public Map<String, List<Account>> categoryTotalList(List<Category> categories, List<Account> accounts) {
        Map<String, List<Account>> categoryReports = new HashMap<>();
        for (Category category : categories) {
            List<Account> collect = accounts.stream().filter(acc -> acc.getCategoryId().equals(category.getCategoryId())).collect(Collectors.toList());
            categoryReports.put(category.getCategoryName(), collect);
        }
        return categoryReports;
    }


   // update account - 고치고 싶은 번호를 CUI로 작성.
    public void updateAccount(Long accountId, Long categoryId, String title, String content, int balance) {
        Account account = accountService.findById(accountId);
        account.setCategoryId(categoryId);
        account.setAccountTitle(title);
        account.setAccountContent(content);
        account.setAccountBalance(balance);

        accountService.updateById(account);
    }

    /*삭제*/
    public void delete(Long id){
        accountService.deleteById(id);
    }
}

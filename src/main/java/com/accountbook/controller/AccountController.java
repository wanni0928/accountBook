package com.accountbook.controller;

import com.accountbook.domain.Account;
import com.accountbook.domain.Category;
import com.accountbook.domain.form.AccountForm;
import com.accountbook.service.AccountService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /* 소비, 수입 추가 */
    public int addAccount(AccountForm accountForm) {
        Account account = new Account();
        account.createAccount(accountForm);

        return accountService.addExpand(account);
    }

    // 목록 호춯
    public List<Account> findAll() {
        return accountService.findAll();
    }

    public Account findById(Long id) {
        return accountService.findById(id);
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

    // 제목으로 검색하기
    public List<Account> findByTitle(String accountTitle){
        return accountService.findByTitle(accountTitle);
    }

   // update account - 고치고 싶은 번호를 CUI로 작성.
    public int updateAccount(Account account, AccountForm accountForm) {
        account.createAccount(accountForm);
        return accountService.updateById(account);
    }

    /*삭제*/
    public int delete(Long id){
        return accountService.deleteById(id);
    }
}

package com.accountbook.service;

import com.accountbook.domain.Account;
import com.accountbook.repository.AccountRepository;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) throws IOException {
        this.accountRepository = accountRepository;
    }

    /* 수입/지출 추가*/
    public int addExpand(Account account) {
        return accountRepository.save(account);
    }

    public Account findById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    public List<Account> findByTitle(String title) {
        return accountRepository.findByTitle(title);
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public List<Account> findByMonth(Map<String, Integer> map,int year, int month) {
        return accountRepository.findByMonth(map, year, month);
    }

    public List<Account> findByDay(Map<String, Integer> map, int year, int month, int day) {
        return accountRepository.findByDay(map, year, month, day);
    }

    public int updateById(Account account) {
        return accountRepository.update(account);
    }

    /*목록 지우기*/
    public int deleteById(Long id) {
        return accountRepository.deleteById(id);
    }
}

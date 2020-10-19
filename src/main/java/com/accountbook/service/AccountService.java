package com.accountbook.service;

import com.accountbook.domain.Account;
import com.accountbook.repository.AccountRepository;

import java.io.IOException;
import java.util.List;

public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) throws IOException {
        this.accountRepository = accountRepository;
    }

    /* 수입/지출 추가*/
    public void addExpand(Account account) {
        accountRepository.save(account);
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

    public void updateById(Account account) {
        accountRepository.update(account);
    }

    /*목록 지우기*/
    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }
}

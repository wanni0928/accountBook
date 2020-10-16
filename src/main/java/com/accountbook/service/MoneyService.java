package com.accountbook.service;

import com.accountbook.domain.Account;
import com.accountbook.repository.MemoryMoneyRepository;

import java.util.List;

public class MoneyService {
    private final MemoryMoneyRepository moneyRepository = new MemoryMoneyRepository();

    /* 수입/지출 추가*/
    public Long addExpand(Account account) {
        Account expandMoney = moneyRepository.save(account);
        return expandMoney.getId();
    }

    public List<Account> findAll() {
        return moneyRepository.findAll();
    }

    /*목록 지우기*/
    public void deleteExpand(Account account) {
        moneyRepository.deleteById(account.getId());
    }
}

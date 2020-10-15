package com.accountbook.service;

import com.accountbook.domain.Account;
import com.accountbook.repository.MemoryMoneyRepository;
import com.accountbook.repository.MoneyRespository;

import java.util.List;

public class MoneyService {
    private final MoneyRespository moneyRespository = new MemoryMoneyRepository();

    /* 수입/지출 추가*/
    public Long addExpand(Account account) {
        Account expandMoney = moneyRespository.save(account);
        return expandMoney.getId();
    }

    public List<Account> findAll() {
        return moneyRespository.findAll();
    }

    /*목록 지우기*/
    public void deleteExpand(Account account) {
        moneyRespository.deleteById(account.getId());
    }
}

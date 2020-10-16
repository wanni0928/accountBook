package com.accountbook.service;

import com.accountbook.domain.Account;
import com.accountbook.repository.MoneyRepository;
import com.accountbook.repository.MyBatisMoneyRepository;

import java.io.IOException;
import java.util.List;

public class MoneyService {
    private final MoneyRepository moneyRepository = new MyBatisMoneyRepository();

    public MoneyService() throws IOException {
    }

    /* 수입/지출 추가*/
    public Long addExpand(Account account) {
        Account expandMoney = moneyRepository.save(account);
        return expandMoney.getAccountId();
    }

    public List<Account> findAll() {
        return moneyRepository.findAll();
    }

    /*목록 지우기*/
    public void deleteExpand(Account account) {
        moneyRepository.deleteById(account.getAccountId());
    }
}

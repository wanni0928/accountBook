package com.accountbook.repository;

import com.accountbook.model.Account;

public class MoneyService {
    MoneyRespository moneyRespository = new MemoryMoneyRepository();

    /* 수입/지출 추가*/
    public Long addExpand(Account account) {
        Account expandMoney = moneyRespository.save(account);
        return expandMoney.getId();
    }

    /*목록 지우기*/
    public void deleteExpand(Account account) {
        moneyRespository.deleteById(account.getId());
    }
}

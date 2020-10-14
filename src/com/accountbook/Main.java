package com.accountbook;

import com.accountbook.controller.MoneyController;
import com.accountbook.model.Account;
import com.accountbook.repository.MemoryMoneyRepository;
import com.accountbook.repository.MoneyService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MemoryMoneyRepository memoryMoneyRepository = new MemoryMoneyRepository();
        MoneyService moneyService = new MoneyService();
        MoneyController moneyController = new MoneyController(moneyService);

        moneyController.addExpand();
        moneyController.addIncome();

        List<Account> all = memoryMoneyRepository.findAll();
        System.out.println(all);
    }
}

package com.accountbook;

import com.accountbook.controller.AccountController;
import com.accountbook.repository.AccountRepository;
import com.accountbook.repository.MyBatisAccountRepository;
import com.accountbook.service.AccountService;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        AccountRepository accountRepository = new MyBatisAccountRepository();
        AccountService accountService = new AccountService(accountRepository);
        AccountController accountController = new AccountController(accountService);

//        accountController.updateAccount(1L);
//        accountController.addExpand();

        accountController.updateAccount(1L);
    }
}

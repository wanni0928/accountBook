package com.accountbook;

import com.accountbook.controller.AccountController;
import com.accountbook.repository.AccountRepository;
import com.accountbook.service.AccountService;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        // AppConfig
        AppConfig appConfig = new AppConfig();
        AccountRepository accountRepository = appConfig.getAccountRepository();
        AccountService accountService = appConfig.getAccountService();
        AccountController accountController = appConfig.getAccountController();

//        accountController.updateAccount(1L);
//        accountController.addExpand();

        accountController.updateAccount(1L);
    }
}

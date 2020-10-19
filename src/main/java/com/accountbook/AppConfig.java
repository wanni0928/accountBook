package com.accountbook;

import com.accountbook.controller.AccountController;
import com.accountbook.repository.AccountRepository;
import com.accountbook.repository.MyBatisAccountRepository;
import com.accountbook.service.AccountService;

import java.io.IOException;

public class AppConfig {
    private final AccountRepository accountRepository;
    private final AccountService accountService;

    protected AppConfig() throws IOException {
        accountRepository = getAccountRepository();
        accountService = getAccountService();
    }

    public AccountRepository getAccountRepository() throws IOException {
        return new MyBatisAccountRepository();
    }

    public AccountService getAccountService() throws IOException {
        return new AccountService(accountRepository);
    }

    public AccountController getAccountController() throws IOException {
        return new AccountController(accountService);
    }
}

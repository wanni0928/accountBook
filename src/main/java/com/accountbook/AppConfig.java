package com.accountbook;

import com.accountbook.controller.AccountController;
import com.accountbook.controller.StatisticsController;
import com.accountbook.repository.AccountRepository;
import com.accountbook.repository.MyBatisAccountRepository;
import com.accountbook.service.AccountService;
import com.accountbook.utils.CalendarUtil;

import java.io.IOException;

public class AppConfig {
    private final AccountRepository accountRepository;
    private final AccountService accountService;
    private final CalendarUtil calendarUtil;

    public AppConfig() throws IOException {
        accountRepository = getAccountRepository();
        accountService = getAccountService();
        calendarUtil = new CalendarUtil();
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

    public StatisticsController getStatisticsController() {
        return new StatisticsController(calendarUtil, accountService);
    }
}

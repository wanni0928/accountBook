package com.accountbook;

import com.accountbook.controller.AccountController;
import com.accountbook.controller.CategoryController;
import com.accountbook.controller.SearchController;
import com.accountbook.controller.StatisticsController;
import com.accountbook.repository.AccountRepository;
import com.accountbook.repository.CategoryRepository;
import com.accountbook.repository.MyBatisAccountRepository;
import com.accountbook.repository.MyBatisCategoryRepository;
import com.accountbook.service.AccountService;
import com.accountbook.service.CategoryService;
import com.accountbook.utils.CalendarUtil;

import java.io.IOException;

public class AppConfig {
    private final AccountRepository accountRepository;
    private final AccountService accountService;
    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;
    private final CalendarUtil calendarUtil;

    public AppConfig() throws IOException {
        accountRepository = getAccountRepository();
        accountService = getAccountService();
        categoryRepository = getCategoryRepository();
        categoryService = getCategoryService();
        calendarUtil = new CalendarUtil();
    }

    private CategoryService getCategoryService() {
        return new CategoryService(categoryRepository);
    }

    private CategoryRepository getCategoryRepository() throws IOException {
        return new MyBatisCategoryRepository();
    }


    private AccountRepository getAccountRepository() throws IOException {
        return new MyBatisAccountRepository();
    }

    private AccountService getAccountService() throws IOException {
        return new AccountService(accountRepository);
    }

    public AccountController getAccountController() throws IOException {
        return new AccountController(accountService);
    }

    public CategoryController getCategoryController() throws IOException {
        return new CategoryController(categoryService);
    }

    public StatisticsController getStatisticsController() {
        return new StatisticsController(calendarUtil, accountService);
    }

    public SearchController getSearchController() {
        return new SearchController(accountService, calendarUtil, categoryService);
    }
}

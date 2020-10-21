package com.accountbook.client.router.print.account;

import com.accountbook.client.cache.Cache;
import com.accountbook.controller.AccountController;
import com.accountbook.controller.CategoryController;
import com.accountbook.controller.SearchController;
import com.accountbook.controller.StatisticsController;

import java.util.Scanner;

public class AccountsReports {
    private final AccountController accountController;
    private final CategoryController categoryController;
    private final SearchController searchController;
    private final StatisticsController statisticsController;
    private final Scanner scanner;
    private final Cache cache;

    public AccountsReports(AccountController accountController, CategoryController categoryController, SearchController searchController, StatisticsController statisticsController, Scanner scanner, Cache cache) {
        this.accountController = accountController;
        this.categoryController = categoryController;
        this.searchController = searchController;
        this.statisticsController = statisticsController;
        this.scanner = scanner;
        this.cache = cache;
    }
}

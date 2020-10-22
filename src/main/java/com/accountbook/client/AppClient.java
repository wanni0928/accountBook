package com.accountbook.client;

import com.accountbook.AppConfig;
import com.accountbook.client.cache.Cache;
import com.accountbook.client.cache.MemoryCache;
import com.accountbook.client.router.AppRouter;
import com.accountbook.controller.AccountController;
import com.accountbook.controller.CategoryController;
import com.accountbook.controller.SearchController;
import com.accountbook.controller.StatisticsController;
import com.accountbook.utils.CalendarUtil;

import java.io.IOException;
import java.util.Scanner;

public class AppClient {
    private final AppConfig appConfig;
    private final AccountController accountController;
    private final CategoryController categoryController;
    private final Scanner scanner;
    private final SearchController searchController;
    private final StatisticsController statisticsController;
    private final CalendarUtil calendarUtil;
    private final Cache cache;

    public AppClient() throws IOException {
        this.appConfig = new AppConfig();
        this.accountController = appConfig.getAccountController();
        this.categoryController = appConfig.getCategoryController();
        this.searchController = appConfig.getSearchController();
        this.statisticsController = appConfig.getStatisticsController();
        this.calendarUtil = appConfig.getCalendarUtil();
        this.scanner = new Scanner(System.in);
        this.cache = new MemoryCache(accountController, categoryController);
    }

    public void run(){
        cache.update();
        new AppRouter(accountController, categoryController, searchController, statisticsController, scanner, cache, calendarUtil).showMainMenu();
    };
}

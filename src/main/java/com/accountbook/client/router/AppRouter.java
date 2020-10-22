package com.accountbook.client.router;

import com.accountbook.client.cache.Cache;
import com.accountbook.client.router.input.account.InputAccount;
import com.accountbook.client.router.input.category.InputCategory;
import com.accountbook.client.router.print.account.AccountsReports;
import com.accountbook.controller.AccountController;
import com.accountbook.controller.CategoryController;
import com.accountbook.controller.SearchController;
import com.accountbook.controller.StatisticsController;
import com.accountbook.utils.CalendarUtil;

import java.util.Scanner;

public class AppRouter implements Router {
    private final AccountController accountController;
    private final CategoryController categoryController;
    private final SearchController searchController;
    private final StatisticsController statisticsController;
    private final Scanner scanner;
    private final Cache cache;
    private final CalendarUtil calendarUtil;

    public AppRouter(AccountController accountController, CategoryController categoryController, SearchController searchController, StatisticsController statisticsController, Scanner scanner, Cache cache, CalendarUtil calendarUtil) {
        this.accountController = accountController;
        this.categoryController = categoryController;
        this.searchController = searchController;
        this.statisticsController = statisticsController;
        this.scanner = scanner;
        this.cache = cache;
        this.calendarUtil = calendarUtil;
    }

    @Override
    public void showReports() {
        new AccountsReports(accountController, categoryController, searchController, statisticsController, scanner, cache, calendarUtil);
    }

    @Override
    public void showAccountForms() {
        new InputAccount(accountController, scanner, cache).showInputAccount();
    }

    @Override
    public void showCategoryForms() {
        new InputCategory(categoryController, scanner, cache).showInputCategory();
    }

    @Override
    public void showMainMenu() {
        System.out.println("가계부를 실행하셨네요.");
        while (true) {
            System.out.println("선택하고 싶은 메뉴를 고르세요. 프로그램을 종료하고 싶으면 -1을 입력하세요");
            System.out.println("1. 가계부 편집");
            System.out.println("2. 가계부 조회");
            System.out.println("3. 카테고리 편집");
            String choice = scanner.nextLine();
            switch (choice) {
                case "-1":
                    System.out.println("bye");
                    System.exit(0);
                    break;
                case "1":
                    showAccountForms();
                    break;
                case "2":
                    showReports();
                    break;
                case "3":
                    showCategoryForms();
                    break;
                default:
                    System.out.println("뭐하세요...?");
                    break;
            }
        }
    }
}


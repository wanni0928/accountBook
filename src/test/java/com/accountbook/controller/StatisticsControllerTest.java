package com.accountbook.controller;

import com.accountbook.AppConfig;
import com.accountbook.domain.Account;
import com.accountbook.domain.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class StatisticsControllerTest {
    @Test
    @DisplayName("가계부 전 내용의 합계를 구한다. (소비면 -, 수입은 +)")
    void totalSum() throws IOException {
        StatisticsController statisticsController = new AppConfig().getStatisticsController();
        int totalSum = statisticsController.totalSum();
        System.out.println(totalSum);
    }

    @Test
    @DisplayName("가계부에서 월 소비, 수입의 합계를 구한다.")
    void monthlySum() throws IOException {
        StatisticsController statisticsController = new AppConfig().getStatisticsController();
        Map<String, Integer> map = new HashMap<>();
        int year = 2020;
        int month = 9;
        int monthlySum = statisticsController.monthlyTotalSum(map, year, month);
        System.out.println(monthlySum);
    }

    @Test
    @DisplayName("가계부에서 일별 소비, 수입의 합계를 구한다.")
    void dailySum() throws IOException {
        StatisticsController statisticsController = new AppConfig().getStatisticsController();
        Map<String, Integer> map = new HashMap<>();
        int year = 2020;
        int month = 9;
        int day = 20;
        int dailyTotalSum = statisticsController.dailyTotalSum(map, year, month, day);
        System.out.println(dailyTotalSum);
    }

    @Test
    @DisplayName("분야별 출력")
    void printCategoryList() throws IOException {
        AccountController accountController = new AppConfig().getAccountController();
        StatisticsController statisticsController = new AppConfig().getStatisticsController();
        CategoryController categoryController = new AppConfig().getCategoryController();

        List<Account> accounts = accountController.findAll();
        List<Category> categories = categoryController.findAll();
        Map<String, List<Account>> categoryTotalList = accountController.categoryTotalList(categories, accounts);

        int categorySum = statisticsController.totalCategorySum(categoryTotalList, categories.get(6));
        System.out.println(categorySum);
    }

    @Test
    @DisplayName("전체 평균")
    void totalAVG() throws IOException {
        AccountController accountController = new AppConfig().getAccountController();
        StatisticsController statisticsController = new AppConfig().getStatisticsController();
        CategoryController categoryController = new AppConfig().getCategoryController();

        List<Account> accounts = accountController.findAll();
        int totalSum = statisticsController.totalSum();

        int totalAvg = statisticsController.totalAvg(totalSum, accounts.size());
        System.out.println(totalAvg);
    }

    @Test
    @DisplayName("월별 평균")
    void monthlyAVG() throws IOException {
        StatisticsController statisticsController = new AppConfig().getStatisticsController();
        AccountController accountController = new AppConfig().getAccountController();

        Map<String, Integer> map = new HashMap<>();
        int year = 2020;
        int month = 9;

        List<Account> controllerByMonth = accountController.findByMonth(map, year, month);
        int monthlySum = statisticsController.monthlyTotalSum(map, year, month);
        int monthlyAVG = statisticsController.totalAvg(monthlySum, controllerByMonth.size());
        System.out.println(monthlyAVG);
    }

    @Test
    @DisplayName("일별 평균")
    void dailyAVG() throws IOException {
        StatisticsController statisticsController = new AppConfig().getStatisticsController();
        AccountController accountController = new AppConfig().getAccountController();

        Map<String, Integer> map = new HashMap<>();
        int year = 2020;
        int month = 9;
        int day = 20;

        List<Account> controllerByDay = accountController.findByDay(map, year, month, day);
        int dailyTotalSum = statisticsController.dailyTotalSum(map, year, month, day);
        int dailyAVG = statisticsController.totalAvg(dailyTotalSum, controllerByDay.size());
        System.out.println(dailyAVG);
    }

    @Test
    @DisplayName("카테고리별 평균")
    void categoryAVG() throws IOException {
        AccountController accountController = new AppConfig().getAccountController();
        StatisticsController statisticsController = new AppConfig().getStatisticsController();
        CategoryController categoryController = new AppConfig().getCategoryController();

        List<Account> accounts = accountController.findAll();
        List<Category> categories = categoryController.findAll();
        Map<String, List<Account>> categoryTotalList = accountController.categoryTotalList(categories, accounts);

        int categorySum = statisticsController.totalCategorySum(categoryTotalList, categories.get(3));
        System.out.println(categories.get(3));
        int categoryAVG = statisticsController.totalAvg(categorySum, categoryTotalList.get(categories.get(3).getCategoryName()).size());
        System.out.println(categoryAVG);
    }
}
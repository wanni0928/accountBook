package com.accountbook.controller;

import com.accountbook.AppConfig;
import com.accountbook.domain.Account;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatisticsControllerTest {
    @Test
    @DisplayName("카테고리별 + 수입 합계")
    void categorySum() throws IOException {
        AppConfig appConfig = new AppConfig();
        AccountController accountController = appConfig.getAccountController();
        StatisticsController statisticsController = appConfig.getStatisticsController();

        List<Account> accounts = accountController.findAll();
        int sum = statisticsController.categorySum(accounts, "수입", "에고...");
        assertEquals(sum, 100000);
    }
}
package com.accountbook;

import com.accountbook.controller.AccountController;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        // AppConfig
        AppConfig appConfig = new AppConfig();
        AccountController accountController = appConfig.getAccountController();

//        accountController.updateAccount(1L);
//        accountController.addExpand();

        accountController.updateAccount(1L);
    }
}

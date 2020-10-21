package com.accountbook.client.router.input.account;

import com.accountbook.AppConfig;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

class InputAccountAccountTest {

    @Test
    void save() throws IOException {
        new InputAccount(new AppConfig().getAccountController(), new Scanner(System.in));
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }
}
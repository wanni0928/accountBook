package com.accountbook;

import com.accountbook.client.AppClient;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        new AppClient().run();
    }
}

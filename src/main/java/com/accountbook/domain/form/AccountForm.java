package com.accountbook.domain.form;

import lombok.Getter;

@Getter
public class AccountForm {
    private Long categoryId;
    private String accountTitle;
    private String accountContent;
    private int accountBalance;

    public AccountForm() {
    }

    public void createAccountForm(String... values) {
        this.categoryId = Long.parseLong(values[0]);
        this.accountTitle = values[1];
        this.accountContent = values[2];
        this.accountBalance = Integer.parseInt(values[3]);
    }

    public void createAccountForm(Long categoryId, String accountTitle, String accountContent, int accountBalance) {
        this.categoryId = categoryId;
        this.accountTitle = accountTitle;
        this.accountContent = accountContent;
        this.accountBalance = accountBalance;
    }
}

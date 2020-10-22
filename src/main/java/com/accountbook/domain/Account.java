package com.accountbook.domain;

import com.accountbook.domain.form.AccountForm;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Account {
    private Long accountId;
    private Long categoryId;
    private String accountTitle;
    private String accountContent;
    private int accountBalance;
    private String accountStatus;
    private LocalDateTime accountDate;

    public Account() {
    }

    public void createAccount(AccountForm accountForm) {
        this.categoryId = accountForm.getCategoryId();
        this.accountTitle = accountForm.getAccountTitle();
        this.accountContent = accountForm.getAccountContent();
        this.accountBalance = accountForm.getAccountBalance();
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", categoryId=" + categoryId +
                ", accountTitle='" + accountTitle + '\'' +
                ", accountContent='" + accountContent + '\'' +
                ", accountBalance=" + accountBalance +
                ", accountStatus='" + accountStatus + '\'' +
                ", accountDate=" + accountDate +
                '}';
    }
}

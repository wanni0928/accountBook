package com.accountbook.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class Account {
    private Long accountId;
    private String accountTitle;
    private String accountContent;
    private int accountBalance;
    private String accountStatus;
    private String category;
    private LocalDateTime accountDate;

    public Account() {
    }

    public Account(Long accountId, String accountTitle, String accountContent, int accountBalance, String accountStatus, String category, LocalDateTime accountDate) {
        this.accountId = accountId;
        this.accountTitle = accountTitle;
        this.accountContent = accountContent;
        this.accountBalance = accountBalance;
        this.accountStatus = accountStatus;
        this.category = category;
        this.accountDate = accountDate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountTitle='" + accountTitle + '\'' +
                ", accountContent='" + accountContent + '\'' +
                ", accountBalance=" + accountBalance +
                ", accountStatus='" + accountStatus + '\'' +
                ", category='" + category + '\'' +
                ", accountDate=" + accountDate +
                '}';
    }
}

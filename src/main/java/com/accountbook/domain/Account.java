package com.accountbook.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
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

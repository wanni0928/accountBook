package com.accountbook.model;

import java.time.LocalDateTime;

public class Account {
    private Long id;
    private String title;
    private String content;
    private int balance;
    private LocalDateTime localDateTime;
    private AccountStatus accountStatus;

    public Account() {
    }

    public Account(Long id, String title, String content, int balance, LocalDateTime localDateTime, AccountStatus accountStatus) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.balance = balance;
        this.localDateTime = localDateTime;
        this.accountStatus = accountStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", balance=" + balance +
                ", localDateTime=" + localDateTime +
                ", accountStatus=" + accountStatus +
                '}';
    }
}

package com.accountbook.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class Account {
    private Long id;
    private String title;
    private String content;
    private int balance;
    private LocalDateTime localDateTime;
    private AccountStatus accountStatus;
    private Category category;

    public Account() {
    }

    public Account(Long id, String title, String content, int balance, LocalDateTime localDateTime, AccountStatus accountStatus, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.balance = balance;
        this.localDateTime = localDateTime;
        this.accountStatus = accountStatus;
        this.category = category;
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
                ", category=" + category +
                '}';
    }
}

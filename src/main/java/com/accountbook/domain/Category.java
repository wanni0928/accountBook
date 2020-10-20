package com.accountbook.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Category {
    private Long categoryId;
    private String categoryName;
    private String AccountStatus;

    public Category() {
    }

    public Category(String categoryName, String accountStatus) {
        this.categoryName = categoryName;
        AccountStatus = accountStatus;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", AccountStatus='" + AccountStatus + '\'' +
                '}';
    }
}

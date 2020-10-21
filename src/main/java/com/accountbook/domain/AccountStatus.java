package com.accountbook.domain;

public enum AccountStatus {
    EXPAND("소비"), INCOME("수입"), UNASSIGNED("미지정");
    private String keyword;

    AccountStatus(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }
}

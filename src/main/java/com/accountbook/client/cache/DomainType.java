package com.accountbook.client.cache;

public enum DomainType {
    ACCOUNT(1), CATEGORY(2);

    private final Integer key;

    DomainType(Integer key) {
        this.key = key;
    }

    public Integer getKey() {
        return key;
    }
}

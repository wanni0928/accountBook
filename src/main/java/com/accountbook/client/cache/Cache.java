package com.accountbook.client.cache;

import java.util.Map;

public interface Cache {
    void add(DomainType domainType, Object obj);
    void update();
    void set(DomainType domainType, Object obj, int idx);
    void clear(DomainType domainType, Object obj);
    Map<Integer, Object> getCache();
}

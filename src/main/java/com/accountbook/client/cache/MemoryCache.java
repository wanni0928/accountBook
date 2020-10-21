package com.accountbook.client.cache;

import com.accountbook.controller.AccountController;
import com.accountbook.controller.CategoryController;
import com.accountbook.domain.Account;
import com.accountbook.domain.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryCache implements Cache {
    private static final Map<Integer, Object> memoryCache = new HashMap<>();
    private final AccountController accountController;
    private final CategoryController categoryController;

    public MemoryCache(AccountController accountController, CategoryController categoryController) {
        this.accountController = accountController;
        this.categoryController = categoryController;
    }


    @Override
    public void update() {
        List<Account> accounts = accountController.findAll();
        List<Category> categories = categoryController.findAll();
        memoryCache.put(DomainType.ACCOUNT.getKey(), accounts);
        memoryCache.put(DomainType.CATEGORY.getKey(), categories);
    }

    @Override
    public void add(DomainType domainType, Object obj) {
        List<Account> accounts = new ArrayList<>();
        List<Category> categories = new ArrayList<>();
        if(domainType.getKey() == 1) {
            accounts = (List<Account>) memoryCache.get(domainType.getKey());
            accounts.add((Account) obj);
        } else if(domainType.getKey() == 2) {
            categories = (List<Category>) memoryCache.get(domainType.getKey());
            categories.add((Category) obj);
        }
    }

    @Override
    public void set(DomainType domainType, Object obj, int idx) {
        List<Account> accounts = new ArrayList<>();
        List<Category> categories = new ArrayList<>();
        if(domainType.getKey() == DomainType.ACCOUNT.getKey()) {
            accounts = (List<Account>) memoryCache.get(domainType.getKey());
            accounts.set(idx, (Account) obj);
        } else if(domainType.getKey() == DomainType.CATEGORY.getKey()) {
            categories = (List<Category>) memoryCache.get(domainType.getKey());
            categories.set(idx, (Category) obj);
        }
    }

    @Override
    public void clear(DomainType domainType, Object obj) {
        memoryCache.clear();
    }

    @Override
    public Map<Integer, Object> getCache() {
        return memoryCache;
    }

}

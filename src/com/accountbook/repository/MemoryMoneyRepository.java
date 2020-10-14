package com.accountbook.repository;

import com.accountbook.model.Account;

import java.util.*;

public class MemoryMoneyRepository implements MoneyRespository {
    private static Map<Long, Account> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Account save(Account account) {
        account.setId(++sequence);
        store.put(account.getId(), account);
        return account;
    }

    @Override
    public Optional<Account> findByTitle(String name) {
        return store.values().stream().filter(account -> account.getTitle().equals(name)).findAny();
    }

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }

    public void clear() {
        store.clear();
    }
}

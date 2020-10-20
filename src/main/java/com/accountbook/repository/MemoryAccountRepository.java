package com.accountbook.repository;

import com.accountbook.domain.Account;

import java.util.*;

public class MemoryAccountRepository implements AccountRepository {
    private static Map<Long, Account> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public int save(Account account) {
        account.setAccountId(++sequence);
        store.put(account.getAccountId(), account);
        return 0;
    }

    @Override
    public Optional<Account> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Account> findByTitle(String name) {
//        return store.values().stream().filter(account -> account.getAccountTitle().equals(name)).findAny();
        return null;
    }

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public int update(Account account) {

        return 1;
    }

    @Override
    public int deleteById(Long id) {
        store.remove(id);
        return 1;
    }

    public void clear() {
        store.clear();
    }
}

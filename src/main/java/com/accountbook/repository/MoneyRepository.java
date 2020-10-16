package com.accountbook.repository;

import com.accountbook.domain.Account;

import java.util.List;
import java.util.Optional;

public interface MoneyRepository {
    Account save(Account account);
    Optional<Account> findByTitle(String name);
    List<Account> findAll();
    void deleteById(Long id);
}

package com.accountbook.repository;

import com.accountbook.domain.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {
    int save(Account account);
    Optional<Account> findById(Long id);
    List<Account> findByTitle(String title);
    List<Account> findAll();
    int update(Account account);
    int deleteById(Long id);
}

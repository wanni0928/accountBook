package com.accountbook.repository;

import com.accountbook.domain.Account;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AccountRepository {
    int save(Account account);
    Optional<Account> findById(Long id);
    List<Account> findByTitle(String title);
    List<Account> findAll();
    List<Account> findByMonth(Map<String, Integer> map, int year, int month);
    List<Account> findByDay(Map<String, Integer> map, int year, int month, int day);
    int update(Account account);
    int deleteById(Long id);
}

package com.accountbook.repository;

import com.accountbook.domain.Account;
import com.accountbook.utils.factory.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class MyBatisMoneyRepository implements MoneyRepository {
    SqlSessionFactory sqlSessionFactory = MyBatisSqlSessionFactory.getInstance();
    SqlSession session = sqlSessionFactory.openSession();

    public MyBatisMoneyRepository() throws IOException {

    }

    @Override
    public Account save(Account account) {
        return null;
    }

    @Override
    public Optional<Account> findByTitle(String name) {
        return Optional.empty();
    }

    @Override
    public List<Account> findAll() {
        return session.selectList("Account.findAll");
    }

    @Override
    public void deleteById(Long id) {

    }
}

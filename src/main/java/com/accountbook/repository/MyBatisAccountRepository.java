package com.accountbook.repository;

import com.accountbook.domain.Account;
import com.accountbook.utils.factory.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MyBatisAccountRepository implements AccountRepository {
    private SqlSession session;
    private final SqlSessionFactory sqlSessionFactory;

    public MyBatisAccountRepository() throws IOException {
        sqlSessionFactory = MyBatisSqlSessionFactory.getInstance();
//        session = sqlSessionFactory.openSession();
    }


    @Override
    public int save(Account account) {
        session = sqlSessionFactory.openSession();
        int savedNum = session.insert("Account.save", account);
        session.commit();
        session.close();

        return savedNum;
    }

    @Override
    public Optional<Account> findById(Long id) {
        session = sqlSessionFactory.openSession();
        Optional<Account> optional = Optional.ofNullable(session.selectOne("Account.findById", id));
        session.commit();
        session.close();

        return optional;
    }

    @Override
    public List<Account> findByTitle(String title) {
        session = sqlSessionFactory.openSession();
        List<Account> accounts = session.selectList("Account.findByTitle", title);
        session.commit();
        session.close();

        return accounts;
    }

    @Override
    public List<Account> findAll() {
        session = sqlSessionFactory.openSession();
        List<Account> accounts = session.selectList("Account.findAll");
        session.commit();
        session.close();

        return accounts;
    }

    @Override
    public List<Account> findByMonth(Map<String, Integer> map, int year, int month) {
        session = sqlSessionFactory.openSession();
        map.put("year", year);
        map.put("month", month);
        List<Account> accounts = session.selectList("Account.findByMonth", map);
        session.commit();
        session.close();
        return accounts;
    }

    @Override
    public List<Account> findByDay(Map<String, Integer> map, int year, int month, int day) {
        session = sqlSessionFactory.openSession();
        map.put("year", year);
        map.put("month", month);
        map.put("day", day);
        List<Account> accounts = session.selectList("Account.findByDay", map);
        session.commit();
        session.close();
        return accounts;
    }

    @Override
    public int update(Account account) {
        session = sqlSessionFactory.openSession();
        int updateId = session.update("Account.updateById", account);
        session.commit();
        session.close();

        return updateId;
    }

    @Override
    public int deleteById(Long id) {
        session = sqlSessionFactory.openSession();
        int deletedId = session.delete("Account.deleteById", id);
        session.commit();
        session.close();

        return deletedId;
    }
}

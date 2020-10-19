package com.accountbook.repository;

import com.accountbook.domain.Account;
import com.accountbook.utils.factory.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;
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
        int savedId = session.insert("Account.save", account);
        session.commit();
        session.close();

        return savedId;
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
    public Long update(Account account) {
        session = sqlSessionFactory.openSession();
        int updateId = session.update("Account.updateById", account);
        session.commit();
        session.close();

        return Long.valueOf(updateId);
    }

    @Override
    public Long deleteById(Long id) {
        session = sqlSessionFactory.openSession();
        int deletedId = session.delete("Account.deleteById", id);
        session.commit();
        session.close();

        return Long.valueOf(deletedId);
    }
}

package com.accountbook.repository;

import com.accountbook.domain.Category;
import com.accountbook.utils.factory.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class MyBatisCategoryRepository implements CategoryRepository {
    private SqlSession session;
    private final SqlSessionFactory sqlSessionFactory;

    public MyBatisCategoryRepository() throws IOException {
        sqlSessionFactory = MyBatisSqlSessionFactory.getInstance();
    }

    @Override
    public int save(Category category) {
        session = sqlSessionFactory.openSession();
        int saveNum = session.insert("Category.save", category);
        session.commit();
        session.close();
        return saveNum;
    }

    @Override
    public Optional<Category> findById(Long id) {
        session = sqlSessionFactory.openSession();
        Optional<Category> category = Optional.ofNullable(session.selectOne("Category.findById", id));
        session.commit();
        session.close();
        return category;
    }

    @Override
    public List<Category> findByTitle(String categoryName) {
        session = sqlSessionFactory.openSession();
        List<Category> categories = session.selectList("Category.findByTitle", categoryName);
        session.commit();
        session.close();
        return categories;
    }

    @Override
    public List<Category> findAll() {
        session = sqlSessionFactory.openSession();
        List<Category> categories = session.selectList("Category.findAll");
        session.commit();
        session.close();
        return categories;
    }

    @Override
    public int update(Category category) {
        session = sqlSessionFactory.openSession();
        int update = session.update("Category.updateById", category);
        session.commit();
        session.close();
        return update;
    }

    @Override
    public int deleteById(Long id) {
        session = sqlSessionFactory.openSession();
        int delete = session.delete("Category.deleteById", id);
        session.commit();
        session.close();
        return delete;
    }
}

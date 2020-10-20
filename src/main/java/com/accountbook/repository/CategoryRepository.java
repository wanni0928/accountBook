package com.accountbook.repository;

import com.accountbook.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    int save(Category category);
    Optional<Category> findById(Long id);
    List<Category> findByTitle(String categoryName);
    List<Category> findAll();
    int update(Category category);
    int deleteById(Long id);
}

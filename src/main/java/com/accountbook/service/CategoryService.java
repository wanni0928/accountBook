package com.accountbook.service;

import com.accountbook.domain.Category;
import com.accountbook.repository.CategoryRepository;

import java.util.List;

public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public int save(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public List<Category> findByTitle(String categoryName) {
        return categoryRepository.findByTitle(categoryName);
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public int update(Category category) {
        return categoryRepository.update(category);
    }

    public int delete(Long id) {
        return categoryRepository.deleteById(id);
    }
}

package com.accountbook.controller;

import com.accountbook.domain.Category;
import com.accountbook.domain.form.CategoryForm;
import com.accountbook.service.CategoryService;

import java.util.List;

public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // 카테고리 추가
    public int addCategory(CategoryForm categoryForm) {
        Category category = new Category();
        category.createCategory(categoryForm);
        return categoryService.save(category);
    }
    // 카테고리 수정
    public int updateCategory(Long id, Category category){
        Category currentCategory = categoryService.findById(id);
        currentCategory.setCategoryName(category.getCategoryName());
        currentCategory.setAccountStatus(category.getAccountStatus());
        return categoryService.update(currentCategory);
    }

    // 카테고리 검색
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    public Category findById(Long id) {
        return categoryService.findById(id);
    }

    public List<Category> findByTitle(String categoryName) {
        return categoryService.findByTitle(categoryName);
    }

    // 카테고리 삭제
    public int deleteCategory(Long id){
        return categoryService.delete(id);
    }
}

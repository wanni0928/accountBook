package com.accountbook.controller;

import com.accountbook.domain.Category;
import com.accountbook.service.CategoryService;

import java.util.List;

public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // 카테고리 추가
    public void addCategory(Category category) {
        categoryService.save(category);
    }
    // 카테고리 수정
    public void updateCategory(Long id, Category category){
        Category currentCategory = categoryService.findById(id);
        currentCategory.setCategoryName(category.getCategoryName());
        currentCategory.setAccountStatus(category.getAccountStatus());
        categoryService.update(currentCategory);
    }

    // 카테고리 검색
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    public List<Category> findByTitle(String categoryName) {
        return categoryService.findByTitle(categoryName);
    }

    // 카테고리 삭제
    public int deleteCategory(Long id){
        return categoryService.delete(id);
    }
}

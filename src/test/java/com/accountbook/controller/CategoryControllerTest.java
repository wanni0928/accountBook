package com.accountbook.controller;

import com.accountbook.AppConfig;
import com.accountbook.domain.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryControllerTest {

    @Test
    void addCategory() throws IOException {
        CategoryController categoryController = new AppConfig().getCategoryController();
        categoryController.addCategory(new Category("비상금", "수입"));
    }

    @Test
    void updateCategory() throws IOException {
        CategoryController categoryController = new AppConfig().getCategoryController();
        categoryController.updateCategory(1L, new Category("월급", "수입"));
    }

    @Test
    @DisplayName("입력된 모든 카테고리를 반환한다.")
    void findAll() throws IOException {
        CategoryController categoryController = new AppConfig().getCategoryController();
        List<Category> categories = categoryController.findAll();
    }

    @Test
    void findByTitle() throws IOException {
        CategoryController categoryController = new AppConfig().getCategoryController();
        List<Category> categories = categoryController.findByTitle("미지정");
        for (Category category : categories) {
            assertEquals(category.getCategoryName(), "미지정");
        }
    }

    @Test
    void deleteCategory() throws IOException {
        CategoryController categoryController = new AppConfig().getCategoryController();
        System.out.println(categoryController.deleteCategory(2L));
    }
}
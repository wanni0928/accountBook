package com.accountbook.domain;

import com.accountbook.domain.form.CategoryForm;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Category {
    private Long categoryId;
    private String categoryName;
    private String accountStatus;

    public Category() {
    }

    public Category(Long categoryId, String categoryName, String accountStatus) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.accountStatus = accountStatus;
    }

    public void createCategory(CategoryForm categoryForm) {
        this.categoryName = categoryForm.getCategoryName();
        this.accountStatus = categoryForm.getAccountStatus();
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", AccountStatus='" + accountStatus + '\'' +
                '}';
    }
}

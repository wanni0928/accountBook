package com.accountbook.domain.form;

import lombok.Getter;

@Getter
public class CategoryForm {
    private String categoryName;
    private String accountStatus;

    public CategoryForm() {
    }

    public void createCategoryForm(String categoryName, String accountStatus) {
        this.categoryName = categoryName;
        this.accountStatus = accountStatus;
    }
}

package com.accountbook.client.router.input.category;

import com.accountbook.domain.form.CategoryForm;

public interface Create {
    boolean save(CategoryForm categoryForm);
}

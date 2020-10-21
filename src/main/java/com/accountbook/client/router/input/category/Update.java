package com.accountbook.client.router.input.category;

import com.accountbook.domain.Category;

public interface Update {
    boolean update(Long id, Category category);
}
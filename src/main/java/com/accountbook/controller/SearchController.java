package com.accountbook.controller;

import com.accountbook.service.AccountService;
import com.accountbook.service.CategoryService;
import com.accountbook.utils.CalendarUtil;

public class SearchController {
    private final AccountService accountService;
    private final CalendarUtil calendarUtil;
    private final CategoryService categoryService;

    public SearchController(AccountService accountService, CalendarUtil calendarUtil, CategoryService categoryService) {
        this.accountService = accountService;
        this.calendarUtil = calendarUtil;
        this.categoryService = categoryService;
    }
}

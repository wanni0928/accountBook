package com.accountbook.client.router.print.account;

public interface Search {
    // 가계부 제목으로 검색
    void findByTitle();

    // 가계부 내용으로 검색
    void findByContent();

    // 가계부 카테고리로 검색
    void searchByCategory();

    // 가계부 날짜로 검색
    void searchByDate();
    
    // 카테고리 번호를 카테고리 이름으로 변환
    String getCategoryName(Long id);
}

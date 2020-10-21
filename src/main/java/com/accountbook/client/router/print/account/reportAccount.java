package com.accountbook.client.router.print.account;

public interface reportAccount {
    // 연간 수입, 지출 리포트
    void showAnnualReport();

    // 연간 카테고리 리포트
    void showAnnualCategoryReport();

    // 모든 기간 리포트
    void showEntireReport();

    // 모든 카테고리 리포트
    void showCategoryReport();

    // 잔액 추이 보고서
    void showBalanceReport();
}

package com.accountbook.client.router.print.account;

public interface Report {
    // 연간 수입, 지출 리포트
    void showAnnualReport();

    // 연간 카테고리 리포트
    void showAnnualCategoryReport();

    // 연간 소비 리포트
    void showAnnualExpenseReport();

    // 연간 수입 리포트
    void showAnnualIncomeReport();

    // 월간 수입, 지출 리포트
    void showMonthlyReport();

    // 월간 소비 리포트
    void showMonthlyExpenseReport();

    // 월간 수입 리포트
    void showMonthlyIncomeReport();

    // 연간 전체 리포트
    void showAnnualEntireReport();

    // 월간 전체 리포트
    void showMonthlyEntireReport();

    // 모든 카테고리 리포트
    void showCategoryReport();

    // 잔액 추이 보고서
    void showBalanceReport();
}

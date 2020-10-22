package com.accountbook.client.router.print.account;

import com.accountbook.client.cache.Cache;
import com.accountbook.client.cache.DomainType;
import com.accountbook.controller.AccountController;
import com.accountbook.controller.CategoryController;
import com.accountbook.controller.SearchController;
import com.accountbook.controller.StatisticsController;
import com.accountbook.domain.Account;
import com.accountbook.domain.AccountStatus;
import com.accountbook.domain.Category;
import com.accountbook.utils.CalendarUtil;

import java.util.List;
import java.util.Scanner;

public class AccountsReports implements Report, Search, Menu {
    private final AccountController accountController;
    private final CategoryController categoryController;
    private final SearchController searchController;
    private final StatisticsController statisticsController;
    private final Scanner scanner;
    private final Cache cache;
    private final CalendarUtil calendarUtil;

    private final List<Account> accounts;
    private final List<Category> categories;

    public AccountsReports(AccountController accountController, CategoryController categoryController, SearchController searchController, StatisticsController statisticsController, Scanner scanner, Cache cache, CalendarUtil calendarUtil) {
        this.accountController = accountController;
        this.categoryController = categoryController;
        this.searchController = searchController;
        this.statisticsController = statisticsController;
        this.scanner = scanner;
        this.cache = cache;
        this.calendarUtil = calendarUtil;

        accounts = (List<Account>) cache.getCache().get(DomainType.ACCOUNT.getKey());
        categories = (List<Category>) cache.getCache().get(DomainType.CATEGORY.getKey());

        showReportsMenu();
    }

    @Override
    public void showReportsMenu() {
        showReportsMenu:
        while (true) {
            String input = "";
            System.out.println("<가계부 조회 메뉴> 이용하고 싶은 메뉴를 번호로 입력하세요.");
            System.out.println("1. 연간 보고서");
            System.out.println("2. 월간 보고서");
            System.out.println("3. 카테고리별 보고서");
            input = scanner.nextLine();
            switch (input){
                case "-1":
                    System.out.println("가계부 조회 메뉴를 종료합니다.");
                    break showReportsMenu;
                case "1":
                    // 연간 보고서 -> 소비, 수입, 소비 + 수입, 카테고리 + 액수
                    showAnnualReport();
                    break;
                case "2":
                    // 월간 보고서 -> 소비, 수입, 소비 + 수입, 카테고리 + 액수
                    showMonthlyReport();
                    break;
                case "3":
                    showCategoryReport();
                    break;
                default:
                    System.out.println("뭐함..?");
                    break;
            }
        }
    }

    @Override
    public void showAnnualReport() {
        // 소비, 수입, 소비 + 수입, 카테고리 + 액수

        annualReport:
        while (true){
            String input;
            System.out.println("<연간 보고서> 메뉴에 입장 하였습니다. 확인하고 싶은 항목을 번호로 입력하세요. 해당 메뉴를 종료하고 싶으면 -1을 입력하세요.");
            System.out.println("1. 연간 소비 보고서");
            System.out.println("2. 연간 수입 보고서");
            System.out.println("3. 연간 소비, 수입 합계");
            input = scanner.nextLine();

            switch (input){
                case "-1":
                    System.out.println("연간 보고서 메뉴를 종료합니다.");
                    break annualReport;
                case "1":
                    showAnnualExpenseReport();
                    break;
                case "2":
                    showAnnualIncomeReport();
                    break;
                case "3":
                    showAnnualEntireReport();
                    break;
            }
        }
    }

    @Override
    public void showAnnualCategoryReport() {
    }

    /**
     * 1. 연간 소비 목록
     * 2. 연간 소비 합계
     * 3. 연간 소비 월 평균 (합계 / 12)
     */
    @Override
    public void showAnnualExpenseReport() {
        String input = "";
        System.out.println("<연간 소비 보고서>");
        System.out.println("확인하고 싶은 연도를 입력하세요.");
        input = scanner.nextLine();
        // 연간 소비 목록 출력
        List<Account> annualExpenseList = statisticsController.getAnnualList(Integer.parseInt(input), accounts, AccountStatus.EXPAND.getKeyword());
        int sum = statisticsController.totalSum(annualExpenseList);
        int avg = statisticsController.totalAvg(sum, annualExpenseList.size());

        for (Account account : annualExpenseList) {
            String categoryName = getCategoryName(account.getCategoryId());
            System.out.println("제목 : " + account.getAccountTitle() + " / 내용 : " + account.getAccountContent() + " / 카테고리 이름 : " + categoryName + " / 액수 : " + account.getAccountBalance() + "원");
        }

        System.out.println("연간 소비 합계 : " + sum);
        System.out.println("연간 소비 평균 : " + avg);
    }

    /**
     * 1. 연간 수입 목록
     * 2. 연간 수입 합계
     * 3. 연간 수입 월 평균 (합계 / 12)
     */
    @Override
    public void showAnnualIncomeReport() {
        String input = "";
        System.out.println("<연간 수입 보고서>");
        System.out.println("확인하고 싶은 연도를 입력하세요.");
        input = scanner.nextLine();
        // 연간 소비 목록 출력
        List<Account> annualIncomeList = statisticsController.getAnnualList(Integer.parseInt(input), accounts, AccountStatus.INCOME.getKeyword());
        int sum = statisticsController.totalSum(annualIncomeList);
        int avg = statisticsController.totalAvg(sum, annualIncomeList.size());

        for (Account account : annualIncomeList) {
            String categoryName = getCategoryName(account.getCategoryId());
            System.out.println("제목 : " + account.getAccountTitle() + " / 내용 : " + account.getAccountContent() + " / 카테고리 이름 : " + categoryName + " / 액수 : " + account.getAccountBalance() + " 원");
        }

        System.out.println("연간 수입 합계 : " + sum);
        System.out.println("연간 수입 평균 : " + avg);
    }

    @Override
    public void showMonthlyReport() {
        // 소비, 수입, 소비 + 수입, 카테고리 + 액수
        // 소비, 수입, 소비 + 수입, 카테고리 + 액수

        monthlyReport:
        while (true){
            String input;
            System.out.println("<월간 보고서> 메뉴에 입장 하였습니다. 확인하고 싶은 항목을 번호로 입력하세요. 해당 메뉴를 종료하고 싶으면 -1을 입력하세요.");
            System.out.println("1. 월간 소비 보고서");
            System.out.println("2. 월간 수입 보고서");
            System.out.println("3. 월간 소비, 수입 합계");
            input = scanner.nextLine();

            switch (input){
                case "-1":
                    System.out.println("월간 보고서 메뉴를 종료합니다.");
                    break monthlyReport;
                case "1":
                    showMonthlyExpenseReport();
                    break;
                case "2":
                    showMonthlyIncomeReport();
                    break;
                case "3":
                    showMonthlyEntireReport();
                    break;
            }
        }
    }

    /**
     * 1. 월간 소비 목록
     * 2. 월간 소비 합계
     * 3. 평균
     */
    @Override
    public void showMonthlyExpenseReport() {
        String input = "";
        System.out.println("<월간 소비 보고서>");
        System.out.println("확인하고 싶은 연도를 입력하세요.");
        input = scanner.nextLine();
        int year = Integer.parseInt(input);

        System.out.println("확인하고 싶은 월 수치를 입력하세요.");
        input = scanner.nextLine();
        int month = (Math.abs(Integer.parseInt(input)) % 12) % Integer.MAX_VALUE;

        // 월간 소비 목록 출력
        List<Account> monthlyExpenseList = statisticsController.getMonthlyList(year, month, accounts, AccountStatus.EXPAND.getKeyword());
        int sum = statisticsController.totalSum(monthlyExpenseList);
        int avg = statisticsController.totalAvg(sum, monthlyExpenseList.size());

        for (Account account : monthlyExpenseList) {
            String categoryName = getCategoryName(account.getCategoryId());
            System.out.println("제목 : " + account.getAccountTitle() + " / 내용 : " + account.getAccountContent() + " / 카테고리 이름 : " + categoryName + " / 액수 : " + account.getAccountBalance() + " 원");
        }

        System.out.println("합계 : " + sum);
        System.out.println("평균 : " + avg);
    }

    /**
     * 1. 월간 수입 목록
     * 2. 월간 수입 합계
     * 3. 평균
     */
    @Override
    public void showMonthlyIncomeReport() {
        String input = "";
        System.out.println("<월간 수입 보고서>");
        System.out.println("확인하고 싶은 연도를 입력하세요.");
        input = scanner.nextLine();
        int year = Integer.parseInt(input);

        System.out.println("확인하고 싶은 월 수치를 입력하세요.");
        input = scanner.nextLine();
        int month = (Math.abs(Integer.parseInt(input)) % 12) % Integer.MAX_VALUE;

        // 월간 소비 목록 출력
        List<Account> monthlyIncomeList = statisticsController.getMonthlyList(year, month, accounts, AccountStatus.INCOME.getKeyword());
        int sum = statisticsController.totalSum(monthlyIncomeList);
        int avg = statisticsController.totalAvg(sum, monthlyIncomeList.size());

        for (Account account : monthlyIncomeList) {
            String categoryName = getCategoryName(account.getCategoryId());
            System.out.println("제목 : " + account.getAccountTitle() + " / 내용 : " + account.getAccountContent() + " / 카테고리 이름 : " + categoryName + " / 액수 : " + account.getAccountBalance() + " 원");
        }

        System.out.println("합계 : " + sum);
        System.out.println("평균 : " + avg);
    }

    @Override
    public void showAnnualEntireReport() {
        System.out.println("<연간 소비, 수입 보고서>");
        System.out.println("확인하고 싶은 연도를 입력하세요");
        String input = scanner.nextLine();
        int year = Integer.parseInt(input);

        List<Account> annualIncomList = statisticsController.getAnnualList(year, accounts, AccountStatus.INCOME.getKeyword());
        List<Account> annuaExpenselList = statisticsController.getAnnualList(year, accounts, AccountStatus.EXPAND.getKeyword());

        int expenseSum = statisticsController.totalSum(annuaExpenselList);
        int incomeSum = statisticsController.totalSum(annualIncomList);

        int totalSum = incomeSum - expenseSum;

        System.out.println("총 소비 합계 : " + expenseSum + " 원");
        System.out.println("총 수입 합계 : " + incomeSum + " 원");

        System.out.println("잔액 : + " + totalSum + " 원");
    }

    @Override
    public void showMonthlyEntireReport() {
        String input = "";

        System.out.println("확인하고 싶은 연도를 입력하세요.");
        input = scanner.nextLine();
        int year = Integer.parseInt(input);

        System.out.println("확인하고 싶은 월 수치를 입력하세요.");
        input = scanner.nextLine();
        int month = (Math.abs(Integer.parseInt(input)) % 12) % Integer.MAX_VALUE;

        List<Account> monthlyExpenseList = statisticsController.getMonthlyList(year, month, accounts, AccountStatus.EXPAND.getKeyword());
        List<Account> monthlyIncomeList = statisticsController.getMonthlyList(year, month, accounts, AccountStatus.INCOME.getKeyword());

        int expenseSum = statisticsController.totalSum(monthlyExpenseList);
        int incomeSum = statisticsController.totalSum(monthlyIncomeList);

        int totalSum = incomeSum - expenseSum;

        System.out.println("총 소비 합계 : " + expenseSum + " 원");
        System.out.println("총 수입 합계 : " + incomeSum + " 원");

        System.out.println("잔액 : + " + totalSum + " 원");
    }

    // 카테고리별로 총 합계를 출력
    @Override
    public void showCategoryReport() {
        for (Category category : categories) {
            int categorySum = accounts.stream()
                    .filter(account -> account.getCategoryId().equals(category.getCategoryId()))
                    .mapToInt(Account::getAccountBalance)
                    .sum();
            System.out.println("카테고리 이름 : " + category.getCategoryName() + " 합계 : " + categorySum);
        }
    }

    @Override
    public void showBalanceReport() {

    }

    @Override
    public void findByTitle() {

    }

    @Override
    public void findBySearch() {

    }

    @Override
    public void searchByCategory() {

    }

    @Override
    public void searchByDate() {

    }

    @Override
    public String getCategoryName(Long id) {
        return categories.stream().filter(category -> category.getCategoryId().equals(id)).findAny().orElse(new Category(1L, "미지정", "미지정")).getCategoryName();
    }
}

package com.accountbook.client.router.input.category;

import com.accountbook.client.cache.Cache;
import com.accountbook.client.cache.DomainType;
import com.accountbook.controller.CategoryController;
import com.accountbook.domain.Account;
import com.accountbook.domain.AccountStatus;
import com.accountbook.domain.Category;
import com.accountbook.domain.form.CategoryForm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputCategory implements Create, Delete, Update {
    private final CategoryController categoryController;
    private final Scanner scanner;
    private final Cache cache;
    private List<Account> accounts = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();

    public InputCategory(CategoryController categoryController, Scanner scanner, Cache cache) {
        this.categoryController = categoryController;
        this.scanner = scanner;
        this.cache = cache;
    }

    @Override
    public boolean save(CategoryForm categoryForm) {
        boolean result = false;
        int affectedRowNum = categoryController.addCategory(categoryForm);
        if(affectedRowNum != 0) {
            System.out.println("데이터가 저장 되었습니다.");
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(Long id) {
        boolean result = false;
        int affectedRowNum = categoryController.deleteCategory(id);
        if(affectedRowNum != 0) {
            System.out.println("데이터가 삭제 되었습니다.");
            result = true;
        }
        return result;
    }

    @Override
    public boolean update(Long id, Category category) {
        boolean result = false;
        int affectedRowNum = categoryController.updateCategory(id, category);
        if(affectedRowNum != 0) {
            System.out.println("데이터가 수정 되었습니다.");
            result = true;
        }
        return result;
    }

    public void showInputCategory() {

        inputCategory:
        while (true){
            String input = "";
            System.out.println("<카테고리 입력페이지> 이용하고 싶은 메뉴 번호를 입력 해주세요. 해당 메뉴를 종료하고 싶으면 -1을 입력하세요.");
            System.out.println("1. 추가하기");
            System.out.println("2. 수정하기");
            System.out.println("3. 삭제하기");
            input = scanner.nextLine();
            switch (input){
                case "-1":
                    System.out.println("<카테고리 입력페이지>를 종료 합니다.");
                    break inputCategory;
                case "1":
                    // create
                    showCreateCategory();
                    break;
                case "2":
                    // update
                    showUpdateCategory();
                    break;
                case "3":
                    // delete
                    showDeleteCategory();
                    break;
                default:
                    System.out.println("뭐해? 처음부터 다시해");
                    break;
            }
        }

    }

    private void showCategoryList(List<Category> categories, String finalKeyWord) {
        categories.stream().filter(category -> category.getAccountStatus().equals(finalKeyWord)).forEach(category -> System.out.println(category.getCategoryName() + "("+ category.getCategoryId() +")"));
    }

    public void showCreateCategory() {
        CategoryForm categoryForm = new CategoryForm();
        String input = "";
        categories = (List<Category>) cache.getCache().get(DomainType.CATEGORY.getKey());

        while (true) {
            String categoryName;
            String accountStatus;
            System.out.println("카테고리 추가를 할겁니다. 카테고리 유형을 선택하세요. 이 메뉴를 종료하고 싶으면 -1을 누르세요.");
            System.out.println("1.소비 2.수입 번호로 쓰세요.");
            input = scanner.nextLine();
            if (input.equals("-1")) break;
            accountStatus = input.equals("1") ? AccountStatus.EXPAND.getKeyword() : AccountStatus.INCOME.getKeyword();
            System.out.println("넣고 싶은 카테고리 이름을 입력하세요");
            categoryName = scanner.nextLine();

            categoryForm.createCategoryForm(categoryName, accountStatus);
            System.out.println("입력 내용은 다음과 같습니다. 저장하고 싶으시면 q를 누르세요. 다시 입력하고 싶으면 아무 키나 입력 하시죠");
            System.out.println(categoryForm.getCategoryName());
            System.out.println(categoryForm.getAccountStatus());
            input = scanner.nextLine();

            if(input.equals("q")){
                save(categoryForm);
                break;
            }
        }
    }
    public void showUpdateCategory() {

        Long id;
        String categoryName;
        String accountStatus;
        String input = "";
        System.out.println(categories);
        while (true){
            System.out.println("카테고리 수정 할겁니다.목록을 보고 카테고리 번호를 쓰세요. 이 메뉴를 종료하고 싶으면 -1을 누르세요.");
            categories = (List<Category>) cache.getCache().get(DomainType.CATEGORY.getKey());
            CategoryForm categoryForm = new CategoryForm();
            System.out.println("소비 카테고리 목록");
            showCategoryList(categories, "소비");
            System.out.println("수입 카테고리 목록");
            showCategoryList(categories, "수입");

            System.out.println("수정하고 싶은 카테고리 번호를 입력하세요.");
            if (input.equals("-1")) break;
            input = scanner.nextLine();
            id = Long.parseLong(input);
            Category category = categoryController.findById(id);
            if(category == null) {
                System.out.println("없는걸 어떻게 고쳐요 다시해요.");
                continue;
            }
            System.out.println("수정하고 싶은 카테고리 제목 입력하세요 (현재 제목 : " + category.getCategoryName() + ")");
            input = scanner.nextLine();
            categoryName = input.equals("") ? category.getCategoryName() : input;

            System.out.println("1.소비 2.수입");
            input = scanner.nextLine();
            accountStatus = input.equals("1") ? AccountStatus.EXPAND.getKeyword() : AccountStatus.INCOME.getKeyword();

            categoryForm.createCategoryForm(categoryName, accountStatus);
            category.createCategory(categoryForm);

            System.out.println("수정하실 내용. 적용할거면 q 아니면 아무키나 누르세요.");
            System.out.println(category.getCategoryName());
            System.out.println(category.getAccountStatus());
            input = scanner.nextLine();
            if(input.equals("q")){
                update(id, category);
                break;
            };
        }
    }
    private void showDeleteCategory() {

        Long id;
        String categoryName;
        String accountStatus;
        String input = "";
        while (!input.equals("q")){
            System.out.println("카테고리 삭제 할겁니다.목록을 보고 카테고리 번호를 쓰세요. 이 메뉴를 종료하고 싶으면 -1을 누르세요.");
            categories = (List<Category>) cache.getCache().get(DomainType.CATEGORY.getKey());
            CategoryForm categoryForm = new CategoryForm();
            System.out.println("소비 목록");
            showCategoryList(categories, AccountStatus.EXPAND.getKeyword());
            System.out.println("수입 목록");
            showCategoryList(categories, AccountStatus.INCOME.getKeyword());

            System.out.println("삭제할 카테고리 번호를 쓰세요.");
            input = scanner.nextLine();

            if(input.equals("-1")) break;

            id = Long.parseLong(input);
            Category category = categoryController.findById(id);

            if(category == null) {
                System.out.println("없는걸 어떻게 삭제해 처음부터 다시해");
                continue;
            }

            System.out.println("지우고자 하는 카테고리 내용은 다음과 같습니다.");
            System.out.println(category.getCategoryId());
            System.out.println(category.getCategoryName());
            System.out.println(category.getAccountStatus());

            System.out.println("지울거면 q, 아니면 아무키나 누르세요");
            input = scanner.nextLine();
            if(input.equals("q")) {
                delete(id);
                break;
            };
        }
    }
}

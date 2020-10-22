package com.accountbook.client.router.input.account;

import com.accountbook.client.cache.Cache;
import com.accountbook.client.cache.DomainType;
import com.accountbook.controller.AccountController;
import com.accountbook.domain.Account;
import com.accountbook.domain.Category;
import com.accountbook.domain.form.AccountForm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputAccount implements Create, Delete, Update {
    private final AccountController accountController;
    private final Scanner scanner;
    private final Cache cache;
    private List<Account> accounts = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();

    public InputAccount(AccountController accountController, Scanner scanner, Cache cache) {
        this.accountController = accountController;
        this.scanner = scanner;
        this.cache = cache;
    }

    @Override
    public boolean save(AccountForm accountForm) {
        boolean result = false;
        int affectedRowNum = accountController.addAccount(accountForm);

        if(affectedRowNum != 0) {
            System.out.println("데이터가 저장 되었습니다.");
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(Long id) {
        boolean result = false;
        int affectedRowNum = accountController.delete(id);
        if(affectedRowNum != 0) {
            System.out.println("데이터가 삭제 되었습니다.");
            result = true;
        }
        return result;
    }

    @Override
    public boolean update(Account account, AccountForm accountForm) {
        boolean result = false;
        int affectedRowNum = accountController.updateAccount(account, accountForm);

        if(affectedRowNum != 0) {
            System.out.println("데이터가 저장 되었습니다.");
            result = true;
        }
        return result;
    }

    public void showInputAccount() {
        String input = "";
        String guidance =
                "\n<가계부 입력페이지> 이용하고 싶은 메뉴 번호를 입력 해주세요. 메뉴를 나가고 싶으시면 -1을 선택하세요.\n" +
                "1. 추가하기\n" +
                        "2. 수정하기\n" +
                        "3. 삭제하기\n";


        inputAccountMenu:
        while (true){
            System.out.println(guidance);
            input = scanner.nextLine();
            switch (input){
                // quit
                case "-1":
                    System.out.println("<가계부 입력페이지> 종료");
                    break inputAccountMenu;
                // create
                case "1":
                    showCreateAccount();
                    break;
                // update
                case "2":
                    showUpdateAccount();
                    break;
                // delete
                case "3":
                    showDeleteForm();
                    break;
                // handling exception
                default:
                    System.out.println("..?");
                    break;
            }
        }
    }

    private void showDeleteForm() {
        String input = "";
        Account account;
        accounts = (List<Account>) cache.getCache().get(DomainType.ACCOUNT.getKey());
        deleteAccount:
        while (true) {
            System.out.println("삭제하기를 선택하셨네요. 뭘 원하십니까? 숫자로 쓰세요. 해당 메뉴를 취소하고 싶으면 -1을 입력하세요");
            System.out.println("1. 작성 목록 확인하기");
            System.out.println("2. 가계부 삭제하기");
            input = scanner.nextLine();
            switch (input){
                case "-1":
                    System.out.println("삭제하기를 종료 합니다.");
                    break deleteAccount;
                case "1":
                    showAccountList(accounts);
                    break;
                case "2":
                    System.out.println("삭제 하실 가계부 번호를 쓰세요");
                    Long id = Long.parseLong(scanner.nextLine());
                    account = accountController.findById(id);
                    if(account != null) {
                        System.out.println("지우실 가계부 내용은 다음과 같습니다. 계속 진행 하실거면 q, 아니면 아무키나 누르세요.");
                        System.out.println("카테고리 : " + account.getCategoryId());
                        System.out.println("제목 : " + account.getAccountTitle());
                        System.out.println("내용 : " + account.getAccountContent());
                        System.out.println("액수 : " + account.getAccountBalance());
                        input = scanner.nextLine();
                        if(input.equals("q")) {
                            delete(id);
                            break deleteAccount;
                        };
                    }else {
                        System.out.println("없는걸 어떻게 지워요 다시해요");
                    }
                    break;
                default:
                    System.out.println("뭐해? 다시해");
                    break;
            }
        }
    }

    private void showUpdateAccount() {
        AccountForm accountForm = new AccountForm();
        String input = "";
        String keyWord = "";
        Account account;
        accounts = (List<Account>) cache.getCache().get(DomainType.ACCOUNT.getKey());
        categories = (List<Category>) cache.getCache().get(DomainType.CATEGORY.getKey());
        updateAccount:
        while (!input.equals(-1)) {
            System.out.println("수정하기를 선택하셨습니다. 원하시는 기능을 번호로 입력 해주세요. 해당 메뉴를 취고하고 싶으면 -1을 입력하세요.");
            System.out.println("1. 작성 목록 확인하기");
            System.out.println("2. 가계부 수정 하기");
            input = scanner.nextLine();
            switch (input){
                case "-1":
                    System.out.println("수정하기를 종료 합니다.");
                    break updateAccount;
                case "1":
                    showAccountList(accounts);
                    break;
                case "2":
                    System.out.println("수정하고 싶은 게시글 번호를 입력하세요.");
                    input = scanner.nextLine();
                    account = accountController.findById(Long.parseLong(input));
                    if(account != null) {
                        System.out.println("1.수입 2.지출 (번호로 작성, 해당 페이지를 벗어나고 싶으면 q를 입력하세요.)");
                        input = scanner.nextLine();
                        if(input.equals("1")) {
                            keyWord = "수입";
                        } else if(input.equals("2")){
                            keyWord = "소비";
                        } else {
                            System.out.println("뭐하세요? 처음부터 다시 쓰세요.");
                            continue;
                        }

                        System.out.println(keyWord + "로 정하셨습니다. 기존 내용을 유지하고 싶은 부분이 있다면, 그냥 엔터를 치세요.");

                        showCategoryList(categories, keyWord);
                        System.out.println("수정하고 싶은 카테고리 코드를 입력하세요. (기존내용 : " + account.getCategoryId() + ")");
                        input = scanner.nextLine();
                        Long categoryId = input.equals("") ? account.getCategoryId() : Long.parseLong(input);

                        System.out.println("제목은 무엇으로 하시겠습니까?(기존내용 : " + account.getAccountTitle() + ")");
                        input = scanner.nextLine();
                        String accountTitle = input.equals("") ? account.getAccountTitle() : input;

                        System.out.println("내용은 무엇으로 하시겠습니까?(기존내용 : " + account.getAccountContent() + ")");
                        input = scanner.nextLine();
                        String accountContent = input.equals("") ? account.getAccountContent() : input;

                        System.out.println("액수는 얼마로 고치시겠습니까?(기존내용 : " + account.getAccountBalance() + ")");
                        input = scanner.nextLine();
                        int accountBalance = input.equals("") ? account.getAccountBalance() : Integer.parseInt(input);

                        accountForm.createAccountForm(categoryId, accountTitle, accountContent, accountBalance);
                        account.createAccount(accountForm);

                        System.out.println("입력 내용은 다음과 같습니다.");
                        System.out.println("카테고리 : " + account.getCategoryId());
                        System.out.println("제목 : " + account.getAccountTitle());
                        System.out.println("내용 : " + account.getAccountContent());
                        System.out.println("액수 : " + account.getAccountBalance());

                        System.out.println("이 내용이 맞습니까? 맞으면 q를 입력하시고, 다시 입력하시려면 아무키나 눌러주세요.");
                        input = scanner.nextLine();
                        if(input.equals("q")) {
                            update(account, accountForm);
                            break updateAccount;
                        }
                    }else {
                        System.out.println("없는 걸 어떻게 수정해요? 처음부터 다시 진행하세요.");
                        continue;
                    }
                    break;
            }
        }
    }

    private void showAccountList(List<Account> accountList) {
        accountList.stream().sorted((o1, o2) -> (int) (o1.getAccountId() - o2.getCategoryId())).forEach(account -> System.out.println(
                account.getAccountId() + ". " + account.getCategoryId() + " " + account.getAccountTitle() + " " + account.getAccountBalance() + "원 " + account.getAccountDate()
        ));
    }

    private void showCreateAccount() {
        AccountForm accountForm = new AccountForm();
        String input = "";
        String keyWord = "";
        String[] formValues = new String[4];
        categories = (List<Category>) cache.getCache().get(DomainType.CATEGORY.getKey());
        String[] steps = {
                "STEP1. 선택 하고 싶은 카테고리를 괄호안의 번호로 하세요.",
                "STEP2. 가계부 제목을 입력 하세요",
                "STEP3. 가계부 내용을 입력 하세요",
                "STEP4. 액수를 입력 하세요"
        };

        label:
        while (true) {
            System.out.println("추가하기를 선택하셨습니다.");
            System.out.println("1.수입 2.소비 (번호로 작성, 해당 페이지를 벗어나고 싶으면 -1를 입력하세요.)");
           input = scanner.nextLine();

            switch (input) {
                case "1":
                    keyWord = "수입";
                    break;
                case "2":
                    keyWord = "소비";
                    break;
                case "-1":
                    System.out.println("추가하기를 취소 합니다.");
                    break label;
            }

            for (int i = 0; i < steps.length;) {
                try{
                    if(i == 0){
                        showCategoryList(categories, keyWord);
                    }
                    System.out.println(steps[i]);
                    input = scanner.nextLine();
                    formValues[i] = input;
                    i++;
                }catch (Exception e) {
                    System.out.println("뭐하세요? 다시 쓰세요.");
                }
            }
            System.out.println("입력 내용은 다음과 같습니다.");
            System.out.println("카테고리 : " + formValues[0]);
            System.out.println("제목 : " + formValues[1]);
            System.out.println("내용 : " + formValues[2]);
            System.out.println("액수 : " + formValues[3]);

            System.out.println("이 내용이 맞습니까? 맞으면 q를 입력하시고, 다시 입력하시려면 아무키나 눌러주세요.");
            input = scanner.nextLine();

            if(input.equals("q")){
                System.out.println("입력하기를 종료하고 저장합니다.");
                accountForm.createAccountForm(formValues);
                save(accountForm);
                break;
            }
        }


    }

    private void showCategoryList(List<Category> categories, String finalKeyWord) {
        categories.stream().filter(category -> category.getAccountStatus().equals(finalKeyWord)).forEach(category -> System.out.println(category.getCategoryName() + "("+ category.getCategoryId() +")"));
    }
}

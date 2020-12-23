package com.shop;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    static Scanner scanner = new Scanner(System.in);

    static FileManager fileManager = new FileManager();
    static CartManager cartManager = new CartManager();
    static ItemManager itemManager = new ItemManager();
    static UserManager userManager = new UserManager();

    static String logId = "";

    static User admin = new User();

    public Shop() {
        admin.id = "admin";
        admin.pw = "1234";
    }

    public void run() {
        while (true) {
            mainMenuText();
            int choice = scanner.nextInt();
            if (choice == 1) { // 관리자 메뉴
                adminMenu();
            } else if (choice == 2) { // 사용자 메뉴
                userMenu();
            } else if (choice == 0) { // 프로그램 종료
                System.out.println("프로그램 종료");
                break;
            }
        }
        scanner.close();
    }

    public void mainMenuText() {
        System.out.println("MART");
        System.out.println("[1] 관리자");
        System.out.println("[2] 사용자");
        System.out.println("[0] 종료");
    }

    /**
     * 관리자 메뉴
     */
    public void adminMenu() {
        while (true) {
            System.out.println("[관리자] ID를 입력하세요");
            String myId = scanner.next();
            System.out.println("[관리자] PW를 입력하세요");
            String myPw = scanner.next();

            boolean check = adminChecking(myId, myPw);
            if (check) { // 제대로 기입시
                adminMenuText();
                int choice = scanner.nextInt();
                if (choice == 1) { // 물품 관리
                    manageItem();
                } else if (choice == 2) { // 사용자 관리
                    manageUser();
                } else if (choice == 0) {
                    System.out.println("메인메뉴 이동");
                    break;
                }
            } else { // 기입 오류시
                System.out.println("ID 혹은 PW 기입 오류");
                break;
            }
        }
    }

    /**
     * 관리자 메뉴
     */
    public void adminMenuText() {
        System.out.println("[1] 아이템 관리");
        System.out.println("[2] 카트 관리");
        System.out.println("[3] 사용자 관리");
        System.out.println("[0] 메인메뉴 이동");
    }

    /**
     * 관리자 아이디 비밀번호 체크
     *
     * @param myId
     * @param myPw
     * @return check
     */
    public boolean adminChecking(String myId, String myPw) {
        boolean check = false;
        if (admin.id.equals(myId) && admin.pw.equals(myPw)) {
            check = true;
        }
        return check;
    }

    /**
     * 회원 아이디 비밀번호 체크
     *
     * @param myId
     * @param myPw
     * @return check
     */
    public boolean userChecking(String myId, String myPw) {
        boolean check = false;

        for (int i = 0; i < UserManager.userList.size(); i++) {
            if (UserManager.userList.get(i).id.equals(myId) && UserManager.userList.get(i).pw.equals(myPw)) {
                check = true;
                break;
            }
        }

        return check;
    }

    /**
     * 사용자 메뉴
     */
    public void userMenu() {

    }

    /**
     * 물품 관리
     */
    public void manageItem() {
        while (true) {
            System.out.println("[관리자 물품 관리]");
            System.out.println("[1] 물품 등록");
            System.out.println("[2] 물품 삭제");
            System.out.println("[3] 카테고리 삭제");
            System.out.println("[4] 전체 물품 출력");
            System.out.println("[0] 뒤로가기");

            int choice = Shop.scanner.nextInt();

            if (choice == 1) { // 물품 등록
                itemManager.addItem();
            } else if (choice == 2) { // 물품 삭제
                itemManager.deleteItem();
            } else if (choice == 3) { // 카테고리 삭제
                itemManager.deleteCategory();
            } else if (choice == 4) { // 전체 물품 출력
                itemManager.printAll();
            } else if (choice == 0) { // 뒤로가기
                break;
            }
        }
    }

    /**
     * 회원 관리
     */
    public void manageUser() {
        while (true) {
            System.out.println("[관리자 회원 관리]");
            System.out.println("[1] 회원 추가");
            System.out.println("[2] 회원 삭제");
            System.out.println("[3] 회원 비밀번호 초기화 ");
            System.out.println("[4] 회원 전체 출력");
            System.out.println("[0] 뒤로가기");

            int choice = Shop.scanner.nextInt();
            if (choice == 1) { // 회원 추가
                userManager.addUser();
            } else if (choice == 2) { // 회원 삭제
                userManager.deleteUser();
            } else if (choice == 3) { // 회원 비밀번호 초기화

            } else if (choice == 4) { // 회원 전체 출력
                userManager.printAll();
            } else if (choice == 0) { // 뒤로가기
                break;
            }
        }
    }
}

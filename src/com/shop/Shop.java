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
        // 회원, 장바구니, 물품 전체 로드
        fileManager.loadAll();
        while (true) {
            mainMenuText();
            int choice = scanner.nextInt();
            if (choice == 1) { // 관리자 메뉴
                if (logId.equals("")) {
                    adminMenu();
                } else {
                    System.out.println("회원이 로그인 중입니다.");
                }
            } else if (choice == 2) { // 사용자 메뉴
                userMenu();
            } else if (choice == 0) { // 프로그램 종료
                System.out.println("프로그램 종료");
                break;
            }
            fileManager.saveAll();
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
        boolean check = userManager.adminLogin(admin);
        if (check) { // 제대로 기입시
            logId = admin.id;
            while (true) {
                adminMenuText();
                int choice = scanner.nextInt();
                if (choice == 1) { // 물품 관리
                    manageItem();
                } else if (choice == 2) { // 장바구니 관리
                    cartManager.manageCart();
                } else if (choice == 3) { // 사용자 관리
                    manageUser();
                } else if (choice == 0) { // 메인 메뉴 이동
                    System.out.println("로그아웃 후 메인메뉴 이동");
                    logId = "";
                    break;
                }
            }
            fileManager.saveAll();
        } else { // 기입 오류시
            System.out.println("ID 혹은 PW 기입 오류");
        }
    }

    /**
     * 관리자 메뉴
     */
    public void adminMenuText() {
        // 관리자로 넘어가도 logId 변경해주기
        System.out.println("[관리자 메뉴]");
        System.out.println("[1] 물품 관리");
        System.out.println("[2] 장바구니 관리");
        System.out.println("[3] 사용자 관리");
        System.out.println("[0] 메인메뉴 이동");
    }


    /**
     * 사용자 메뉴
     */
    public void userMenu() {
        while (true) {
            userMenuMessage();
            int choice = scanner.nextInt();
            if (choice == 1) { // 로그인
                if (logId.equals("")) {
                    logId = userManager.userLogin();
                } else {
                    System.out.println("다른 회원이 로그인 중입니다");
                }
            } else if (choice == 2) { // 회원 가입
                if (logId.equals("")) {
                    userManager.userSignIn();
                } else {
                    System.out.println("다른 회원이 로그인 중입니다");
                }
            } else if (choice == 3) { // 물품 구매
                if (!logId.equals("")) {
                    cartManager.buyItem(logId);
                } else {
                    System.out.println("로그인이 필요합니다");
                }
            } else if (choice == 4) { // 장바구니 확인
                if (!logId.equals("")) {
                    cartManager.checkCart(logId);
                } else {
                    System.out.println("로그인이 필요합니다");
                }
            } else if (choice == 5) { // 로그아웃
                if (!logId.equals("")) {
                    logId = "";
                } else {
                    System.out.println("로그인이 필요합니다");
                }
            } else if (choice == 6) { // 회원 탈퇴
                if (!logId.equals("")) {
                    userManager.userSignOut(logId);
                    logId = "";
                } else {
                    System.out.println("로그인이 필요합니다");
                }
            } else if (choice == 0) { // 뒤로가기
                System.out.println("메인 메뉴로 이동합니다");
                System.out.println("자동 로그아웃 됩니다");
                logId = "";
                break;
            }
            fileManager.saveAll();
        }
    }

    /**
     * 회원 메뉴 메세지
     */
    public void userMenuMessage() {
        System.out.println("[사용자 메뉴]");
        System.out.println("[1] 로그인");
        System.out.println("[2] 회원 가입");
        System.out.println("[3] 물품 구매");
        System.out.println("[4] 장바구니 확인");
        System.out.println("[5] 로그아웃");
        System.out.println("[6] 회원 탈퇴");
        System.out.println("[0] 뒤로가기");
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
                userManager.resetPw();
            } else if (choice == 4) { // 회원 전체 출력
                userManager.printAll();
            } else if (choice == 0) { // 뒤로가기
                break;
            }
        }
    }
}

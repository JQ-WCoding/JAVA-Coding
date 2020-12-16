package com.shop;

import java.util.Scanner;

public class Shop {
    static Scanner scanner = new Scanner(System.in);

    static FileManager fileManager = new FileManager();
    static CartManager cartManager = new CartManager();
    static ItemManager itemManager = new ItemManager();

    static String logId = "";

    static User admin = new User();

    public Shop() {
        admin.id = "admin";
        admin.pw = "1234";
    }

    public void run() {
        while (true) {
            mainMenu();
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

    public void mainMenu() {
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

            boolean check = checking(admin, myId, myPw);
            if (check) { // 제대로 기입시
                adminMenuMessage();
                int choice = scanner.nextInt();
                if (choice == 1){ // 아이템 관리

                }else if (choice == 2){ // 카트 관리

                }else if (choice == 3){ // 사용자 관리

                }else if (choice == 0){
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
    public void adminMenuMessage() {
        System.out.println("[1] 아이템 관리");
        System.out.println("[2] 카트 관리");
        System.out.println("[3] 사용자 관리");
        System.out.println("[0] 메인메뉴 이동");
    }

    /**
     * 아이디 비밀번호 체크
     */
    public boolean checking(User admin, String myId, String myPw) {
        boolean check = false;
        if (admin.id.equals(myId) && admin.pw.equals(myPw)) {
            check = true;
        }
        return check;
    }

    /**
     * 사용자 메뉴
     */
    public void userMenu() {

    }
}

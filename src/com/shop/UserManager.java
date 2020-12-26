package com.shop;

import java.util.ArrayList;

public class UserManager {
    static ArrayList<User> userList;

    public UserManager() {
        userList = new ArrayList<>();
    }

    /**
     * 회원 전체 목록 출력
     */
    public void printAll() {
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }

    /**
     * 관리자의 회원 추가
     */
    public void addUser() {
        while (true) {
            System.out.println("[추가] 추가할 회원 고유번호를 입력하세요 (10001 이상)");
            int checkUserNo = Shop.scanner.nextInt();

            if (checkUserNo < 10001) {
                System.out.println("번호 입력 오류");
                continue;
            }
            boolean check = checkNo(checkUserNo);

            if (check) { // 회원 추가 가능
                User newUser = new User();
                System.out.println("현재 고유번호로 회원을 입력합니다");
                newUser.userNo = checkUserNo;

                System.out.println("[추가] 회원 이름을 입력하세요");
                newUser.name = Shop.scanner.next();

                System.out.println("[추가] 회원 id를 입력하세요");
                newUser.id = Shop.scanner.next();

                System.out.println("[추가] 회원 pw를 입력하세요");
                newUser.pw = Shop.scanner.next();

                userList.add(newUser);
                break;
            } else {
                System.out.println("해당 번호의 회원이 이미 존재합니다");
            }
        }
    }

    /**
     * 회원 삭제
     */
    public void deleteUser() {
        while (true) {
            System.out.println("[삭제] 삭제할 회원 고유번호를 입력하세요");
            int checkUserNo = Shop.scanner.nextInt();

            if (checkUserNo < 10001) {
                System.out.println("번호 입력 오류");
                continue;
            }

            boolean check = checkNo(checkUserNo);

            if (!check) { // 회원 삭제 가능
                System.out.println("해당 번호의 회원을 삭제합니다");
                int index = -1;
                for (int i = 0; i < userList.size(); i++) {
                    if (checkUserNo == userList.get(i).userNo) {
                        index = i;
                    }
                }
                userList.remove(index);
                break;
            } else {
                System.out.println("해당 번호의 회원이 존재하지 않습니다");
            }
        }
    }

    /**
     * 회원 번호 입력 확인
     *
     * @param checkUserNo
     * @return check
     */
    public boolean checkNo(int checkUserNo) {
        boolean check = true;
        for (User user : userList) {
            if (checkUserNo == user.userNo) {
                check = false;
                break;
            }
        }
        return check;
    }

    /**
     * int형 반환 확인
     *
     * @param checkUserNo
     * @return index
     */
    public int checkNoInt(int checkUserNo) {
        int index = -1;
        for (int i = 0; i < userList.size(); i++) {
            if (checkUserNo == userList.get(i).userNo) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * 회원 비밀번호 초기화
     */
    public void resetPw() {
        while (true) {
            System.out.println("[초기화] 비밀번호 초기화할 회원 번호를 입력하세요");
            int checkUserNo = Shop.scanner.nextInt();

            if (checkUserNo < 10001) {
                System.out.println("번호 입력 오류");
                continue;
            }

            int check = checkNoInt(checkUserNo);

            if (check != -1) { // 회원 번호 체크
                System.out.println("해당 회원의 비밀번호를 (0000)으로 초기화합니다");
                userList.get(check).pw = "0000";
                break;
            } else {
                System.out.println("해당 회원이 존재하지 않습니다");
            }
        }
    }

    /**
     * 회원 로그인
     */
    public String userLogin() {
        System.out.println("[회원] ID를 입력하세요");
        String myId = Shop.scanner.next();
        System.out.println("[회원] PW를 입력하세요");
        String myPw = Shop.scanner.next();

        int check = userChecking(myId, myPw);

        if (check != -1) { // 회원 제대로 기입시
            System.out.println(userList.get(check).name + "회원님 환영합니다");
            return userList.get(check).id;
        } else { // 회원 입력 오류
            System.out.println("아이디 혹은 비밀번호 입력 오류");
            return "";
        }
    }

    /**
     * 회원 아이디 비밀번호 체크
     *
     * @param myId
     * @param myPw
     * @return check
     */
    public int userChecking(String myId, String myPw) {
        int check = -1;

        for (int i = 0; i < UserManager.userList.size(); i++) {
            if (UserManager.userList.get(i).id.equals(myId) && UserManager.userList.get(i).pw.equals(myPw)) {
                check = i;
                break;
            }
        }

        return check;
    }

    /**
     * 사용자 회원가입
     */
    public void userSignIn() {
        System.out.println("[회원가입] ID를 입력하세요");
        String myId = Shop.scanner.next();

        boolean check = checkDuplicateId(myId);

        if (check) {
            User addUser = new User();
            addUser.id = myId;

            System.out.println("[회원가입] 비밀번호를 입력하세요");
            addUser.pw = Shop.scanner.next();

            System.out.println("[회원가입] 성명을 입력하세요");
            addUser.name = Shop.scanner.next();

            // 고유 회원 번호 자동 기입하기
            addUser.userNo = addUserNo();
            // 해당 회원 추가
            userList.add(addUser);
        } else {
            System.out.println("아이디가 중복됩니다");
        }
    }

    /**
     * 회원 중복 id 체크
     *
     * @param myId
     * @return check
     */
    public boolean checkDuplicateId(String myId) {
        boolean check = true;
        for (int i = 0; i < userList.size(); i++) {
            if (myId.equals(userList.get(i).id)) {
                check = false;
                break;
            }
        }
        return check;
    }

    /**
     * 유저 고유 번호 자동 기입 메소드
     *
     * @return userNo
     */
    public int addUserNo() {
        int userNo = 10001;

        if (userList.size() != 0) {
            for (User user : userList) {
                if (userNo != user.userNo) {
                    break;
                }
                userNo++;
            }
        }

        return userNo;
    }

    /**
     * 회원 탈퇴
     *
     * @param logId
     */
    public void userSignOut(String logId) {
        while (true) {
            System.out.println("[회원 탈퇴]회원탈퇴를 진행하시겠습니까? (1) 예 (2) 아니오");
            int choice = Shop.scanner.nextInt();

            if (choice == 1) { // 회원 탈퇴
                int index = -1;
                for (int i = 0; i < userList.size(); i++) {
                    if (logId.equals(userList.get(i).id)) {
                        index = i;
                        break;
                    }
                }
                int checkUserNo = userList.get(index).userNo;

                // 회원 삭제
                userList.remove(index);

                int cartSize = CartManager.cartList.size();
                // 카트 내용물 삭제
                for (int i = 0; i < cartSize; i++) {
                    if (checkUserNo == CartManager.cartList.get(i).userNo) {
                        CartManager.cartList.remove(i);
                        cartSize--;
                    }
                }
            } else {
                System.out.println("이전 메뉴로 이동합니다");
                break;
            }
        }
    }


    public boolean adminLogin(User admin) {
        System.out.println("[관리자] ID를 입력하세요");
        String myId = Shop.scanner.next();
        System.out.println("[관리자] PW를 입력하세요");
        String myPw = Shop.scanner.next();

        boolean check = adminChecking(myId, myPw, admin);
        if (check) { // 올바르게 기입시
            return true;
        } else {
            System.out.println("관리자 아이디 혹은 비밀번호 기입 오류");
            return false;
        }
    }

    /**
     * 관리자 아이디 비밀번호 체크
     *
     * @param myId
     * @param myPw
     * @param admin
     * @return check
     */
    public boolean adminChecking(String myId, String myPw, User admin) {
        boolean check = false;
        if (admin.id.equals(myId) && admin.pw.equals(myPw)) {
            check = true;
        }
        return check;
    }
}

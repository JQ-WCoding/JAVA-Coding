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

    public void resetPw(){

    }
}

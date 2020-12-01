package Day053P;

import java.util.Scanner;

class User {
    String id;
    String pw;
    int money;
}

public class Day05308클래스배열회원가입 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int max = 100;
        User[] users = new User[max];
        for (int i = 0; i < max; i++) {
            users[i] = new User();
        }

        int count = 0;
        while (true) {
            System.out.println("[1]회원가입");        // id, pw, money(1000원)
            System.out.println("[2]탈퇴");
            System.out.println("[3]출력");

            int choice = scanner.nextInt();
            if (choice == 1) {
                if (count < 100) {
                    System.out.print("ID를 입력하세요 : ");
                    String myId = scanner.next();
                    System.out.print("PW를 입력하세요 : ");
                    String myPw = scanner.next();

                    users[count].id = myId;
                    users[count].pw = myPw;
                    users[count].money = 1000;

                    count++;
                } else {
                    System.out.println("더이상 생성할 수 없습니다");
                }
            } else if (choice == 2) {
                System.out.print("삭제할 ID를 입력하세요 : ");
                String myId = scanner.next();

                int check = -1;
                for (int i = 0; i < count; i++) {
                    if (myId.equals(users[i].id)) {
                        check = i;
                    }
                }
                if (check != -1) {
                    for (int i = check; i < count; i++) {
                        users[i].id = users[i + 1].id;
                        users[i].pw = users[i + 1].pw;
                        users[i].money = users[i + 1].money;
                    }
                    count--;
                }else {
                    System.out.println("아이디가 없습니다");
                }
            } else if (choice == 3) {
                for (int i = 0; i < count; i++) {
                    System.out.printf("[%d] ID : %s / PW : %s / Money : %d원 \n", (count), users[i].id, users[i].pw, users[i].money);
                }
            } else {
                break;
            }
        }
    }
}

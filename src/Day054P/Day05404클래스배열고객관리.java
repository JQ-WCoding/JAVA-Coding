package Day054P;

import java.util.Scanner;

class Client {
    String id;
    String pw;

    public void setData(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public void printData() {
        System.out.println("아이디 : " + id + " / 패스워드 : " + pw);
    }
}

class Manager {
    Client[] clients;
    int count = 0;
}

public class Day05404클래스배열고객관리 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Manager manager = new Manager();

        while (true){
            System.out.println("[1]가입 [2]탈퇴 [3]정렬 [4]출력 [5]저장 [6]로드");

            int choice = scanner.nextInt();

            // 각 기능을 메소드로 만들기
            if(choice == 1) {}
            else if(choice == 2) {}
            else if(choice == 2) {}
            else if(choice == 3) {}
            else if(choice == 4) {}
            else if(choice == 5) {}
            else if(choice == 6) {}
        }
    }
}

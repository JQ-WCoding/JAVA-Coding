package ATM;

import java.util.Arrays;

public class ATMMessage {
    public void insertId() {
        System.out.print("ID를 입력하세요 : (1000 ~ 9999)");
    }

    public void insertPw() {
        System.out.print("PW를 입력하세요 : (1000 ~ 9999)");
    }

    public void mainMenu() {
        String menu = "=== 그린IT ATM ===\n";
        menu += "1.회원가입\n2.회원탈퇴\n3.로그인\n4.로그아웃\n";
        menu += "5.입금\n6.이체\n7.잔액조회\n0.종료";
        System.out.println(menu);
    }

    public void alreadyLoginMessage(int x) {
        System.out.printf("%d 회원이 로그인 중입니다%n", x);
    }

    public void noMoreSignUp() {
        System.out.println("더이상 회원가입 불가능");
    }

    public void cannotUse() {
        System.out.println("사용이 불가능합니다");
    }

    public void showId(int[] x) {
        System.out.println(Arrays.toString(x));
    }

    public void showPw(int[] x) {
        System.out.println(Arrays.toString(x));
    }

    public void showMoney(int[] x) {
        System.out.println(Arrays.toString(x));
    }

    public void noExistMember() {
        System.out.println("회원이 아닙니다");
    }

    public void welcomeMessage(int x) {
        System.out.printf("%d 회원님 환영합니다 %n", x);
    }

    public void logOutMessage() {
        System.out.println("로그아웃");
    }

    public void howMuchMoney() {
        System.out.println("금액을 입력하세요");
    }

    public void leftMoney(int x, int y) {
        System.out.printf("현재 %d 님의 잔액 : %d원 %n", x, y);
    }
}

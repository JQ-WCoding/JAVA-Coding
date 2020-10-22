package Day028P;

import java.util.Arrays;

public class Alarm {
    DBandActor db = new DBandActor();

    public void loginAlarm() {
        System.out.println("[알림] 로그인 후 이용해주세요");
    }

    public void programOff() {
        System.out.println("[종료] 프로그램을 종료합니다");
    }

    public void noExistAccount() {
        System.out.println("[알림] 이체할 계좌가 존재하지 않습니다");
    }

    public void noMoreSignUp() {
        System.out.println("[알림] 더 이상 회원가입이 불가합니다.");
    }

    public void signUpId() {
        System.out.println("아이디를 입력하세요(1000 ~ 9999)");
    }

    public void signUpPw() {
        System.out.println("비밀번호를 입력하세요(1000 ~ 9999)");
    }

    public void nowLogin() {
        System.out.printf("[알림] %d 회원 로그인 중...%n", db.arId[db.log]);
    }

    public void cannotUseId() {
        System.out.println("[알림] 사용할 수 없는 아이디입니다");
    }

    public void signOutIdInsert() {
        System.out.println("[회원탈퇴] 탈퇴할 아이디를 입력하세요");
    }

    public void signOutPwInsert() {
        System.out.println("[회원탈퇴] 비밀번호를 입하세요");
    }

    public void errorInsert() {
        System.out.println("[알림] 기입 오류");
    }

    public void helloMeant() {
        System.out.printf("%d 회원님 환영합니다", db.arId[db.log]);
    }

    public void logOutMeant() {
        System.out.printf("[로그아웃] %d 회원 로그아웃...%n", db.arId[db.log]);
        db.log = -1;
    }

    public void howMuchMoney() {
        System.out.println("[알림] 금액을 입력하세요");
    }

    public void errorMoney() {
        System.out.println("[알림] 금액 오류");
    }

    public void leftMoney() {
        System.out.printf("현재 %d 회원님의 잔액 : %d원 %n", db.arId[db.log], db.arMoney[db.log]); // Id와 현재 잔액 출력
    }
    public void arId() {
        System.out.println(Arrays.toString(db.arId));
    }

    public void arPw() {
        System.out.println(Arrays.toString(db.arPw));
    }

    public void arMoney() {
        System.out.println(Arrays.toString(db.arMoney));
    }
}

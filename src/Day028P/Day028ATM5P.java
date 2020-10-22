package Day028P;

public class Day028ATM5P {
    public static void main(String[] args) {
        DBandActor db = new DBandActor();
        Alarm alarm = new Alarm();
        SelectMenu menuSelect = new SelectMenu();
        int log = db.log;
        while (true) {
            /*
            확인을 위한 출력
             */
            alarm.arId();
            alarm.arPw();
            alarm.arMoney();
            Menu.fistMenu();

            int choice = menuSelect.choice(); // choice 입력
            /*
            선택에 따른 행동 방식
             */
            if (choice == 1) { // 회원가입
                db.signUp();
            } else if (choice == 2) { // 회원탈퇴
                db.signOut();
            } else if (choice == 3) { // 로그인
                db.loginSystem();
                if (log != -1) {
                    alarm.helloMeant();
                } else {
                    alarm.errorInsert();
                }
            } else if (choice == 4) { // 로그아웃
                if (log != -1) {
                    alarm.logOutMeant();
                } else {
                    alarm.loginAlarm();
                }
            } else if (choice == 5) { // 입금
                db.depositAccount();
            } else if (choice == 6) { // 이체
                db.transferMoney();
            } else if (choice == 7) { // 잔액조회
                db.lookUpAccount();
            } else if (choice == 0) { // 종료
                alarm.programOff();
                break;
            }
        }
    }
}

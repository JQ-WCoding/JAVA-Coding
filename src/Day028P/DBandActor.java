package Day028P;

import java.util.Scanner;

public class DBandActor {
    Alarm alarm = new Alarm();
    SelectMenu menuSelect = new SelectMenu();
    Scanner scanner = new Scanner(System.in);

    int max = 5;
    int[] arId = new int[max];
    int[] arPw = new int[max];
    int[] arMoney = new int[max];

    int count = 0;
    static int log = -1; // how to ? -1  arId[Index] -> log = Index;

    public void signUp() {
        if (log != -1) {
            int check = 1;
            while (true) {
                if (count == 5) {
                    alarm.noMoreSignUp();
                    break;
                }
                alarm.signUpId();
                int myId = scanner.nextInt();
                alarm.signUpPw();
                int myPw = scanner.nextInt();
                if (myId >= 1000 && myId < 10000 && myPw >= 1000 && myPw < 10000) {
                    for (int j : arId) {
                        if (j == myId) {
                            check = -1;
                            break;
                        }
                    }
                    if (check != -1) { // 중복값이 없을 경우 실행
                        arId[count] = myId;
                        arPw[count] = myPw;
                        count++; // 현재 아이디의 개수
                        break; // 완벽히 입력이 완료되어 저장되면 반복문 탈출
                    } else { // arId[i] 내에 이미 myId와 같은 값이 존재할 경우
                        alarm.cannotUseId();
                    }
                }
            }
        } else {
            alarm.nowLogin();
        }
    }

    public void signOut() {
        if (log == -1) {
                /*
                회원탈퇴를 위한 아이디와 비밀번호를 입력받는다
                 */
            alarm.signOutIdInsert();
            int myId = scanner.nextInt();
            alarm.signOutPwInsert();
            int myPw = scanner.nextInt();
                /*
                정확한 값을 입력했는지 찾기
                 */
            for (int i = 0; i < count; i++) {
                if (myId == arId[i] && myPw == arPw[i]) {
                    log = i; // log를 통해 같은 값 인덱스 찾
                }
            }
            // 반복문
            if (log != -1) { // log가 != -1이 아닌경우 같은 값을 찾았다의 의미
                for (int i = log; i < count; i++) {
                    arId[i] = arId[i + 1];
                    arPw[i] = arPw[i + 1];
                    arMoney[i] = arMoney[i + 1];
                }
                count--; // 회원탈퇴로 인한 인원 감소 확인 count
            } else {
                alarm.errorInsert();
            }
        } else {
            alarm.nowLogin();
        }
    }

    public int loginSystem() {
        alarm.signUpId();
        int myId = scanner.nextInt();
        alarm.signUpPw();
        int myPw = scanner.nextInt();
        int check = -1;
        for (int i = 0; i < count; i++) {
            if (arId[i] == myId && arPw[i] == myPw) {
                log = i;
                check = i;
            }
        }
        if (check != -1) {
            return log;
        } else {
            return -1; // 로그인 실패
        }
    }

    public void depositAccount() {
        if (log != -1) {
            alarm.howMuchMoney();
            int myMoney = scanner.nextInt();
            if (myMoney > 0) {
                arMoney[log] += myMoney;
            } else {
                alarm.errorMoney();
            }
        } else {
            alarm.loginAlarm();
        }
    }

    public void transferMoney() {
        if (log != -1) {
            System.out.print("이치할"); // 귀찮아서..;;
            alarm.signUpId();
            int transferId = scanner.nextInt();
            int idIndex = -1; // 이체할 아이디 인덱스 값
            for (int i = 0; i < count; i++) {
                if (transferId == arId[i]) {
                    idIndex = i;
                }
            }
            if (idIndex != -1) {
                alarm.howMuchMoney();
                int transferMoney = scanner.nextInt();
                if (arMoney[log] >= transferMoney) {
                    arMoney[idIndex] += transferMoney; // 이체된 계좌의 돈
                    arMoney[log] -= transferMoney; // 이체 후 나의 계좌 돈
                } else { // 이체할 금액만큼의 돈이 없는 경우
                    alarm.errorMoney();
                }
            } else {
                alarm.noExistAccount();
            }
        } else {
            alarm.loginAlarm();
        }
    }

    public void lookUpAccount() {
        if (log != -1) {
            alarm.leftMoney();
        } else {
            alarm.loginAlarm();
        }
    }

    public void init() {
        while (true) {
            /*
            확인을 위한 출력
             */
            alarm.arId(arId);
            alarm.arPw(arPw);
            alarm.arMoney(arMoney);
            Menu.fistMenu();

            int choice = menuSelect.choice(); // choice 입력
            /*
            선택에 따른 행동 방식
             */
            if (choice == 1) { // 회원가입
                signUp();
            } else if (choice == 2) { // 회원탈퇴
                signOut();
            } else if (choice == 3) { // 로그인
                loginSystem();
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
                depositAccount();
            } else if (choice == 6) { // 이체
                transferMoney();
            } else if (choice == 7) { // 잔액조회
                lookUpAccount();
            } else if (choice == 0) { // 종료
                alarm.programOff();
                break;
            }
        }
    }

}

package ATM;

import java.util.Scanner;

public class ATMActor {
    public Scanner scanner = new Scanner(System.in);
    public ATMMessage message = new ATMMessage();

    private int log;
    private int count;
    private ATMuserDB[] atmUserDBS;

    public ATMActor() {
        this.log = -1;
        this.count = 0;
        this.atmUserDBS = new ATMuserDB[5];
    }
//    public int max = 5;
//    public int[] arId = new int[max];
//    public int[] arPw = new int[max];
//    public int[] arMoney = new int[max];
    // 새 클래스에 만들고 private 써도 되나? 그러면 db.arId 표현했을때 private 자기가 참조할 수 있구나
//
//    public int count = 0; //
//    public int log = -1; // login 두번 될지도..? // DB class -> make 로그인에 대한 상황 표시니까 다른 사람이 강제적으로 확인하거나 변경할 수 없도록 private
    // DB class  DB db = new DB();
    // db.log ??? Question?? -> Ok, use
    // 데이터만 받는 클래스가 존재한다 -> 이미 실무에서 굉장히 많은 디자인 패턴 중에 하나로 사용하고 있음(MVC Pattern) model(only data) view controller
    // 객체배열 ? Class Array

    // 객체배열 사용해보기 -> make another class to using object array
    public void MainScreen() {
        while (true) { //  반복문 실행
//            message.showId(); // arId 인자값 현재 저장되어있는 배열 arId의 모든 값 출력
//            message.showPw(); // 현재 저장되어있는 배열 arPw의 모든 값 출력
//            message.showMoney(); //  현재 저장되어있는 배열 arMoney 모든 값 출력
            message.mainMenu(); // 메인 메뉴 내용 출력
            int choice = scanner.nextInt();
            if (choice == 1) { // 회원가입 signUp class -> class 참조 new class(instance) . method
                this.signUpMenu(); // this 는 생략가능
            } else if (choice == 2) { // 회원탈퇴
                this.signOutMenu();
            } else if (choice == 3) { // 로그인
                this.loginSystem();
            } else if (choice == 4) { // 로그아웃
                this.logOut();
            } else if (choice == 5) { // 입금
                this.depositMoney();
            } else if (choice == 6) { // 이체
                this.transferMoney();
            } else if (choice == 7) { // 잔액조회
                this.checkBalance();
            } else if (choice == 0) { // 종료
                break; // 반복문 종료
            }
        } // while
    }

    public void signUpMenu() { // 회원가입에 대한 메소드
        if (log == -1) {
            int check = 1;
            while (true) {
                if (count == 5) { // 더이상 회원가입 불가능
                    message.noMoreSignUp();
                    break;
                }
                message.insertId();
                int myId = scanner.nextInt();
                message.insertPw();
                int myPw = scanner.nextInt();
                if (myId >= 1000 && myId < 10000 && myPw >= 1000 && myPw < 10000) {
                    for (int i = 0; i < count; i++) {
                        if (myId == atmUserDBS[i].getId()) {
                            check = -1;
                            break;
                        }
                    }
                    if (check != -1) {
                        atmUserDBS[count] = new ATMuserDB(myId, myPw, 1000);
                        count++; // 현재 아이디의 개수
                        break; // 완벽히 입력이 완료되어 저장되면 반복문 탈출
                    } else {
                        message.cannotUse(); // 사용 불가능 메세지 출력 (중복아이디)
                    }
                } else {
                    message.cannotUse();
                }
            }
        } else {
            message.alreadyLoginMessage(log);
        }
    } // 회원가입

    public void signOutMenu() {
        if (log == -1) {
                /*
                회원탈퇴를 위한 아이디와 비밀번호를 입력받는다
                 */
            message.insertId();
            int myId = scanner.nextInt();
            message.insertPw();
            int myPw = scanner.nextInt();
                /*
                정확한 값을 입력했는지 찾기
                 */
            for (int i = 0; i < count; i++) {
                if (myId == atmUserDBS[i].getId() && myPw == atmUserDBS[i].getPw()) {
                    log = i; // log를 통해 같은 값 인덱스 찾
                }
            }
            // 반복문
            if (log != -1) { // log가 != -1이 아닌경우 같은 값을 찾았다의 의미
                for (int i = log; i < count; i++) {
                    atmUserDBS[i] = atmUserDBS[i + 1];
                }
                count--; // 회원탈퇴로 인한 인원 감소 확인 count
            } else {
                message.noExistMember();
            }
        } else {
            message.alreadyLoginMessage(atmUserDBS[log].getId()); // 이미 로그인 상태
        }

    } // 회원탈퇴

    public void loginSystem() {
        message.insertId();
        int myId = scanner.nextInt();
        message.insertPw();
        int myPw = scanner.nextInt();
        int check = -1;
        for (int i = 0; i < count; i++) {
            if (atmUserDBS[i].getId() == myId && atmUserDBS[i].getPw() == myPw) {
                log = i;
                check = i;
            }
        }
        if (check != -1) {
            message.welcomeMessage(atmUserDBS[log].getId());
        } else {
            message.noExistMember(); // 로그인 실패
        }
    } // 로그인 시스템

    public void logOut() {
        if (log != -1) {
            log = -1;
            message.logOutMessage();
        } else {
            message.cannotUse();
        }
    } // 로그아웃

    public void depositMoney() {
        if (log != -1) {
            message.howMuchMoney();
            int myMoney = scanner.nextInt();
            if (myMoney > 0) {
                atmUserDBS[log].setMoney(atmUserDBS[log].getMoney() + myMoney);
            } else {
                message.cannotUse();
            }
        } else {
            message.cannotUse();
        }
    } // 입금

    public void transferMoney() {
        if (log != -1) {
            message.insertId();
            int transferId = scanner.nextInt();
            int idIndex = -1; // 이체할 아이디 인덱스 값
            for (int i = 0; i < count; i++) {
                if (transferId == atmUserDBS[i].getId()) {
                    idIndex = i;
                }
            }
            if (idIndex != -1) {
                message.howMuchMoney();
                int transferMoney = scanner.nextInt();
                if (atmUserDBS[log].getMoney() >= transferMoney) {
                    atmUserDBS[idIndex].setMoney(atmUserDBS[idIndex].getMoney() + transferMoney); // 이체된 돈
                    atmUserDBS[log].setMoney(atmUserDBS[log].getMoney() - transferMoney); // 이체 후 나의 돈
                } else { // 이체할 금액만큼의 돈이 없는 경우
                    message.cannotUse();
                }
            } else {
                message.noExistMember();
            }
        } else {
            message.cannotUse();
        }
    } // 이체

    public void checkBalance() {
        if (log != -1) {
            message.leftMoney(atmUserDBS[log].getId(), atmUserDBS[log].getMoney());
        } else {
            message.cannotUse();
        }
    }
}

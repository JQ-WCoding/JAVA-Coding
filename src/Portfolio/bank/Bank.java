package Portfolio.bank;

import java.util.Scanner;

public class Bank {
    static Scanner scanner = new Scanner(System.in);
    // 로그인 확인 변수 (현재 누가 로그인 중인지 확인용)
    int log = -1;

    FileManger fileManger;
    ClientManager clientManager;
    AccountManager accountManager;

    public Bank(FileManger fileManger, ClientManager clientManager, AccountManager accountManager) {
        this.fileManger = fileManger;
        this.clientManager = clientManager;
        this.accountManager = accountManager;
    }

    /**
     * 메인 동작 기능
     */
    public void run() {
        fileManger.loadFile(accountManager, clientManager);
        boolean run = true;
        while (run) {
            // 로그인 상태일 경우
            while (log != -1) {
                inLoginMenuMessage();
                int choice = scanner.nextInt();
                if (choice == 1) { // 입금
                    accountManager.deposit();
                } else if (choice == 2) { // 인출
                    accountManager.withdrawal(clientManager, log);
                } else if (choice == 3) { // 송금
                    accountManager.wire(clientManager, log);
                } else if (choice == 4) { // 잔액 확인
                    accountManager.checkAccount(clientManager, log);
                } else if (choice == 5) { // 계좌 생성
                    accountManager.addAccount(clientManager, log);
                } else if (choice == 6) { // 계좌 삭제
                    accountManager.deleteAccount(clientManager, log);
                } else if (choice == 7) { // 계정 삭제
                    if (clientManager.deleteClient(accountManager, log)) {
                        log = -1;
                        break;
                    }
                } else if (choice == 0) { // 로그아웃
                    System.out.println("로그아웃 되었습니다");
                    log = -1;
                    break;
                }
            }
            fileManger.saveFile(accountManager, clientManager);
            // 로그아웃 상태일 경우
            while (log == -1) {
                inLogoutMenuMessage();
                int choice = scanner.nextInt();
                if (choice == 1) { // 로그인 기능
                    login();
                } else if (choice == 2) { // 계정 생성
                    clientManager.signIn();
                } else if (choice == 0) {
                    run = false;
                    break;
                }
            }
            fileManger.saveFile(accountManager, clientManager);
        }
    }

    /**
     * 로그인 상태시 메세지 출력
     */
    public void inLoginMenuMessage() {
        System.out.println("(1) 입금");
        System.out.println("(2) 인출");
        System.out.println("(3) 송금");
        System.out.println("(4) 잔액 확인");
        System.out.println("(5) 계좌 생성");
        System.out.println("(6) 계좌 삭제");
        System.out.println("(7) 계정 삭제");
        System.out.println("(0) 로그아웃");
    }

    /**
     * 로그아웃 상태시 메세지 출력
     */
    public void inLogoutMenuMessage() {
        System.out.println("(1) 로그인");
        System.out.println("(2) 계정 생성");
        System.out.println("(0) 종료");
    }

    /**
     * 로그인 기능
     */
    public void login() {
        System.out.println("[로그인] ID를 입력하세요");
        String myId = scanner.next();
        System.out.println("[로그인] PW를 입력하세요");
        String myPw = scanner.next();

        for (int i = 0; i < clientManager.clientCount; i++) {
            if (clientManager.clientList[i].id.equals(myId) && clientManager.clientList[i].pwd.equals(myPw)) {
                // 멤버 변수 log 에 직접 index 값 대입
                log = i;
                break;
            }
        }
        if (log != -1) {
            System.out.println("[알림] 로그인 성공");
        } else {
            System.out.println("[알림] ID 혹은 PW 기입오류");
        }

    }
}

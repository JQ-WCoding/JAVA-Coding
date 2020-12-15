package com.bank;

import java.util.Random;
import java.util.Scanner;

public class Bank {
    Scanner scanner = new Scanner(System.in);
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
        boolean run = true;
        while (run) {
            // 로그인 상태일 경우
            if (log != -1) {
                while (true) {
                    inLoginMenuMessage();
                    int choice = scanner.nextInt();
                    if (choice == 1) { // 입금
                        deposit();
                    } else if (choice == 2) { // 인출
                        withdrawal();
                    } else if (choice == 3) { // 송금
                        wire();
                    } else if (choice == 4) { // 잔액 확인
                        checkAccount();
                    } else if (choice == 5) { // 계좌 생성
                        addAccount();
                    } else if (choice == 6) { // 계좌 삭제

                    } else if (choice == 7) { // 계정 삭제

                    } else if (choice == 0) { // 로그아웃
                        System.out.println("로그아웃 되었습니다");
                        log = -1;
                        break;
                    }
                }
            }
            // 로그아웃 상태일 경우
            while (log == -1) {
                inLogoutMenuMessage();
                int choice = scanner.nextInt();
                if (choice == 1) { // 로그인 기능
                    login();
                } else if (choice == 2) { // 계정 생성
                    signIn();
                } else if (choice == 0) {
                    run = false;
                    break;
                }
            }
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

    /**
     * 계정 생성 기능
     */
    public void signIn() {
        while (true) {
            System.out.println("[계정생성] 생성할 ID를 입력하세요");
            String signInId = scanner.next();
            boolean sameId = false;
            // 아이디 중복 확인
            for (int i = 0; i < clientManager.clientCount; i++) {
                if (clientManager.clientList[i].id.equals(signInId)) {
                    sameId = true;
                    break;
                }
            }
            if (!sameId) { // 계정 생성 가능
                // client 생성 (pw, name, no)
                System.out.println("[계정생성] PW를 입력하세요");
                String signInPw = scanner.next();
                System.out.println("[계정생성] 이름을 입력하세요");
                String signInName = scanner.next();
                // no는 1부터 시작
                if (clientManager.clientCount == 0) { // 첫 고객인경우
                    clientManager.clientList = new Client[1]; // 1
                    clientManager.clientList[0] = new Client();
//                    clientManager.clientList[0].id = signInId;
//                    clientManager.clientList[0].pwd = signInPw;
//                    clientManager.clientList[0].name = signInName;
//                    clientManager.clientList[0].clientNo = 10001 + clientManager.clientCount;
//                    clientManager.clientCount++;
                } else {
                    Client[] temp = clientManager.clientList;
                    clientManager.clientList = new Client[clientManager.clientCount + 1];
                    for (int i = 0; i < clientManager.clientCount; i++) {
                        clientManager.clientList[i] = new Client();
                        clientManager.clientList[i] = temp[i];
                    }
                }
                clientManager.clientList[clientManager.clientCount].id = signInId;
                clientManager.clientList[clientManager.clientCount].pwd = signInPw;
                clientManager.clientList[clientManager.clientCount].name = signInName;
                clientManager.clientList[clientManager.clientCount].clientNo = 1001 + clientManager.clientCount;
                clientManager.clientCount++;
                System.out.println("[알림] 계정생성 완료");
                break;
            } else {
                System.out.println("중복되는 ID");
            }
        }
    }

    /**
     * 계좌생성
     */
    public void addAccount() {
        System.out.println("[계좌생성] 추가 생성할 계좌의 잔액을 입력하세요");
        int myMoney = scanner.nextInt();
        Account[] temp = accountManager.accountList;
        accountManager.accountList = new Account[accountManager.accountCount + 1];
        for (int i = 0; i < accountManager.accountCount; i++) {
            accountManager.accountList[i] = new Account();
            accountManager.accountList[i] = temp[i];
        }
        // 클라이언트 값은 그대로 가져온다
        accountManager.accountList[accountManager.accountCount] = new Account();
        accountManager.accountList[accountManager.accountCount].clientNo = clientManager.clientList[log].clientNo;
        // 계좌 번호 자동 생성 메소드
        accountManager.accountList[accountManager.accountCount].accountNumber = autoAccountNumber();
        accountManager.accountList[accountManager.accountCount].money = myMoney;
        accountManager.accountCount++;
    }

    /**
     * 계좌 번호 자동 생성
     */
    public String autoAccountNumber() {
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int r1 = random.nextInt(10);
            accountNumber.append(r1);
            int r2 = random.nextInt(10);
            accountNumber.append(r2);
            int r3 = random.nextInt(10);
            accountNumber.append(r3);
            if (i != 2) {
                accountNumber.append("-");
            }
        }
        System.out.println("[계좌 생성 완료] " + accountNumber + " 로 생성되었습니다");
        return accountNumber.toString();
    }

    /**
     * 잔액 확인
     */
    public void checkAccount() {
        System.out.println("[잔액확인] 본인 계좌번호를 4자리씩 작성해주세요 :");
        String myAccountNumber = inputAccount();
//        System.out.println(myAccountNumber);

        int index = checkMyAccount(myAccountNumber);

        if (index != -1) {
            System.out.println("현재 잔액은 : " + accountManager.accountList[index].money + "원 입니다");
        } else {
            System.out.println("[알림] 본인 계좌가 아니거나 계좌번호가 기입 오류입니다");
        }
    }

    /**
     * 본인 계좌 확인
     */
    public int checkMyAccount(String myAccountNumber) {
        int index = -1;
        for (int i = 0; i < accountManager.accountCount; i++) {
            if (accountManager.accountList[i].accountNumber.equals(myAccountNumber)) {
                if (accountManager.accountList[i].clientNo == clientManager.clientList[log].clientNo) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    /**
     * 계좌 번호 입력
     */
    public String inputAccount() {
        String inputAccount1 = scanner.next();
        System.out.println("-");
        inputAccount1 += "-";
        String inputAccount2 = scanner.next();
        System.out.println("-");
        inputAccount2 += "-";
        String inputAccount3 = scanner.next();

        return inputAccount1 + inputAccount2 + inputAccount3;
    }

    /**
     * 입금
     */
    public void deposit() {
        System.out.println("[입금] 입금할 계좌 번호를 입력하세요");
        String accountNumber = inputAccount();
        int index = -1;
        for (int i = 0; i < accountManager.accountCount; i++) {
            if (accountManager.accountList[i].accountNumber.equals(accountNumber)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            System.out.println("[입금] 입금할 금액을 입력하세요");
            int depositMoney = scanner.nextInt();

            if (depositMoney > 0) {
                accountManager.accountList[index].money += depositMoney;
                System.out.printf("[알림] %d원 입금 완료\n", depositMoney);
            } else {
                System.out.println("[알림] 금액 입력 오휴");
            }
        } else {
            System.out.println("[알림] 존재하지 않는 계좌입니다");
        }
    }

    /**
     * 인출
     */
    public void withdrawal() {
        System.out.println("[인출] 인출할 계좌번호를 입력하세요");
        String withdrawalAccountNumber = inputAccount();

        int index = checkMyAccount(withdrawalAccountNumber);

        if (index != -1) {
            System.out.println("[인출] 인출할 금액을 입력하세요");
            int money = scanner.nextInt();

            if (money <= accountManager.accountList[index].money) {
                accountManager.accountList[index].money -= money;
                System.out.println(money + "원이 인출되었습니다");
                System.out.printf("현재 남은 잔액은 %d 원입니다", accountManager.accountList[index].money);
            } else {
                System.out.println("[알림] 잔액부족");
            }
        } else {
            System.out.println("[알림] 본인 계좌가 아니거나 계좌번호가 기입 오류입니다");
        }
    }

    /**
     * 송금
     */
    public void wire() {
        System.out.println("[송금] 계좌번호를 입력하세요");
        String myAccount = inputAccount();
        int checkIndex = checkMyAccount(myAccount);
        if (checkIndex != -1) {
            System.out.println("[송금] 송금할 계좌를 입력하세요");
            String wireAccountNumber = inputAccount();
            int wireIndex = checkMyAccount(wireAccountNumber);
            if (wireIndex != -1) {
                System.out.println("[송금] 송금할 금액을 입력하세요");
                int money = scanner.nextInt();
                if (money <= accountManager.accountList[checkIndex].money) {
                    accountManager.accountList[checkIndex].money -= money;
                    accountManager.accountList[wireIndex].money += money;
                } else {
                    System.out.println("[알림] 잔액이 부족합니다");
                }
            } else {
                System.out.println("[알림] 송급할 계좌가 존재하지 않습니다");
            }
        } else {
            System.out.println("[알림] 계좌번호 입력오류");
        }
    }

    /**
     * 계좌 삭제
     */
    public void deleteAccount() {

    }

    /**
     * 계정 삭제
     */
    public void deleteClient() {

    }
}

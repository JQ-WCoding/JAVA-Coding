package com.bank;

import java.util.Random;
import java.util.Scanner;

public class AccountManager {
    Account[] accountList;
    int accountCount;

    /**
     * 계좌생성
     */
    public void addAccount(ClientManager clientManager, int log) {
        System.out.println("[계좌생성] 추가 생성할 계좌의 잔액을 입력하세요");
        int myMoney = Bank.scanner.nextInt();
        Account[] temp = accountList;
        accountList = new Account[accountCount + 1];
        for (int i = 0; i < accountCount; i++) {
            accountList[i] = new Account();
            accountList[i] = temp[i];
        }
        // 클라이언트 값은 그대로 가져온다
        accountList[accountCount] = new Account();
        accountList[accountCount].clientNo = clientManager.clientList[log].clientNo;
        // 계좌 번호 자동 생성 메소드
        accountList[accountCount].accountNumber = autoAccountNumber();
        accountList[accountCount].money = myMoney;
        accountCount++;
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
    public void checkAccount(ClientManager clientManager, int log) {
        System.out.println("[잔액확인] 본인 계좌번호를 3자리씩 작성해주세요 :");
        String myAccountNumber = inputAccount();
//        System.out.println(myAccountNumber);

        int index = checkMyAccount(myAccountNumber, clientManager, log);

        if (index != -1) {
            System.out.println("현재 잔액은 : " + accountList[index].money + "원 입니다");
        } else {
            System.out.println("[알림] 본인 계좌가 아니거나 계좌번호가 기입 오류입니다");
        }
    }

    /**
     * 계좌 번호 입력
     */
    public String inputAccount() {
        String inputAccount1 = Bank.scanner.next();
        System.out.println("-");
        inputAccount1 += "-";
        String inputAccount2 = Bank.scanner.next();
        System.out.println("-");
        inputAccount2 += "-";
        String inputAccount3 = Bank.scanner.next();

        return inputAccount1 + inputAccount2 + inputAccount3;
    }

    /**
     * 본인 계좌 확인
     */
    public int checkMyAccount(String myAccountNumber, ClientManager clientManager, int log) {
        int index = -1;
        for (int i = 0; i < accountCount; i++) {
            if (accountList[i].accountNumber.equals(myAccountNumber)) {
                if (accountList[i].clientNo == clientManager.clientList[log].clientNo) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    /**
     * 송급 계좌 확인
     */
    public int checkDepositAccount(String wireAccountNumber) {
        int index = -1;
        for (int i = 0; i < accountCount; i++) {
            if (accountList[i].accountNumber.equals(wireAccountNumber)) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * 입금
     */
    public void deposit() {
        System.out.println("[입금] 입금할 계좌 번호를 입력하세요");
        String accountNumber = inputAccount();
        int index = -1;
        for (int i = 0; i < accountCount; i++) {
            if (accountList[i].accountNumber.equals(accountNumber)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            System.out.println("[입금] 입금할 금액을 입력하세요");
            int depositMoney = Bank.scanner.nextInt();

            if (depositMoney > 0) {
                accountList[index].money += depositMoney;
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
    public void withdrawal(ClientManager clientManager, int log) {
        System.out.println("[인출] 인출할 계좌번호를 입력하세요");
        String withdrawalAccountNumber = inputAccount();

        int index = checkMyAccount(withdrawalAccountNumber, clientManager, log);

        if (index != -1) {
            System.out.println("[인출] 인출할 금액을 입력하세요");
            int money = Bank.scanner.nextInt();

            if (money <= accountList[index].money) {
                accountList[index].money -= money;
                System.out.println(money + "원이 인출되었습니다");
                System.out.printf("현재 남은 잔액은 %d 원입니다", accountList[index].money);
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
    public void wire(ClientManager clientManager, int log) {
        System.out.println("[송금] 계좌번호를 입력하세요");
        String myAccount = inputAccount();
        int checkIndex = checkMyAccount(myAccount, clientManager, log);
        if (checkIndex != -1) {
            System.out.println("[송금] 송금할 계좌를 입력하세요");
            String wireAccountNumber = inputAccount();
            int wireIndex = checkDepositAccount(wireAccountNumber);
            if (wireIndex != -1) {
                System.out.println("[송금] 송금할 금액을 입력하세요");
                int money = Bank.scanner.nextInt();
                if (money <= accountList[checkIndex].money) {
                    accountList[checkIndex].money -= money;
                    accountList[wireIndex].money += money;
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
    public void deleteAccount(ClientManager clientManager, int log) {
        System.out.println("[계좌 삭제] 삭제할 계좌 번호를 입력하세요");
        String deleteAccountNumber = inputAccount();
        int checkIndex = checkMyAccount(deleteAccountNumber, clientManager, log);
        if (checkIndex != -1) { // 일치하는 계좌 번호가 있을 경우
            System.out.println("[계좌 삭제] 남은 금액을 인출 후 삭제합니다");
            System.out.println(accountList[checkIndex].money + "원을 인출합니다");

            Account[] temp = accountList;
            accountList = new Account[accountCount - 1];
            int count = 0;
            for (int i = 0; i < accountCount; i++) {
                if (i != checkIndex) {
                    accountList[i] = new Account();
                    accountList[count] = temp[i];
                    count++;
                }
            }
            accountCount--;
            System.out.println("[알림] 계좌 번호가 삭제되었습니다");
        } else {
            System.out.println("[알림] 일치하는 계좌번호가 없거나 본인 계좌가 아닙니다");
        }
    }
}

package com.bank;

import java.util.Scanner;

public class ClientManager {
    Client[] clientList;
    int clientCount;

    /**
     * 계정 생성 기능
     */
    public void signIn() {
        while (true) {
            System.out.println("[계정생성] 생성할 ID를 입력하세요");
            String signInId = Bank.scanner.next();
            boolean sameId = false;
            // 아이디 중복 확인
            for (int i = 0; i < clientCount; i++) {
                if (clientList[i].id.equals(signInId)) {
                    sameId = true;
                    break;
                }
            }
            if (!sameId) { // 계정 생성 가능
                // client 생성 (pw, name, no)
                System.out.println("[계정생성] PW를 입력하세요");
                String signInPw = Bank.scanner.next();
                System.out.println("[계정생성] 이름을 입력하세요");
                String signInName = Bank.scanner.next();
                // no는 1부터 시작
                if (clientCount == 0) { // 첫 고객인경우
                    clientList = new Client[1]; // 1
                    clientList[0] = new Client();
                } else {
                    Client[] temp = clientList;
                    clientList = new Client[clientCount + 1];
                    for (int i = 0; i < clientCount; i++) {
                        clientList[i] = new Client();
                        clientList[i] = temp[i];
                    }
                }
                clientList[clientCount] = new Client();
                clientList[clientCount].id = signInId;
                clientList[clientCount].pwd = signInPw;
                clientList[clientCount].name = signInName;
                clientList[clientCount].clientNo = 1001 + clientCount;
                clientCount++;
                System.out.println("[알림] 계정생성 완료");
                break;
            } else {
                System.out.println("중복되는 ID");
            }
        }
    }

    /**
     * 계정 삭제
     */
    public boolean deleteClient(AccountManager accountManager, int log) {
        System.out.println("[계정 삭제] 현재 계정을 삭제 하겠습니까?");
        System.out.println("(1) yes , if no press anyKey");
        int choice = Bank.scanner.nextInt();

        if (choice == 1) { // yes
            int count = 0;
            for (int i = 0; i < accountManager.accountCount; i++) {
                if (accountManager.accountList[i].clientNo == clientList[log].clientNo) {
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("계좌는 없습니다");
            } else {
                int checkCount = count;
                int[] indexArray = new int[count];
                count = 0;
                for (int i = 0; i < accountManager.accountCount; i++) {
                    if (accountManager.accountList[i].clientNo == clientList[log].clientNo) {
                        indexArray[count] = i;
                        count++;
                    }
                }
                // accountManager 내의 accountList 재설정
                count = 0;
                int arrayCount = 0;
                Account[] accountsTemp = accountManager.accountList;
                accountManager.accountList = new Account[accountManager.accountCount - count];
                for (int i = 0; i < accountManager.accountCount; i++) {
                    if (i != indexArray[count]) {
                        accountManager.accountList[arrayCount] = new Account();
                        accountManager.accountList[arrayCount] = accountsTemp[i];
                        arrayCount++;
                    } else {
                        count++;
                    }
                }
                accountManager.accountCount -= checkCount;
            }
            count = 0;
            // clientManger 내의 clientList 재설정
            Client[] clientsTemp = clientList;
            clientList = new Client[clientCount - 1];
            for (int i = 0; i < clientCount; i++) {
                if (log != i) {
                    clientList[count] = clientsTemp[i];
                    count++;
                }
            }
            clientCount--;
//            log = -1;

            System.out.println("[알림] 계정이 삭제 되었습니다 메인메뉴로 이동합니다");
            return true;
        } else {
            System.out.println("[알림] 메뉴로 돌아갑니다");
            return false;
        }
    }
}

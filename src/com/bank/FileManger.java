package com.bank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FileManger {
    String clientFilename = "clientData.txt";
    String accountFileName = "accountData.txt";

    public void saveFile(AccountManager accountManager, ClientManager clientManager) {
        FileWriter clientFileWriter;
        FileWriter accountFileWriter;
        StringBuilder clientString = new StringBuilder();
        StringBuilder accountString = new StringBuilder();
        try {
            clientFileWriter = new FileWriter(clientFilename);
            clientString.append(clientManager.clientCount).append("\n");
            for (int i = 0; i < clientManager.clientCount; i++) {
                clientString.append(clientManager.clientList[i].clientNo).append("/");
                clientString.append(clientManager.clientList[i].id).append("/");
                clientString.append(clientManager.clientList[i].pwd).append("/");
                clientString.append(clientManager.clientList[i].name);
                clientString.append("\n");
            }
            clientFileWriter.write(clientString.toString());

            accountFileWriter = new FileWriter(accountFileName);
            accountString.append(accountManager.accountCount).append("\n");
            for (int i = 0; i < accountManager.accountCount; i++) {
                accountString.append(accountManager.accountList[i].clientNo).append("/");
                accountString.append(accountManager.accountList[i].accountNumber).append("/");
                accountString.append(accountManager.accountList[i].money);
                accountString.append("\n");
            }
            accountFileWriter.write(accountString.toString());

            clientFileWriter.close();
            accountFileWriter.close();
        } catch (Exception e) {
            System.out.println("저장 오류");
        }
    }

    public void loadFile(AccountManager accountManager, ClientManager clientManager) {
        FileReader clientFileReader;
        FileReader accountFileReader;
        BufferedReader clientBufferedReader;
        BufferedReader accountBufferReader;
        StringBuilder clientString = new StringBuilder();
        StringBuilder accountString = new StringBuilder();

        try {
            clientFileReader = new FileReader(clientFilename);
            accountFileReader = new FileReader(accountFileName);
            clientBufferedReader = new BufferedReader(clientFileReader);
            accountBufferReader = new BufferedReader(accountFileReader);

            read(clientBufferedReader, clientString);
            read(accountBufferReader, accountString);

            String[] clientTemp = clientString.toString().split("\n");
            clientManager.clientCount = Integer.parseInt(clientTemp[0]);
            clientManager.clientList = new Client[Integer.parseInt(clientTemp[0])];
            for (int i = 0; i < Integer.parseInt(clientTemp[0]); i++) {
                String[] inClientTemp = clientTemp[i + 1].split("/");
                clientManager.clientList[i] = new Client();
                clientManager.clientList[i].clientNo = Integer.parseInt(inClientTemp[0]);
                clientManager.clientList[i].id = inClientTemp[1];
                clientManager.clientList[i].pwd = inClientTemp[2];
                clientManager.clientList[i].name = inClientTemp[3];
            }

            String[] accountTemp = accountString.toString().split("\n");
            accountManager.accountCount = Integer.parseInt(accountTemp[0]);
            accountManager.accountList = new Account[Integer.parseInt(accountTemp[0])];
            for (int i = 0; i < Integer.parseInt(accountTemp[0]); i++) {
                String[] inAccountTemp = accountTemp[i + 1].split("/");
                accountManager.accountList[i] = new Account();
                accountManager.accountList[i].clientNo = Integer.parseInt(inAccountTemp[0]);
                accountManager.accountList[i].accountNumber = inAccountTemp[1];
                accountManager.accountList[i].money = Integer.parseInt(inAccountTemp[2]);
            }

            clientBufferedReader.close();
            accountBufferReader.close();
            clientFileReader.close();
            accountFileReader.close();
        } catch (Exception e) {
            System.out.println("불러오기 오류");
        }
    }

    /**
     * bufferReader
     */
    public void read(BufferedReader bufferedReader, StringBuilder stringBuilder) {
        try {
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                stringBuilder.append(line).append("\n");
            }
        } catch (Exception e) {
            System.out.println();
        }
    }
}

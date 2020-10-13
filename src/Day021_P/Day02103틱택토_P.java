package Day021_P;

import java.util.Scanner;

public class Day02103틱택토_P {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] sheet = new String[3][3];
        int[][] sheetCheck = new int[3][3];
        int[][] meCheck = new int[3][3];
        int[][] comCheck = new int[3][3];
        int count = 1;
        for (int i = 0; i < sheet.length; i++) {
            for (int j = 0; j < sheet[i].length; j++) {
                sheet[i][j] = "[ " + count + " ]";
                count++;
            }
        }

//        for (int i = 0; i < sheet.length; i++) {
//            for (int j = 0; j < sheet[i].length; j++) {
//                System.out.print(sheet[i][j] + " ");
//            }
//            System.out.println();
//        }
        // sheetCheck
        int sheetCount = 1;
        for (int i = 0; i < sheet.length; i++) {
            for (int j = 0; j < sheet[i].length; j++) {
                sheetCheck[i][j] = sheetCount;
                sheetCount++;
            }
        }
        int turnCheck = 1;
        while (true) {
            int bingoCount = 0;
            int turn = 1;
            for (int i = 0; i < sheet.length; i++) {
                for (int j = 0; j < sheet[i].length; j++) {
                    System.out.print(sheet[i][j] + " ");
                }
                System.out.println();
            }
            // 나의 턴
            if (turn == 1) {
                System.out.println("==나의 턴==");
                System.out.println("숫자를 입력하세요 : ");
                int myPoint = sc.nextInt();
                for (int i = 0; i < sheet.length; i++) {
                    for (int j = 0; j < sheet[i].length; j++) {
                        if (sheetCheck[i][j] == myPoint) {
                            sheetCheck[i][j] = 0;
                            sheet[i][j] = "[ O ]";
                        }
                    }
                }

                for (int i = 0; i < sheet.length; i++) {
                    if(sheetCheck[i][0] == 0 && sheetCheck[i][1] == 0 && sheetCheck[i][2] == 0){
                        bingoCount++;
                    }
                    if(sheetCheck[0][i] == 0 && sheetCheck[1][i] == 0 && sheetCheck[2][i] == 0){
                        bingoCount++;
                    }
                    if(sheetCheck[0][0] == 0 && sheetCheck[1][1] == 0 && sheetCheck[2][2] == 0){
                        bingoCount++;
                    }
                    if(sheetCheck[0][2] == 0 && sheetCheck[1][1] == 0 && sheetCheck[2][0] == 0){
                        bingoCount++;
                    }
                }
                if (bingoCount == 1) {
                    break;
                }
                turn = 2;
                turnCheck = 2;
            }
            // 상대 턴
            if (turn == 2) {
                System.out.println("==상대 턴==");
                System.out.println("숫자를 입력하세요 : ");
                int yourPoint = sc.nextInt();
                for (int i = 0; i < sheet.length; i++) {
                    for (int j = 0; j < sheet[i].length; j++) {
                        if (sheetCheck[i][j] == yourPoint) {
                            sheetCheck[i][j] = 0;
                            sheet[i][j] = "[ O ]";
                        }
                    }
                }
                for (int i = 0; i < sheet.length; i++) {
                    if(sheetCheck[i][0] == 0 && sheetCheck[i][1] == 0 && sheetCheck[i][2] == 0){
                        bingoCount++;
                    }
                    if(sheetCheck[0][i] == 0 && sheetCheck[1][i] == 0 && sheetCheck[2][i] == 0){
                        bingoCount++;
                    }
                    if(sheetCheck[0][0] == 0 && sheetCheck[1][1] == 0 && sheetCheck[2][2] == 0){
                        bingoCount++;
                    }
                    if(sheetCheck[0][2] == 0 && sheetCheck[1][1] == 0 && sheetCheck[2][0] == 0){
                        bingoCount++;
                    }
                }
                if (bingoCount == 1) {
                    break;
                }
                turnCheck = 1;
            }
//            for (int i = 0; i < sheet.length; i++) {
//                    if(sheetCheck[i][0] == 0 && sheetCheck[i][1] == 0 && sheetCheck[i][2] == 0){
//                        bingoCount++;
//                    }
//                    if(sheetCheck[0][i] == 0 && sheetCheck[1][i] == 0 && sheetCheck[2][i] == 0){
//                        bingoCount++;
//                    }
//                    if(sheetCheck[0][0] == 0 && sheetCheck[1][1] == 0 && sheetCheck[2][2] == 0){
//                        bingoCount++;
//                    }
//                    if(sheetCheck[0][2] == 0 && sheetCheck[1][1] == 0 && sheetCheck[2][0] == 0){
//                        bingoCount++;
//                    }
//            }
//            if (bingoCount == 1) {
//                turnCheck = 2;
//                act = false;
//            }
        }
        if (turnCheck == 1){
            System.out.println("2P 승리");
        }
        else if(turnCheck == 2){
            System.out.println("1P 승리");
        }
        System.out.println("게임종료");
        sc.close();
    }
}

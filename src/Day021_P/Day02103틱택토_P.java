package Day021_P;

import java.util.Scanner;

public class Day02103틱택토_P {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] sheet = new String[3][3];
        int[][] sheetCheck = new int[3][3];
        int count = 1;
        for (int i = 0; i < sheet.length; i++) {
            for (int j = 0; j < sheet[i].length; j++) {
                sheet[i][j] = "[ " + count + " ]";
                count++;
            }
        }
        // sheetCheck
        int sheetCount = 1;
        for (int i = 0; i < sheet.length; i++) {
            for (int j = 0; j < sheet[i].length; j++) {
                sheetCheck[i][j] = sheetCount;
                sheetCount++;
            }
        }
        int turn = 1;
        int turnCheck = 1;
        while (true) {
            int bingoCount = 0;
            for (int i = 0; i < sheet.length; i++) {
                for (int j = 0; j < sheet[i].length; j++) {
                    System.out.print(sheet[i][j] + " ");
                }
                System.out.println();
            }
            // 나의 턴
            if (turn == 1) {
                System.out.println("==나의 턴==");
                boolean run = true;
                while (run) {
                    System.out.println("숫자를 입력하세요 : ");
                    int myPoint = sc.nextInt();
                    if (myPoint < 10 && myPoint >= 0) {
                        for (int i = 0; i < sheet.length; i++) {
                            for (int j = 0; j < sheet[i].length; j++) {
                                if (sheetCheck[i][j] == myPoint) {
                                    sheetCheck[i][j] = 0;
                                    sheet[i][j] = "[ O ]";
                                    run = false;
                                    turn = 2;
                                }
                            }
                        }
                    } else {
                        System.out.println("기입오류");
                    }
                }
                turnCheck = 1;
            }
            // 상대 턴
            else if (turn == 2) {
                boolean run = true;
                System.out.println("==상대 턴==");
                while (run) {
                    System.out.println("숫자를 입력하세요 : ");
                    int yourPoint = sc.nextInt();
                    if (yourPoint < 10 && yourPoint >= 0) {
                        for (int i = 0; i < sheet.length; i++) {
                            for (int j = 0; j < sheet[i].length; j++) {
                                if (sheetCheck[i][j] == yourPoint) {
                                    sheetCheck[i][j] = 0;
                                    sheet[i][j] = "[ O ]";
                                    run = false;
                                    turn = 1;
                                }
                            }
                        }
                    } else {
                        System.out.println("기입오류");
                    }
                }
                turnCheck = 2;
            }
            for (int i = 0; i < 3; i++) {
                if (sheetCheck[i][0] == 0 && sheetCheck[i][1] == 0 && sheetCheck[i][2] == 0) {
                    bingoCount++;
                } else if (sheetCheck[0][i] == 0 && sheetCheck[1][i] == 0 && sheetCheck[2][i] == 0) {
                    bingoCount++;
                }
            }
            if (sheetCheck[0][0] == 0 && sheetCheck[1][1] == 0 && sheetCheck[2][2] == 0) {
                bingoCount++;
            } else if (sheetCheck[0][2] == 0 && sheetCheck[1][1] == 0 && sheetCheck[2][0] == 0) {
                bingoCount++;
            }
            if (bingoCount == 1) {
                break;
            }
        }
        switch (turnCheck) {
            case 1 -> System.out.println("1P승리");
            case 2 -> System.out.println("2P승리");
        }

        System.out.println("게임종료");
        sc.close();
    }
}
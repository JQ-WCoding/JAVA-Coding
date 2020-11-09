package Day035P;

import java.util.Scanner;

/**
 * # 오목
 * 두 사람이 번갈아 돌을 놓아
 * 가로나 세로, 대각선으로 다섯 개의 연속된 돌을 놓으면 이기는 게임이다.
 */

public class Day03501오목P {
    final int SIZE = 10;
    static final int incomplete = -1;
    static int check = incomplete;
    int[][] omok = new int[SIZE][SIZE];

    /**
     * 해당턴의 플레이어 바둑알 두기
     */
    public void playGame(int playerTurn) { // 바둑알 두는 행위
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showBoard();
            System.out.println(playerTurn + "P 돌의 x좌표를 선택하세요 : ");
            int myXIndex = scanner.nextInt();
            System.out.println(playerTurn + "P 돌의 y좌표를 선택하세요 : ");
            int myYIndex = scanner.nextInt();
            // 범위 외의 값 입력시 오류
            if (myXIndex < 0 || myXIndex > 9 || myYIndex < 0 || myYIndex > 9) {
                System.out.println("잘못된 좌표입니다");
                continue;
            }
            // 정상적인 작동
//            if (omok[myXIndex][myYIndex] != 0) { // 돌이 없는 경우
//                System.out.println("이미 돌이 있습니다");
//                continue;
//            }
            if (IsEmpty(myXIndex, myYIndex))
                continue;
            omok[myXIndex][myYIndex] = playerTurn;
            // 승리 판별
            if (winnerCheck(playerTurn) == playerTurn) {
                System.out.println(playerTurn + "P 승리");
            }
            break;
        }
    }

    //돌이 놓여저있는지 체크하는 함수메소드
    public boolean IsEmpty(int x, int y) {
        if (omok[x][y] != 0) {
            return false;
        } else {
            System.out.println("이미 돌이 있습니다");
            return true;
        }
    }

    /**
     * 승자체크
     * 가로,세로
     * 좌상우하 대각선
     * 우상좌하 대각선
     * 총 연속된 5알이 확인되면 승자 출력
     */
    public int winnerCheck(int playerStone) { // 승자 체크
        int inCheck = incomplete;
        int index1 = incomplete, index2 = incomplete; //
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (omok[i][j] == playerStone) {
                    index1 = i;
                    index2 = j;
                    inCheck = i;
                    break;
                }
            }
            if (inCheck != incomplete) {
                break;
            }
        }
        // 가로 빙고 체크
        if (index1 < 6) {
            int horizontalCount = 0;
            for (int i = 0; i < 5; i++) {
                if (omok[index1 + i][index2] == playerStone) {
                    horizontalCount++;
                }
            }
            if (horizontalCount == 5) {
                check = playerStone;
            }
        }
        // 세로 빙고 체크
        if (index2 < 6) {
            int verticalCount = 0;
            for (int i = 0; i < 5; i++) {
                if (omok[index1][index2 + i] == playerStone) {
                    verticalCount++;
                }
            }
            if (verticalCount == 5) {
                check = playerStone;
            }
        }
        // 대각선 빙고 체크
        if (index1 < 6 && index2 < 6) {
            int diagonalCount = 0;
            for (int i = 0; i < 5; i++) {
                if (omok[index1 + i][index2 + i] == playerStone) {
                    diagonalCount++;
                }
            }
            if (diagonalCount == 5) {
                check = playerStone;
            }
        }
        // 역방향 대각선 빙고 체크
        int reverseDiagonalCount = 0;
        if (index2 > 3 && index1 < 6) {
            for (int i = 0; i < 5; i++) {
                if (omok[index1 + i][index2 - i] == playerStone) {
                    reverseDiagonalCount++;
                }
            }
            if (reverseDiagonalCount == 5) {
                check = playerStone;
            }
        }
        // 결과 반환
        return check;
    }

    public void switchTurn() {
        while (true) {
            playGame(1);
            if (check != incomplete) {
                break;
            }
            playGame(2);
            if (check != incomplete) {
                break;
            }
        }
    }

    public void showBoard() { // 오목판 출력
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(" " + (i) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(omok[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Day03501오목P day03501 = new Day03501오목P();
        day03501.switchTurn();
    }
}

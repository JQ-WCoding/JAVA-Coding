package Day034P;

import javax.swing.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Day03402빙고2P {
    /**
     * 2인 플레이 빙고 게임
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        /*
        1차 배열을 이용하여 각 플레이어마다 랜덤한 수를 입력받은 후,
        중복검사 실시
         */
        int[] player1 = new int[25];
        int[] player2 = new int[25];
        int[][] player1Bingo = new int[5][5];
        int[][] player2Bingo = new int[5][5];
        for (int i = 0; i < player1.length; i++) {
            player1[i] = random.nextInt(50) + 1;
            for (int j = 0; j < i; j++) {
                if (player1[i] == player1[j]) {
                    i--;
                }
            }
        }
        for (int i = 0; i < player2.length; i++) {
            player2[i] = random.nextInt(50) + 1;
            for (int j = 0; j < i; j++) {
                if (player2[i] == player2[j]) {
                    i--;
                }
            }
        }
        for (int i = 0; i < player1.length; i++) {
            for (int j = 0; j < player1.length; j++) {
                System.out.print(player1[i]);
            }
            System.out.println();
        }
        /*
        중복 값없이 생성이 완료된 1차 배열을
        각각 2차 배열에 값 입력
         */
        int count = 0;
        for (int i = 0; i < player1Bingo.length; i++) {
            for (int j = 0; j < player1Bingo.length; j++) {
                player1Bingo[i][j] = player1[count];
                player2Bingo[i][j] = player2[count];
                count++;
            }
        }

        while (true) {
            System.out.println("===1P===");
            for (int i = 0; i < player1Bingo.length; i++) {
                for (int j = 0; j < player1Bingo.length; j++) {
                    System.out.printf("%d \t", player1Bingo[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            //player2 빙고 판 출력
            System.out.println("===2P===");
            for (int i = 0; i < player2Bingo.length; i++) {
                for (int j = 0; j < player2Bingo.length; j++) {
                    System.out.printf("%d \t", player2Bingo[i][j]);
                }
                System.out.println();
            }
            /*
            게임 완료조건을 확인하기 위한 변수 1p, 2p 카운트 선언 및 초기화
             */
            int player1BingoCount = 0;
            int player2BingoCount = 0;
            /*
            1P가 값을 먼저 입력하는 경우
             */
            System.out.println("1P) 인덱스 1의 값을 입력하세요 : ");
            int playerIndex1 = scanner.nextInt();
            System.out.println("1P) 인덱스 2의 값을 입력하세요 : ");
            int playerIndex2 = scanner.nextInt();
            /*
            모든 예외처리 및 상황처리 부분
             */
            if (playerIndex1 > 4 && playerIndex2 > 4) { // 예외처리 인덱스 값을 잘못입력하였을 경우
                System.out.println("잘못입력하였습니다");
                continue;
            }
            int sameNumberCheck = 0;
            if (player1Bingo[playerIndex1][playerIndex2] != 0) {
                // player2Bingo 의 같은 수를 찾아 확인해주기
                sameNumberCheck = player1Bingo[playerIndex1][playerIndex2];
                for (int i = 0; i < player2Bingo.length; i++) {
                    for (int j = 0; j < player2Bingo.length; j++) {
                        if (sameNumberCheck == player2Bingo[i][j]) { // 같은 값이 존재하는 경우 0으로 값 교체
                            player2Bingo[i][j] = 0;
                        }
                    }
                }
                player1Bingo[playerIndex1][playerIndex2] = 0; // p1의 빙고판 값 0으로 교페
            } else { // 이미 한번 입력하여 0으로 변해있거나 상대로 인해 0으로 변환된 판
                System.out.println("이미 체크된 좌표입니다.");
                continue;
            }
            /*
            빙고 확인 부분
             */
            for (int i = 0; i < player1Bingo.length; i++) { // 가로, 세로 판정용
                int player1ArrayBingoCount1 = 0; // p1 가로용 카운트
                int player1ArrayBingoCount2 = 0; // p1 세로용 카운트
                int player2ArrayBingoCount1 = 0; // p2 가로용 카운트
                int player2ArrayBingoCount2 = 0; // p2 세로용 카운트

                for (int j = 0; j < player1Bingo.length; j++) { // 가로, 세로 판정용
                    /*
                    4가지 경우를 모두 확인해야하니 if로 사용한다
                     */
                    if (player1Bingo[i][j] == 0) {
                        player1ArrayBingoCount1++;
                    }
                    if (player1Bingo[j][i] == 0) {
                        player1ArrayBingoCount2++;
                    }
                    if (player2Bingo[i][j] == 0) {
                        player2ArrayBingoCount1++;
                    }
                    if (player2Bingo[j][i] == 0) {
                        player2ArrayBingoCount2++;
                    }
                    /*
                    플레이어 1,2 모두 빙고 상태 확인
                     */
                    if (player1ArrayBingoCount1 == 5 || player1ArrayBingoCount2 == 5) { // 가로나 세로중 완성된 경우 빙고 카운트 증가
                        player1BingoCount++;
                    }
                    if (player2ArrayBingoCount1 == 5 || player2ArrayBingoCount2 == 5) {
                        player2BingoCount++;
                    }
                }
            }
            /*
            대각선 방향 확인
             */
            int player1ArrayBingoCount1 = 0; // p1 좌상 우하 대각선 체크용 카운트
            int player1ArrayBingoCount2 = 0; // p1 좌하 대각선 체크용 카운트
            int player2ArrayBingoCount1 = 0; // p2 좌상 우하 대각선 체크용 카운트
            int player2ArrayBingoCount2 = 0; // p2 좌하 대각선 체크용 카운트
            for (int i = 0; i < player1Bingo.length; i++) { // 좌상 우하 대각선의 경우, 우상 좌하 대각선의 경우
                if (player1Bingo[i][i] == 0) {
                    player1ArrayBingoCount1++;
                }
                if (player1Bingo[i][(player1Bingo.length - 1) - i] == 0) {
                    player1ArrayBingoCount2++;
                }
                if (player2Bingo[i][i] == 0) {
                    player2ArrayBingoCount1++;
                }
                if (player2Bingo[i][(player1Bingo.length - 1) - i] == 0) {
                    player2ArrayBingoCount2++;
                }
                if (player1ArrayBingoCount1 == 5 || player1ArrayBingoCount2 == 5) {
                    player1BingoCount++;
                }
                if (player2ArrayBingoCount1 == 5 || player2ArrayBingoCount2 == 5) {
                    player2BingoCount++;
                }
            }


            /*
            게임 종료의 경우의 수 확인 (게임 결과 확인)
             */
            if (player1BingoCount == 3 || player2BingoCount == 3) { // 둘중 한명이라도 빙고 3이 되면 승자 확인 출력으로 이동
                if (player1BingoCount == 3) {
                    System.out.println("1P 승리");
                } else if (player2BingoCount == 3) {
                    System.out.println("2P 승리");
                }
                break;
            } else if (player1BingoCount == 3 && player2BingoCount == 3) { // 둘이 동시에 3줄 완성인 경우 "무승부" 출력
                System.out.println("무승부");
                break;
            }
        } // while
        scanner.close();
    } // main
} // class

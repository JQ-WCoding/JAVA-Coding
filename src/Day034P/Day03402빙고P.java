package Day034P;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * # 빙고 Ver1[플레이어 1명]
 * 1. 1~50 사이의 랜덤 숫자를 중복없이 배열에 저장
 * 2. 좌표값을 입력 해 원하는 숫자를 선택
 * 3. 상하좌우 그리고 대각선 12가지의 경우의 수를 판단해 승패 판정
 */
public class Day03402빙고P {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int[] num = new int[25]; // 1차 배열 내에 랜덤값 저장시키기
        for (int i = 0; i < num.length; i++) {
            num[i] = random.nextInt(50) + 1;
            for (int j = 0; j < i; j++) {
                if (num[i] == num[j]) {
                    i--;
                }
            }
        }
        int count = 0;
//        System.out.println(Arrays.toString(num)); // 확인용
        int maxNum = 5;
        /*
        num배열의 값을 bingo 2차 배열에 입력하는 과정
        count를 이용해 순서대로 입력받게 한다
         */
        int[][] bingo = new int[maxNum][maxNum];
        for (int i = 0; i < bingo.length; i++) {
            for (int j = 0; j < bingo[i].length; j++) {
                bingo[i][j] = num[count];
                count++;
            }
        }
        /*
        빙고 게임 시작
         */
        while (true) {
            int bingoCount = 0; // 항상 초기화 되어야한다

            for (int i = 0; i < bingo.length; i++) {
                for (int j = 0; j < bingo[i].length; j++) {
                    System.out.printf("%d \t", bingo[i][j]);
                }
                System.out.println();
            }

            System.out.println("첫번째 인덱스를 입력해주세요 : ");
            int index1 = scanner.nextInt();
            System.out.println("두번째 인덱스를 입력해주세요 : ");
            int index2 = scanner.nextInt();

            if (index1 > 4 && index2 > 4) { // 예외처리 인덱스 값을 잘못입력하였을 경우
                System.out.println("잘못입력하였습니다");
                continue;
            }

            if (bingo[index1][index2] != 0) { // bingo판이 0이 없는 경우 옳은 수를 지운다
                bingo[index1][index2] = 0;
            } else { // 이미 체크된 판인경우
                System.out.println("이미 체크한 판입니다.");
                continue; // 다시 재선택모드로 이동
            }
            for (int i = 0; i < bingo.length; i++) { // 가로, 세로 판정용
                int arrayBingoCount1 = 0; // 가로용 카운트
                int arrayBingoCount2 = 0; // 세로용 카운트
                for (int j = 0; j < bingo.length; j++) {
                    if (bingo[i][j] == 0) {
                        arrayBingoCount1++;
                    }
                    if (bingo[j][i] == 0) {
                        arrayBingoCount2++;
                    }
                    if (arrayBingoCount1 == 5 || arrayBingoCount2 == 5) { // 가로나 세로중 완성된 경우 빙고 카운트 증가
                        bingoCount++;
                    }
                }
            }

            int arrayBingoCount3 = 0; // 좌상 우하 대각선 체크용 카운트
            int arrayBingoCount4 = 0; // 우상 좌하 대각선 체크용 카운트
            for (int i = 0; i < bingo.length; i++) { // 좌상 우하 대각선의 경우, 우상 좌하 대각선의 경우
                if (bingo[i][i] == 0) {
                    arrayBingoCount3++;
                }
                if (bingo[i][(bingo.length - 1) - i] == 0) {
                    arrayBingoCount4++;
                }
                if (arrayBingoCount3 == 5 || arrayBingoCount4 == 5) {
                    bingoCount++;
                }
            }
            // (0,4) , (1,3) , (2,2) , (3,1) , (4,0)

            // 결과확인(현재 빙고 상태 확인용)
            if (bingoCount == 3) { // bingo 3줄일 경우
                System.out.println("Game end!");
                break;
            } else {
                System.out.println("현재 상태 : " + bingoCount + "빙고");
            }

        } // while

    } // main
} // class

package Day027P;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Day02703BaseBallGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        /*
         * # 숫자야구 게임
         * 1. me에 1~9사이의 숫자 3개를 저장한다.
         *    (단, 중복되는 숫자는 저장 불가 <- 중복숫자 금지 2단계 적용)
         * 2. com과 me를 비교해 정답을 맞출 때까지 반복한다.
         * 3. 숫자와 자리가 모두 같으면		strike++
         *    숫자만 같고 자리가 틀리면		ball++
         *
         * 예)
         * 정답 : 1 7 3
         * 입력 : 1 3 5		1strike, 1ball
         * 입력 : 1 5 6		1strike
         */
        int[] com = new int[3];
        int[] me = new int[3];
        /*
        com 배열에 중복되지않게 1 ~ 9사이의 랜덤 숫자 넣어두기
        */
        for (int i = 0; i < com.length; i++) {
            com[i] = random.nextInt(9) + 1; // 1 ~ 9 범위
            for (int j = 0; j < i; j++) {
                if (com[i] == com[j]) {
                    i--;
                }
            }
        } // for
        System.out.println(Arrays.toString(com));
        while (true) { // 게임 시작
            int strikeCount = 0;
            int ballCount = 0;
            for (int i = 0; i < me.length; i++) {
                System.out.printf("%d번째 예상 숫자를 입력하세요 %n", (i + 1));
                me[i] = scanner.nextInt(); // me 배열에 순서대로 입력
                for (int j = 0; j < i; j++) {
                    if (me[i] == me[j]) {
                        System.out.println("중복숫자입니다 다시 입력하세요");
                        i--;
                    }
                }
            }
            for (int i = 0; i < com.length; i++) {
                if (me[i] == com[i]) {
                    strikeCount++;
                } // strikeCount 게산
                for (int j = 0; j < com.length; j++) { // ballCount 계산
                    if (i != j) {
                        if (com[i] == me[j]) {
                            ballCount++;
                        }
                    }
                }
            }
            System.out.printf("StrikeCount : %d // BallCount : %d %n", strikeCount, ballCount);
            if (strikeCount == 3) { // 스트라이크 카운트가 3이면 게임 끝
                System.out.println("Success!");
                break;
            }
        } // while
    } // main
} // class

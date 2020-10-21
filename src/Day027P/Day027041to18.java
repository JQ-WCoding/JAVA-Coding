package Day027P;

import java.util.Random;
import java.util.Scanner;

public class Day027041to18 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        /*
         * # 1 to 50 ===> 1 to 18
         *
         * 1. 구글에서 1 to 50이라고 검색해 게임을 실습해본다.
         * 2. 위 게임을 숫자범위를 좁혀 1 to 18로 직접 구현한다.
         * 3. 숫자 1 ~ 9는 front배열에 저장하고,
         *    숫자 10 ~ 18은 back배열에 저장한다.
         */
        int[] front = new int[9];
        int[] back = new int[9];
        /*
        Game Setting
         */
        // front배열에 값 중복방지 후 1 ~ 9까지 입력
        for (int i = 0; i < front.length; i++) {
            front[i] = random.nextInt(9) + 1; // 9개
            for (int j = 0; j < i; j++) {
                if (front[i] == front[j]) {
                    i--;
                }
            }
        }
        // back배열에 값 중복방지 후 10 ~ 18까지 입력
        for (int i = 0; i < back.length; i++) {
            back[i] = random.nextInt(9) + 10; // 9개
            for (int j = 0; j < i; j++) {
                if (back[i] == back[j]) {
                    i--;
                }
            }
        }
        /*
        GameStart
         */
        int numberCount = 1;
        while (true) {
            for (int i = 0; i < front.length; i++) {
                System.out.print(front[i] + " ");
                if (i % 3 == 2) {
                    System.out.println();
                }
            }
            System.out.printf("%d의 위치를 찾아 입력하세요 : %n", numberCount);
            int myIndex = scanner.nextInt() - 1;
            if (myIndex > 9 || myIndex < 0) {
                continue;
            }
            if (numberCount == front[myIndex]) {
                front[myIndex] = back[myIndex];
                back[myIndex] = 0;
                numberCount++;
            }
            if (numberCount == 19) {
                System.out.println("Game End");
                break;
            }
        } // while
    } // main
} // class

package Day027P;

import java.util.Random;
import java.util.Scanner;

public class Day027041to18Gonetoofar {
    Random random = new Random();

    void backArray(int[] back) {
        for (int i = 0; i < back.length; i++) {
            back[i] = random.nextInt(9) + 10; // 9개
            for (int j = 0; j < i; j++) {
                if (back[i] == back[j]) {
                    i--;
                }
            }
        }

    }

    void frontArray(int[] front) {
        for (int i = 0; i < front.length; i++) {
            front[i] = random.nextInt(9) + 1; // 9개
            for (int j = 0; j < i; j++) {
                if (front[i] == front[j]) {
                    i--;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Day027041to18Gonetoofar arrayMethod = new Day027041to18Gonetoofar();



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

        arrayMethod.frontArray(front);
        arrayMethod.backArray(back);
        /*
        Game Setting
         */
        /*
        for(int i =0;i<9;i++){
       front[i] = i + 1;
       back[i] = i + 9;
       }
       이후 셔플 돌리기
         */
        // front배열에 값 중복방지 후 1 ~ 9까지 입력
//        for (int i = 0; i < front.length; i++) {
//            front[i] = random.nextInt(9) + 1; // 9개
//            for (int j = 0; j < i; j++) {
//                if (front[i] == front[j]) {
//                    i--;
//                }
//            }
//        }
//        // back배열에 값 중복방지 후 10 ~ 18까지 입력
//        for (int i = 0; i < back.length; i++) {
//            back[i] = random.nextInt(9) + 10; // 9개
//            for (int j = 0; j < i; j++) {
//                if (back[i] == back[j]) {
//                    i--;
//                }
//            }
//        }
//        int newNumber = front.length + back.length;
//        int[] temp = new int[newNumber];

        /*
        GameStart

         */
        int numberCount = 1;
        while (true) {
            for (int i = 0; i < front.length; i++) {
                System.out.print(front[i] + " ");
                if (i % 3 == 2) { // 출력 3번마다 띄어쓰기
                    System.out.println();
                }
            }
            System.out.printf("%d의 위치를 찾아 입력하세요 : %n", numberCount);
            int myIndex = scanner.nextInt() - 1;
            if (myIndex > 9 || myIndex < 0) { // 1 ~ 9 외의 다른 숫자를 기입하면 바로 반복문 처음부터 실행 시키기
                continue;
            }
            if (numberCount == front[myIndex]) { // number 카운트는 곧 정답을 의미
                front[myIndex] = back[myIndex]; // front의 수를 back으로 대체하기
//                front[myIndex] = numberCount + front.length;
                numberCount++; // 정답을 맞췄을 경우에만 계속 증가 시키기
            }
            if (numberCount == front.length + back.length) { // 총 배열의 방 합 이상이되면 더 이상 진행 필요 없음 = 18
                System.out.println("Game End");
                break; // 반복문 탈출
            }
        } // while
    } // main
} // class

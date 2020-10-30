package Day031P;

import java.util.Scanner;

public class Day031사다리P {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*
         * # 사다리 게임
         * 1. 인덱스 0~4를 하나선택한다.
         * 2. 숫자 0 을 만나면 그냥 아래로 내려간다.
         * 3. 숫자 1 을 만나면 오른쪽으로 이동후 내려간다.
         * 4. 숫자 2 를 만나면 완쪽으로 이동후 내려간다.
         * 5. 오늘의 메뉴 출력
         */

        String[] menu = {"떡라면", "돈까스", "짜장면", "쫄면", "된장찌개"};

        int ladder[][] = {
                {0, 0, 0, 0, 0},
                {1, 2, 0, 1, 2},
                {0, 1, 2, 0, 0},
                {0, 0, 1, 2, 0},
                {1, 2, 0, 0, 0},
                {0, 1, 2, 0, 0},
                {1, 2, 0, 0, 0},
                {0, 0, 0, 1, 2},
                {0, 0, 0, 0, 0}
        };
        System.out.println("사다리 하나를 선택하세요 : (0 ~ 4)");
        int myLadder = scanner.nextInt(); // choose ladder number
//        ladder[verticalIndex][myLadder] start
        int verticalIndex = 0;
        while (verticalIndex < ladder.length) {
            if (ladder[verticalIndex][myLadder] == 1) {
                myLadder++; // ++ moving
            }
            else if (ladder[verticalIndex][myLadder] == 2) {
                myLadder--; // -1 moving
            }
            System.out.println(ladder[verticalIndex][myLadder]);
            verticalIndex++;
        }
        System.out.println(menu[myLadder]);
    }
}

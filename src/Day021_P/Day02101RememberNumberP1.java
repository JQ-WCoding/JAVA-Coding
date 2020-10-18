package Day021_P;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Day02101RememberNumberP1 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        /*
         * # 기억력 게임
         * 1. 같은 숫자의 위치를 2개 입력해 정답을 맞추는 게임이다.
         * 2. 정답을 맞추면 back에 해당 숫자를 저장해,
         *    back에 모든 수가 채워지면 게임은 종료된다.
         * 예)
         * front = [1, 1, 2, 2, 3, 3, 4, 4, 5, 5]
         * back  = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
         * 입력1 : 0
         * 입력2 : 1
         *
         * front = [1, 1, 2, 2, 3, 3, 4, 4, 5, 5]
         * back  = [1, 1, 0, 0, 0, 0, 0, 0, 0, 0]
         */
        int[] front = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        int[] back = new int[10];

        // 셔플(shuffle)
        int i = 0;
        while (i < 1000) {
            int r = random.nextInt(10);
            int temp = front[0];
            front[0] = front[r];
            front[r] = temp;
            i++;
        }

        for (int j = 0; j < 10; j++) {
            System.out.print(front[j] + " ");
        }
        System.out.println();

        while (true) {
            System.out.println(Arrays.toString(back));

            System.out.println("1 Guess");
            int firstIdx = scanner.nextInt();
            System.out.println("2 Guess");
            int secondIdx = scanner.nextInt();

            if (front[firstIdx] == front[secondIdx]) {
                back[firstIdx] = front[firstIdx];
                back[secondIdx] = front[secondIdx];
            }

            int check = -1;
            for (int j = 0; j < back.length; j++) {
                if (back[j] == 0) {
                    check = 1;
                }
            }
            if (check == -1) {
                System.out.println("Success!");
                break;
            }
        }

    }
}

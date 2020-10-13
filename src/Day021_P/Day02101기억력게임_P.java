package Day021_P;

import java.util.Random;
import java.util.Scanner;

public class Day02101기억력게임_P {
    public static void main(String[] args) {
        Random ran = new Random();
        Scanner sc = new Scanner(System.in);
        int[] front = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        int[] back = new int[10];

        // 셔플(shuffle)
        int i = 0;
        while (i < 1000) {
            int r = ran.nextInt(10);
            int temp = front[0];
            front[0] = front[r];
            front[r] = temp;

            i += 1;
        }

        for (int j = 0; j < 10; j++) {
            System.out.print(front[j] + " ");
        }
        System.out.println();
        boolean run = true;

        while (run) {
            System.out.println("[1]번째 번호를 입력하세요");
            int myIndex1 = sc.nextInt();
            System.out.println("[2]번째 번호를 입력하세요");
            int myIndex2 = sc.nextInt();

            if (front[myIndex1 - 1] == front[myIndex2 - 1]) {
                back[myIndex1 - 1] = front[myIndex1 - 1];
                back[myIndex2 - 1] = front[myIndex2 - 1];
            }

            for (int j = 0; j < front.length; j++) {
                System.out.print(back[j] + " ");
            }
            System.out.println();
            int count = 0;
            for (int j = 0; j < front.length; j++) {
                if(back[j] != 0) {
                    if (front[j] == back[j]) {
                        count++;
                    }
                }
            }
            if (count == 10) {
                run = false;
            }
        }
        System.out.println("게임완료");
        sc.close();
    }
}

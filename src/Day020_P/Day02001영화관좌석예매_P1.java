package Day020_P;

import java.util.Arrays;
import java.util.Scanner;

public class Day02001영화관좌석예매_P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] seat = new int[7];
        Arrays.fill(seat, 0);

        System.out.println();
        boolean run = true;
        while (run) {
            for (int i = 0; i < seat.length; i++) {
                if (seat[i] == 0) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[O]");
                }
            }
            System.out.println("예매하고 싶은 좌석번호를 입력하세요 : ");
            int myChoice = sc.nextInt() - 1;
            if (seat[myChoice] == 0) {
                seat[myChoice] = 1;
                System.out.println("예약완료");
            } else {
                System.out.println("예약된 자리");
            }

            System.out.println("종료하시겠습니까? (1)Yes / (2)No");
            int endChoice = sc.nextInt();
            switch (endChoice) {
                case 1:
                    System.out.println("프로그램 종료");
                    run = false;
                    break;
                case 2:
                    continue;
                default:
                    System.out.println("입력오류");
                    break;
            }
        }
    }
}

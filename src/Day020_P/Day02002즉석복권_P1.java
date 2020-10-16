package Day020_P;

import java.util.Random;
import java.util.Scanner;

//  20.10.16
public class Day02002즉석복권_P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        // 7이 3연속 등장하면 성공?
        int[] lotto = {0, 0, 7, 7, 7, 0, 0, 0}; // 8 자리
        // int[] lotto = {0, 7, 0, 0, 7, 7, 0, 0};

        while (true) { // 반복문 실행
            // shuffle
            int shuffle = 0;
            while (shuffle < 1000) { // 로또 번호 섞기
                int r = random.nextInt(8);
                int temp = lotto[0];
                lotto[0] = lotto[r];
                lotto[r] = temp;
                shuffle++;
            } // 셔플 완료
            System.out.println("[1]복권결과 확인");
            System.out.println("[0]종료");
            int menuChoice = scanner.nextInt();
            if (menuChoice == 1) {
                System.out.println("[결과확인]");
                for (int i : lotto) {
                    System.out.print(i + " ");
                }
                System.out.println(); // 줄바꿈
                int check = -1;
                for (int i = 0; i < lotto.length; i++) {
                    if (i < lotto.length - 2) {
                        if (lotto[i] == 7 && lotto[i + 1] == 7 && lotto[i + 2] == 7) {
                            check = 1;
                        }
                    }
                }
                if (check != -1) {
                    System.out.println("[당첨]");
                } else {
                    System.out.println("[탈락]");
                }
            } else if (menuChoice == 0) { // 프로그램 종료
                System.out.println("프로그램 종료");
                break; // 반복문 종료
            }
        }
    }
}

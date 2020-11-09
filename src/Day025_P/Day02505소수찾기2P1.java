package Day025_P;

import java.util.Scanner;

public class Day02505소수찾기2P1 {
    /**
     * # 소수찾기(2단계)
     * 정수 한 개를 입력받아, 2부터 해당 숫자까지의 모든 소수를 출력한다.
     * 예) 입력 : 10
     * 정답 : 2, 3, 5, 7
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("정수를 입력하세요 : ");
        int myNum = scanner.nextInt(); // 정수 입력받기

        for (int i = 1; i < myNum; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count == 2){
                System.out.print(i + " ");
            }
        }
    }
}

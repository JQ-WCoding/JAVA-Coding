package Day026P;

import java.util.Arrays;
import java.util.Scanner;

public class Day02603최대값구하기P {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
         * # 최대값 구하기
         * 1. 가장 큰 값을 찾아 입력한다.
         * 2. 정답이면 해당 값을 0으로 변경한다.
         * 3. arr 배열의 모든 값이 0으로 변경되면 프로그램은 종료된다.
         *
         * 11, 87, 42, 100, 24
         * 입력 : 100
         *
         * 11, 87, 42, 0, 24
         *
         * 입력 : 87
         * 11, 0, 42, 0, 24
         */

        int[] arr = {11, 87, 42, 100, 24};
        int count = 0;
        while (true) {
            System.out.println(Arrays.toString(arr));
            System.out.println("배열 내의 값을 입력하세요 : ");
            int myNum = scanner.nextInt();
            for (int i = 0; i < arr.length; i++) {
                if (myNum == arr[i]) {
                    arr[i] = 0;
                    count++;
                }
            }
            if (count == 5) {
                System.out.println("Success");
                break;
            }
        }
    }
}

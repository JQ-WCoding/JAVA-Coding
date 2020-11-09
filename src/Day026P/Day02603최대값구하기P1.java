package Day026P;

import java.util.Arrays;
import java.util.Scanner;

public class Day02603최대값구하기P1 {
    /**
     * # 최대값 구하기
     * 1. 가장 큰 값을 찾아 입력한다.
     * 2. 정답이면 해당 값을 0으로 변경한다.
     * 3. arr 배열의 모든 값이 0으로 변경되면 프로그램은 종료된다.
     * <p>
     * 11, 87, 42, 100, 24
     * 입력 : 100
     * <p>
     * 11, 87, 42, 0, 24
     * <p>
     * 입력 : 87
     * 11, 0, 42, 0, 24
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {11, 87, 42, 100, 24};
        int count = 0;
        System.out.println(Arrays.toString(arr));

        while (count < 5) {
            System.out.print("입력 : ");
            int myNum = scanner.nextInt();
            int maxNum = 0;
            int index = 0;
            for (int i = 0; i < arr.length; i++) {
                if (maxNum < arr[i]) {
                    maxNum = arr[i];
                    index = i;
                }
            }
            if (myNum == maxNum) {
                arr[index] = 0;
                count++;
            }
        }
        System.out.println("게임 종료");
    }
}

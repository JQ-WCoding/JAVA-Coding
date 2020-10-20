package Day026P;

import java.util.Arrays;
import java.util.Scanner;

public class Day02602배열응용P {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 1. 숫자 5개를 입력받는다.
        // 2. 입력한 값이 arr배열 안에 존재하는 값이면
        //    temp 배열 안에 해당 값의 인덱스를 차례대로 저장한다.
        // 3. 단, 입력한 숫자가 arr 배열에 없으면 인덱스 대신 -1을 저장한다.

        // 예) 입력 : 10, 20, 10, 1, 50
        //     temp = {0, 1, 0, -1, 4}

        // 예) 입력 : 30, 40, 1, 10, 2
        //     temp = {2, 3, -1, 0, -1}

        int[] arr = {10, 20, 30, 40, 50};
        int[] temp = new int[5];
        System.out.println(Arrays.toString(arr)); // arr배열 한번 표현
        for (int i = 0; i < temp.length; i++) { // 5번의 기회
            // int check = -1;

            temp[i] = -1;
            System.out.println((i + 1) + "번째 값을 입력하세요 : ");
            int myNumber = scanner.nextInt(); // 입력받기
            for (int j = 0; j < arr.length; j++) {
                if (myNumber == arr[j]) {
                    temp[i] = j;
                }
            }
        }
        System.out.println(Arrays.toString(temp));
    }
}

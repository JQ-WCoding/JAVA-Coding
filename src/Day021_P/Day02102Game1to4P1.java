package Day021_P;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Day02102Game1to4P1 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        /*
         * #  1 to 4
         * 1. arr배열에 1~4 사이의 숫자를 중복없이 저장한다.
         * 2. 사용자는 1부터 순서대로 해당 위치 값을 입력한다.
         * 3. 정답을 맞추면 해당 값은 9로 변경되어 모든 값이 9가 되면 게임은 종료된다.
         * 예)
         * 4 2 3 1
         * 입력 : 3
         * 4 2 3 9
         * 입력 : 1
         * 4 9 3 9
         * ...
         */
        int[] arr = new int[4];
        int[] check = new int[4];
        //1.
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(4) + 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    i--;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        int answer = 1;
        while (true) {
            System.out.println(Arrays.toString(check));
            System.out.println("위치를 입력하세요");
            int choice = scanner.nextInt() - 1;

            if (arr[choice] == answer) {
                check[choice] = answer;
                answer++;
            }
            int mainCheck = -1;
            for (int i = 0; i < check.length; i++) {
                if (check[i] == 0) {
                    mainCheck = 1;
                }
            }
            if (mainCheck == -1) {
                System.out.println("Success");
                break;
            }
        }
    }
}

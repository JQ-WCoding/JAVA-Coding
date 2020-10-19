package ExplainCode;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Study1to4 {
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
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(4) + 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    i--;
                }
            }
        }
        int gameNum = 1; // 4가 넘어가면 게임을 강제로 종료
        while (true) {
            System.out.println(Arrays.toString(arr));
            System.out.println(Arrays.toString(check));
            System.out.println(gameNum + "인덱스를 입력하세요 : ");
            int index = scanner.nextInt(); // 인덱스 값을 받을겁니다
            if (arr[index] == gameNum) {
                check[index] = 9;
                gameNum += 1;
            }
            if (gameNum == 5) {
                System.out.println("게임 성공");
                break; // 반복문을 탈출
            }
        }
    }
}

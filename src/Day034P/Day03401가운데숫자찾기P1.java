package Day034P;

import java.util.Scanner;

public class Day03401가운데숫자찾기P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 12345 / 1				count = 1
        // 12345 / 10				count = 2
        // 12345 / 100				count = 3
        // 12345 / 1000				count = 4
        // 12345 / 10000			count = 5

        System.out.println("숫자를 입력하세요 : ");
        int myNumber = scanner.nextInt();

        int num = 1, count = 0;
        while (myNumber / num != 0) {
            num *= 10;
            count++;
        }
        System.out.println(count);
        // 기준점

        // 배열마다 각 자리 수를 대입하는 형식
        int[] arr = new int[count];
        int div = 1;
        // 총 몇자리 숫자지 파악 후 올라가기
        for (int i = 0; i < count - 1; i++) {
            div *= 10;
        }
        System.out.println("div = " + div);

        for (int i = 0; i < count; i++) {
            arr[i] = myNumber / div; // 몫
            myNumber %= div; // 나머지
            div /= 10; // 나누는 수를 한자리씩 줄여나간다
        }

        System.out.print("arr = [ ");
        for (int i = 0; i < count; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ]");

        if (count % 2 == 0) System.out.println("짝수의 자리이다");
        /*
        가장 key point 중간 자리를 확인할 수 있도록 한 방법
         */
        else System.out.println("정답 = " + arr[count / 2]);
    }
}

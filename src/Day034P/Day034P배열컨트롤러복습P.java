package Day034P;

import java.util.Arrays;
import java.util.Scanner;

public class Day034P배열컨트롤러복습P {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {10, 20, 0, 0, 0};
        int count = 2;

        while (true) {
            for (int i = 0; i < count; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

            System.out.println("[1]추가하기");
            System.out.println("[2](값으로)삭제하기");
            System.out.println("[3](인덱스로)추가하기");
            int choice = scanner.nextInt();
            if (choice == 1) {

            } else if (choice == 2) {
            } else if (choice == 3) {
                if (count == 5) {
                    System.out.println("더 입력할 수 없습니다");
                    continue;
                }
                System.out.println("인덱스 번호를 입력하세요 : ");
                int myIndex = scanner.nextInt();
                System.out.println("값을 입력하세요 : ");
                int myNum = scanner.nextInt();

                for (int i = arr.length - 1; i > myIndex; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[myIndex] = myNum;
                count++;
                System.out.println(Arrays.toString(arr));
            }
        }
    }
}

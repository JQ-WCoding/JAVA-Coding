package Test;

import java.util.Arrays;
import java.util.Scanner;

public class _13이준규 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = {10, 20, 40, 30, 50};
        int count = 5;

        while (true) {
            System.out.println("[1]값으로 삭제하기");
            System.out.println("[2]인덱스로 삽입하기");
            System.out.println("[3]오름차순으로 정렬하기");

            int choice = scanner.nextInt();

            if (choice == 1) { // 값으로 삭제하기
                System.out.println("[삭제]값을 입력하세요 : ");
                int myNum = scanner.nextInt();
                int checkIndex = -1;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == myNum) {
                        checkIndex = i;
                    }
                }
                if (checkIndex == -1) {
                    System.out.println("값이 존재하지 않습니다");
                    continue;
                }
                int[] temp = arr;
                arr = new int[count - 1];
                int arrCount = 0;
                for (int i = 0; i < temp.length; i++) {
                    if (i != checkIndex) {
                        arr[arrCount] = temp[i];
                        arrCount++;
                    }
                }
                count--;
                System.out.println(Arrays.toString(arr));
            } else if (choice == 2) { // 인덱스로 삽입하기
                /*
                인덱스를 제외한 부분은 미리 추가해두기
                 */
                System.out.println("인덱스를 입력하세요 :");
                int myIndex = scanner.nextInt();

                if (myIndex < 0 || myIndex > count) {
                    System.out.println("초과한 인덱스입니다");
                    continue;
                }
                System.out.println("값을 입력하세요 : ");
                int myNum = scanner.nextInt();

                int[] temp = arr; // 3
                arr = new int[count + 1]; // 4
                int arrCount = count;
                for (int i = count; i >= 0; i--) {
                    if (i != myIndex) {
                        arr[arrCount + 1] = temp[i];
                    }
                }
                arr[myIndex] = myNum;
                count++;

                System.out.println(Arrays.toString(arr));

            } else if (choice == 3) { // 오름차순으로 정렬 -> 10,20,30,40,50
                int minNum = 100;
                int[] temp = arr;
                int indexCount = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (minNum > arr[i]) {
                        minNum = arr[i];
                        temp[indexCount] = minNum;
                        arr[i] = 0;
                        indexCount++;
                    }
                }
                System.out.println(Arrays.toString(temp));
            }
        }
    }
}

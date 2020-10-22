package Day027P;

import com.sun.source.tree.WhileLoopTree;

import java.util.Arrays;
import java.util.Scanner;

public class Day02702Test2 {
    public static void main(String[] args) { //  call stack 1st floor
        Scanner scanner = new Scanner(System.in);
        int arr[] = {0, 2, 0, 3, 4, 0, 0, 5, 0}; // 9자리
        // 아래 번호를 입력받고 각방향 으로 0 이아닌숫자를 모으시요.
        // 1)left 2)right

        // 예) 1) left ==> arr = {2,3,4,5,0,0,0,0,0};
        // 예) 1) right ==> arr = {0,0,0,0,0,2,3,4,5};

        while (true) {
            System.out.println(Arrays.toString(arr));
            System.out.println("1) left 2) Right 로 숫자 모으기  // 0은 프로그램 종료");
            int myChoice = scanner.nextInt();

            if (myChoice == 1) {
                int leftTemp = 0;
                int[] temp = new int[arr.length];
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] != 0) {
                        temp[leftTemp] = arr[i];
//                        arr[i] = 0; 이걸 생각못했어ㅜㅜ
                        leftTemp++;
                    }
                }
                System.out.println(Arrays.toString(temp));
            } else if (myChoice == 2) {
                int count = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] != 0) {
                        count++; // 4개
                    }
                }
                int rightTemp = arr.length - count; // 9 - 4 = 5
                int[] temp = new int[arr.length];
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] != 0) {
                        temp[rightTemp] = arr[i];
                        rightTemp++;
                    }
                }
                System.out.println(Arrays.toString(temp));
            } else if (myChoice == 0) {
                break;
            }
        }
    }
}

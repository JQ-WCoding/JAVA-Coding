package Day020_P;

import java.util.Arrays;
import java.util.Scanner;

public class Day02004값교체하기_P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {10, 20, 30, 40, 50};
        // 문제 1) 인덱스 2개를 입력받아 값 교체하기
        // 예    1)
        // 인덱스 1 입력 : 1
        // 인덱스 2 입력 : 3
        // arr = {10, 40, 30, 20, 50}
        int temp = 0;
        System.out.println("값 1을 입력하세요 :");
        int myFirstNum = scanner.nextInt();
        System.out.println("값 2를 입력하세요 : ");
        int mySecondNum = scanner.nextInt();
        temp = arr[mySecondNum];
        arr[mySecondNum] = arr[myFirstNum];
        arr[myFirstNum] = temp;
        System.out.println(Arrays.toString(arr)); // 한줄 출력 방법
        // 문제 2) 값 2개를 입력받아 값 교체하기
        // 예    2)
        // 값 입력 : 20, 값 입력 : 40
        int value1 = 20;
        int value2 = 40;
        int[] arrNew = {10, 20, 30, 40, 50};
        System.out.println("값 1을 입력");
        myFirstNum = value1; // 1 번째 숫자
        System.out.println("값 2를 입력");
        mySecondNum = value2; // 2번쨰숫자
        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < arrNew.length; i++) {
            if (arrNew[i] == myFirstNum) {
                idx1 = i;
            }
            if (arrNew[i] == mySecondNum) {
                idx2 = i;
            }
        }
        temp = arrNew[idx1];
        arrNew[idx1] = arrNew[idx2];
        arrNew[idx2] = temp;
        System.out.println(Arrays.toString(arrNew));

        // 문제 3) 학번 2개를 입력받아 성적 교체하기
        int[] hakbuns = {1001, 1002, 1003, 1004, 1005};
        int[] scores = {32, 28, 100, 98, 12};
        System.out.println("1번 학번을 입력하세요");
        int firstHakbun = scanner.nextInt();
        System.out.println("2번 학번을 입력하세요");
        int secondHakbun = scanner.nextInt();
        idx1 = 0;
        idx2 = 0;
        for (int i = 0; i < hakbuns.length; i++) {
            if (hakbuns[i] == firstHakbun){
                idx1 = i;
            }
            if (hakbuns[i] == secondHakbun){
                idx2 = i;
            }
        }
        temp = scores[idx1];
        scores[idx1] = scores[idx2];
        scores[idx2] = temp;
        System.out.println(Arrays.toString(scores));

        scanner.close();
    }
}

package Day020_P;

import java.util.Scanner;

public class Day02004값교체하게_P {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {10, 20, 30, 40, 50};
        int idx1 = 1;
        int idx2 = 3;
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
        // 문제2) 값 2개를 입력받아 값 교체하기
        // 예 2) 값 입력 : 20, 갑 입력 : 40
        System.out.println("값1을 입력하세요 : ");
        int num1 = sc.nextInt();
        System.out.println("2를 입력하세요 : ");
        int num2 = sc.nextInt();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num1) {
                idx1 = i;
            } else if (arr[i] == num2) {
                idx2 = i;
            }

        }
        temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
        //Q3
        int[] hakbuns = {1001, 1002, 1003, 1004, 1005};
        int[] scores = {32, 28, 100, 98, 12};

        System.out.println("학번을 입력하세요 : ");
        int hakbun1 = sc.nextInt();
        System.out.println("변결할 학번을 입력하세요 : ");
        int hakbun2 = sc.nextInt();

        for (int i = 0; i < hakbuns.length; i++) {
            if (hakbun1 == hakbuns[i]) {
                idx1 = i;
            } else if (hakbun2 == hakbuns[i]) {
                idx2 = i;
            }
        }
        temp = scores[idx1];
        scores[idx1] = scores[idx2];
        scores[idx2] = temp;

        for(int j : scores){
            System.out.print(j + " ");
        }
        sc.close();
    }
}

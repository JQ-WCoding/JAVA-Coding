package Day021_P;

import java.util.Random;
import java.util.Scanner;

public class Day02102_1to4게임_P {
    public static void main(String[] args) {
        Random rn = new Random();
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[4];
        int[] check = new int[4];

        // 중복없이 값 입력
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rn.nextInt(4) + 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    i--;
                }
            }
        }
        // 임시출력
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
        // check에 순번으로 변환
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 1:
                    check[0] = i + 1;
                case 2:
                    check[1] = i + 1;
                case 3:
                    check[2] = i + 1;
                case 4:
                    check[3] = i + 1;
            }
        }
        System.out.println();
        for (int j : check) {
            System.out.print(j + " ");
        }
        System.out.println();
        boolean run = true;

        while (run) {
            System.out.println("순서대로 자리위치를 입력하세요 : ");
            int myPick = sc.nextInt();
            // 정오 확인
            for (int i = 0; i < check.length; i++) {
                if (arr[check[myPick-1]] == i + 1) {
                    check[i] = 9;
                }
            }

            for (int j : check) {
                System.out.print(j + " ");
            }
            int count = 0;
            for (int i = 0; i < check.length; i++) {
                if (check[i] == 9) {
                    count++;
                }
            }
            System.out.println();

            if (count == 4) {
                run = false;
            }

        }
        System.out.println("게임종료");
        sc.close();
    }
}

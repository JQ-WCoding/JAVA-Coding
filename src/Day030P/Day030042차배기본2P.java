package Day030P;

import java.util.Scanner;

public class Day030042차배기본2P {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[3][3];

        int k = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = 10 * k;
                k += 1;
            }
        }

        // 문제 1) 인덱스 2개를 입력받아 값 출력
        // 예    1) 인덱스1 입력 : 1	인덱스2 입력 : 2
        //		   값 출력 : 60
        System.out.println("인덱스1을 입력하세요");
        int index1 = scanner.nextInt();
        System.out.println("인덱스2를 입력하세요");
        int index2 = scanner.nextInt();
        System.out.println(arr[index1][index2]);

        // 문제 2) 값을 입력받아 인덱스 2개 출력
        // 예    2) 값 입력 : 60
        //		   인덱스1 출력 : 1	인덱스2 출력 : 2
        System.out.println("값을 입력하세요 : ");
        int myNum = scanner.nextInt();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == myNum) {
                    System.out.printf("인덱스 1 : %d / 인덱스 2 : %d", i, j);
                }
            }
        }
        System.out.println();
        // 문제 3) 가장 큰 값의 인덱스 2개 출력
        // 정답 3) 2 2
        int maxNum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (maxNum < arr[i][j]) {
                    maxNum = arr[i][j];
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (maxNum == arr[i][j]) {
                    System.out.printf("최대값의 인덱스 1 : %d / 인덱스 2 : %d", i, j);
                }
            }
        }
        System.out.println();
        // 문제 4) 값 2개를 입력받아 값 교체
        System.out.println("값1을 입력하세요 : ");
        int myNum1 = scanner.nextInt();
        System.out.println("값2를 입력하세요 : ");
        int myNum2 = scanner.nextInt();

        int temp1Index = 0;
        int temp2Index = 0;

         for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (myNum1 == arr[i][j]) {
                    temp1Index = i;
                    temp2Index = j;
                }
                if (myNum2 == arr[i][j]){
                    arr[i][j] = myNum1;
                }
            }
        }
         // teacher's solution
//        int value1 = 10;
//        int value2 = 90;
//
//        int value1Idx1 = 0;
//        int value1Idx2 = 0;
//        int value2Idx1 = 0;
//        int value2Idx2 = 0;
//        for(int i=0; i<3; i++) {
//            for(int j=0; j<3; j++) {
//                if(arr[i][j] == value1) {
//                    value1Idx1 = i;
//                    value1Idx2 = j;
//                }
//                if(arr[i][j] == value2) {
//                    value2Idx1 = i;
//                    value2Idx2 = j;
//                }
//            }
//        }
//
//        int temp = arr[value1Idx1][value1Idx2];
//        arr[value1Idx1][value1Idx2] = arr[value2Idx1][value2Idx2];
//        arr[value2Idx1][value2Idx2] = temp;
//         arr[temp1Index][temp2Index] = myNum2;
//
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
        System.out.println();

        scanner.close();
    }
}

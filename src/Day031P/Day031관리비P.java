package Day031P;

import java.util.Arrays;
import java.util.Scanner;

public class Day031관리비P {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] apt = {
                {101, 102, 103},
                {201, 202, 203},
                {301, 302, 303}
        };

        int[][] pay = {
                {1000, 2100, 1300},
                {4100, 2000, 1000},
                {3000, 1600, 800}
        };

        int[] floorPay = new int[3];
        // 문제 1) 각층별 관리비 합 출력
        // 정답 1) 4400, 7100, 5400
        for (int i = 0; i < apt.length; i++) {
            for (int j = 0; j < apt[i].length; j++) {
                floorPay[i] += pay[i][j];
            }
        }
        System.out.println(Arrays.toString(floorPay));
        // 문제 2) 호를 입력하면 관리비 출력
        // 예    2) 입력 : 202	관리비 출력 : 2000
        System.out.println("호수를 입력하세요");
        int myHouse = scanner.nextInt();
        for (int i = 0; i < apt.length; i++) {
            for (int j = 0; j < apt[i].length; j++) {
                if (myHouse == apt[i][j]) {
                    System.out.println(pay[i][j] + "원");
                }
            }
        }
        // 문제 3) 관리비가 가장 많이 나온 집, 적게 나온 집 출력
        // 정답 3) 가장 많이 나온 집(201), 가장 적게 나온 집(303)
        int maxPay = 0;
        int minPay = pay[0][0];

        for (int i = 0; i < apt.length; i++) {
            for (int j = 0; j < apt[i].length; j++) {
                if (maxPay < pay[i][j]) {
                    maxPay = pay[i][j];
                }
                if (minPay > pay[i][j]) {
                    minPay = pay[i][j];
                }
            }
        }
        for (int i = 0; i < apt.length; i++) {
            for (int j = 0; j < apt[i].length; j++) {
                if (maxPay == pay[i][j]) {
                    System.out.println("가장 많이 나온 집 : " + apt[i][j]);
                }
                if (minPay == pay[i][j]) {
                    System.out.println("가장 적게 나온 집 : " + apt[i][j]);
                }
            }
        }
        // 문제 4) 호 2개를 입력하면 관리비 교체
        System.out.println("호1 을 입력하세요 : ");
        int firstHouse = scanner.nextInt();
        System.out.println("호2 를 입력하세요 : ");
        int secondHoues = scanner.nextInt();

        int index1 = 0, index2 = 0, index3 = 0, index4 = 0;
        for (int i = 0; i < apt.length; i++) {
            for (int j = 0; j < apt[i].length; j++) {
                if (firstHouse == apt[i][j]) {
                    index1 = i;
                    index2 = j;
                }
                if (secondHoues == apt[i][j]) {
                    index3 = i;
                    index4 = j;
                }
            }
        }
        int temp = pay[index1][index2];
        pay[index1][index2] = pay[index3][index4];
        pay[index3][index4] = temp;

        for (int i = 0; i < apt.length; i++) {
            for (int j = 0; j < apt[i].length; j++) {
                System.out.print(pay[i][j] + " ");
            }
            System.out.println();
        }
    }
}

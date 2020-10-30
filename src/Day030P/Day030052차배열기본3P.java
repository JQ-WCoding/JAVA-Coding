package Day030P;

import java.util.Arrays;

public class Day030052차배열기본3P {
    public static void main(String[] args) {
        int[][] arr = {
                {101, 102, 103, 104},
                {201, 202, 203, 204},
                {301, 302, 303, 304}
        };

        int[] garo = new int[3];
        int[] sero = new int[4];

        // 문제 1) 가로 합 출력
        // 정답 1) 410, 810, 1210
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                garo[i] += arr[i][j];
            }
        }
        System.out.println(Arrays.toString(garo));
        // 문제 2) 세로 합 출력
        // 정답 2) 603, 606, 609, 612
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                sero[i] += arr[j][i];
            }
        }
        System.out.println(Arrays.toString(sero));
    }
}

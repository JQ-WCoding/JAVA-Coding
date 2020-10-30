package Day033P;

import java.util.Arrays;

public class Day03302중복안된숫자제거 {
    int[] test1 = {1, 2, 3, 2, 1};
    int[] test2 = {1, 3, 4, 4, 2};
    int[] test3 = {1, 1, 1, 2, 1};
    int sizeofTest = test1.length;

    // 중복안된 숫자를 찾기
    // 그자리 인덱스 찾기
    // 배열 재설정
    // 다시 추가 후 표현
    public void test1CheckArray() {
        int index = -1;
        for (int i = 0; i < sizeofTest; i++) {
            int count = 0;
            for (int j = 0; j < sizeofTest; j++) {
                if (test1[i] == test1[j]) {
                    count++;
                }
            }
            if (count < 2) {
                index = i;
            }
        }
        System.out.println(index); // cheat key
        int[] temp = test1;
        test1 = new int[4];
        int indexCount = 0;
        for (int i = 0; i < sizeofTest; i++) {
            if (i != index) {
                test1[indexCount] = temp[i];
                indexCount++;
            }
        }
    }

    public void test2CheckArray() {
        int index = -1;
        for (int i = 0; i < sizeofTest; i++) {
            int count = 0;
            for (int j = 0; j < sizeofTest; j++) {
                if (test2[i] == test2[j]) {
                    count++;
                }
            }
            if (count < 2) {
                index = i;
            }
        }
        System.out.println(index);
        int[] temp = test2;
        test2 = new int[4];
        int indexCount = 0;
        for (int i = 0; i < sizeofTest; i++) {
            if (i != index) {
                test2[indexCount] = temp[i];
                indexCount++;
            }
        }
    }

    public void test3CheckArray() {
        int index = -1;
        for (int i = 0; i < sizeofTest; i++) {
            int count = 0;
            for (int j = 0; j < sizeofTest; j++) {
                if (test3[i] == test3[j]) {
                    count++;
                }
            }
            if (count < 2) {
                index = i;
            }
        }
        System.out.println(index);
        int[] temp = test3;
        test3 = new int[4];
        int indexCount = 0;
        for (int i = 0; i < sizeofTest; i++) {
            if (i != index) {
                test3[indexCount] = temp[i];
                indexCount++;
            }
        }
    }

    public void showArray() {
        System.out.println(Arrays.toString(test1));
        System.out.println(Arrays.toString(test2));
        System.out.println(Arrays.toString(test3));
    }

    public static void main(String[] args) {
        Day03302중복안된숫자제거 day03302 = new Day03302중복안된숫자제거();
        // 위 배열에서 중복안된숫자를 제거하시요
        // 1) {1,2,1,2}
        // 2) {4,4}
        // 3) {1,1,1,1}
        day03302.test1CheckArray();
        day03302.test2CheckArray();
        day03302.test3CheckArray();
        day03302.showArray();
    }
}

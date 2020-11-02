package Day033P;

import java.util.Arrays;

/**
 *
 * @author jun_q
 */
public class Day03302중복안된숫자제거 {
    public int[] test1 = {1, 2, 3, 2, 1};
    public int[] test2 = {1, 3, 4, 4, 2};
    public int[] test3 = {1, 1, 1, 2, 1};
    public int sizeofTest = test1.length; // test array's length

    // 중복안된 숫자를 찾기
    // 그자리 인덱스 찾기
    // 배열 재설정
    // 다시 추가 후 표현
    public void testCheckArray(int[] test) {
        int index = -1;
        for (int i = 0; i < sizeofTest; i++) {
            int count = 0;
            for (int j = 0; j < sizeofTest; j++) {
                if (test[i] == test[j]) {
                    count++;
                }
            }
            if (count < 2) { // if test[i] doesn't have same value
                index = i;
            }
        }
        System.out.println(index); // cheat key
        // vector
        int[] temp = test;
        test = new int[4];
        int indexCount = 0;
        for (int i = 0; i < sizeofTest; i++) {
            if (i != index) {
                test[indexCount] = temp[i];
                indexCount++;
            }
        }
        System.out.println(Arrays.toString(test));
    }

    public static void main(String[] args) {
        Day03302중복안된숫자제거 day03302 = new Day03302중복안된숫자제거();
        // 위 배열에서 중복안된숫자를 제거하시요
        // 1) {1,2,1,2}
        // 2) {4,4}
        // 3) {1,1,1,1}
        day03302.testCheckArray(day03302.test1);
        day03302.testCheckArray(day03302.test2);
        day03302.testCheckArray(day03302.test3);
    }
}

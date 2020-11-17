package Day045P;

import java.util.Arrays;

/**
 * int [] arr = {1,1,3,3,3,100,2,2,3,1,3};
 * 위 배열에서 똑같은 숫자의 개수가 가장 적은 숫자와 가장 많은 숫자 의  개수를  출력
 * 예) 개수가 가장적은숫자 ==> 100
 * 예) 개수가 가장많은숫자 ==> 3
 * 가장 많은 갯수 출력 : 3 ===> 5개
 * 가장 적은 갯수 출력 : 100 ===> 1개
 */
public class Day04501배열심화 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 3, 100, 2, 2, 3, 1, 3};
        int maxCountIndex = -1, minCountIndex = -1;
        int maxCount = 0, minCount = 100;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (maxCount < count) {
                maxCount = count;
                maxCountIndex = i;
            }
            if (minCount > count) {
                minCount = count;
                minCountIndex = i;
            }
        }
        System.out.println("개수가 가장 많은 숫자 : " + arr[maxCountIndex] + " / " + maxCount + "개");
        System.out.println("개수가 가장 적은 숫자 : " + arr[minCountIndex] + " / " + minCount + "개");
    }
}

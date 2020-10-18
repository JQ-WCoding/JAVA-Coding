package Day020_P;

import java.util.Arrays;

public class Day02006SavingMutipleP1 {
    public static void main(String[] args) {
        /*
         * # 4의 배수만 저장
         * - arr 배열에서 4의 배수만 골라 temp 배열에 저장
         * - 단! temp 의 길이를 4의 배수만큼만 설정한다.
         */

        int[] arr = {44, 11, 29, 24, 76};
        int[] temp = null;
        int tempCount = 0;
        // temp = {44, 24, 76}

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 4 == 0) {
                tempCount++;
            }
        }
        temp = new int[tempCount];
        tempCount =0;
        for (int i = 0;i<arr.length;i++){
            if (arr[i] % 4 == 0){
                temp[tempCount] = arr[i];
                tempCount++;
            }
        }

        System.out.println(Arrays.toString(temp));
    }
}

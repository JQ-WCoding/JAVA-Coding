package Day020_P;

import java.util.Random;

public class Day02003중복숫자금지_P1 {
    public static void main(String[] args) {
        Random random = new Random();
        /*
         * # 중복숫자 금지[1단계]
         * 1. 0 ~ 4사이의 숫자를 arr배열에 저장한다.
         * 2. 단, 중복되는 숫자는 없어야 한다.
         * 힌트) 랜덤 숫자를 check배열의 인덱스로 활용한다.
         */
        int[] check = new int[5];
        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(5);
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    i--;
                }
            }
        }
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
//        int shuffle = 0;
//        while (shuffle < 1000) { // 로또 번호 섞기
//            int r = random.nextInt(8);
//            int temp = arr[0];
//            arr[0] = arr[r];
//            arr[r] = temp;
//            shuffle++;
    } // 셔플 완료

}


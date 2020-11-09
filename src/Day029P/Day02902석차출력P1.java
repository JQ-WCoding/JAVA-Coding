package Day029P;

import java.util.Arrays;

/**
 * 석차 내림차순에 대하여 이름도 같게 출력하기
 */
public class Day02902석차출력P1 {
    public static void main(String[] args) {
        String[] name = {"홍길동", "김영", "자바킹", "민병철", "메가맨"};
        int[] score = {87, 42, 100, 11, 98};

        for (int i = 0; i < score.length; i++) {
            int maxNum = score[i];
            int index = i;
            for (int j = i; j < score.length; j++) {
                if (maxNum < score[j]) {
                    maxNum = score[j];
                    index = j;
                }
            }
            if (index != i) {
                int temp = score[i];
                score[i] = maxNum;
                score[index] = temp;

                String tempString = name[i];
                name[i] = name[index];
                name[index] = tempString;
            }
        }
        System.out.println(Arrays.toString(name));
        System.out.println(Arrays.toString(score));
    }
}

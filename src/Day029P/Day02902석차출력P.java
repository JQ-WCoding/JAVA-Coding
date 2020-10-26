package Day029P;

import ArrayAddress.ArrayMessage;

import java.util.Arrays;

public class Day02902석차출력P {
    public static void main(String[] args) {
        /*
         * # 석차 출력
         * . 성적 순으로 이름 출력
         */
        String[] name = {"홍길동", "김영", "자바킹", "민병철", "메가맨"};
        int[] score = {87, 42, 100, 11, 98};
        int[] scoreTemp = Arrays.copyOf(score, 5);
//        int index = 0;
//        for (int i = 0; i < score.length; i++) {
//            for (int j = index; j < score.length; j++) {
//                if (score[index] < score[j]) {
//                    int temp = score[index];
//                    String nameTemp = name[index];
//                    score[index] = score[j];
//                    name[index] = name[j];
//                    score[j] = temp;
//                    name[j] = nameTemp;
//                }
//            }
//            index++;
//        }
        int[] temp = new int[score.length]; // 임시배열
        int tempCount = 0;
        int tempIndex = 0;
        while (true) {
            int tempNumber = 0;
            for (int i = 0; i < score.length; i++) {
                if (tempNumber < score[i]) {
                    tempNumber = score[i];
                    tempIndex = i;
                }
            }
            score[tempIndex] = 0;
            temp[tempCount] = tempIndex;
            tempCount++;
            if (tempCount == 5) {
                break;
            }
        }
        System.out.println(Arrays.toString(temp));
        for (int i = 0; i < temp.length; i++) {
            System.out.print(scoreTemp[temp[i]] + " ");
        }
        System.out.println();
        for (int i = 0; i < temp.length; i++) {
            System.out.print(name[temp[i]] + " ");
        }
        System.out.println();
    }
}

package Day037P;

import java.util.Arrays;

public class Day03702문자열2차원2P {
    public static void main(String[] args) {
        // 문제) 이름과 성적을 하나의 문자열로 연결
        // 정답) "김철수/87,이만수/42,이영희/95"

        String[] name = {"김철수", "이만수", "이영희"};
        int[] score = {87, 42, 95};

        String str = "";

        for (int i = 0; i < name.length; i++) {
            name[i] += "/" + score[i];
        }
        System.out.println(Arrays.toString(name));
    }
}

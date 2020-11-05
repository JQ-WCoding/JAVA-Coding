package Day037P;

import java.util.Arrays;

public class Day03702문자열2차원1P {
    public static void main(String[] args) {
        // 문제) 이름은 name배열에, 성적은 score배열에 각각 저장 및 출력
        String str = "김철수/87,이만수/42,이영희/95";

        String[] name = new String[3];
        int[] score = new int[3];

        name = str.split(",");

        for (int i = 0; i < name.length; i++) {
            score[i] = Integer.parseInt(name[i].substring(4));
            name[i] = name[i].substring(0, 3);
        }
        System.out.println(Arrays.toString(name));
        System.out.println(Arrays.toString(score));
    }
}

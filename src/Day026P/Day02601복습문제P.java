package Day026P;

import java.util.Arrays;
import java.util.Random;

public class Day02601복습문제P {
    public static void main(String[] args) {
        // # 4의  배수만 저장
        //# 랜덤숫자
        /*
        1. 1 ~ 100사이의 숫자를 랜덤하게 scores배열에 저장
        2. 성적이 60점 이상이면, success 배열에 저장
        3. 성적이 60점 이상이면, fail 배열에 저장
         */
        int[] scores = new int[10];

        int[] success = null;
        int[] fail = null;

        int successCount = 0;
        // 랜덤 숫자 넣기 새로운 방법
        for (int i = 0; i < scores.length; i++) {
            scores[i] = (int) (Math.random() * 100); // 램덤 숫자를 집는 방식
            if (scores[i] >= 60) {
                successCount++; // 60점 이상인 값만 가져오기
            }
        }
        System.out.println(Arrays.toString(scores));
        /*
        성공 실패를 각자 분류해서 새로운 배열 생성
        실패 = 10 - 성공 // 10판이기 때문에
         */
        success = new int[successCount];
        int successIndex = 0;
        fail = new int[10 - successCount];
        int failIndex = 0;

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] >= 60) { // 60점 이상이면 success 배열에 입력
                success[successIndex] = scores[i];
                successIndex++;
            } else { // 60점 미만이면 fail 배열에 입력
                fail[failIndex] = scores[i];
                failIndex++;
            }
        }
        System.out.println(Arrays.toString(success));
        System.out.println(Arrays.toString(fail));
    }
}

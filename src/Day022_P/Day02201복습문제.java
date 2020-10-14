package Day022_P;

import java.util.Random;

/*
# 랜덤학생(반복문)
1. 5회 반복을 진행하면서, 1~ 100 사이의 랜덤 숫자(성적)를 저장한다.
2. 위의 숫자가 60점 이상이면 합격생이다.
3. 합격생 수 출력
4. 1등학생의 번호와 성적 출력
# 랜점학생(반복문+배열)
 */
// 05m 41s
public class Day02201복습문제 {
    public static void main(String[] args) {
        Random rn = new Random();

        int[] scores = new int[5];
        int[] hakbuns = {1001, 1002, 1003, 1004, 1005};
        int index = 0;
        for (int i = 0; i < scores.length; i++) {
            scores[i] = rn.nextInt(100) + 1;
        }
        for (int j : scores) {
            System.out.print(j + " ");
        }
        System.out.println();
        int maxNum = 0;
        int count = 0;
        int firstIndex = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] >= 60) {
                count++;
            }
            if (maxNum < scores[i]) {
                maxNum = scores[i];
                firstIndex = i;
            }
        }
        System.out.println("합격생 수 : " + count + "명");

        System.out.println("1등학생 : " + hakbuns[firstIndex] + " / 점수 : " + maxNum + "점");

    }
}

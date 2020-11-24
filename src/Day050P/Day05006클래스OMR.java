package Day050P;

import java.util.Arrays;
import java.util.Random;

/**
 * # OMR 카드 : 클래스 + 변수
 * 1. 배열 answer 는 시험문제의 정답지이다.
 * 2. 배열 hgd 에 1~5 사이의 랜덤 숫자 5개를 저장한다.
 * 3. answer 와 hgd 값을 비교해 정오표를 출력한다.
 * 4. 한 문제당 20점이다.
 * 예)
 * answer = {1, 3, 4, 2, 5}
 * hgd    = {1, 1, 4, 4, 3}
 * 정오표     = {O, X, O, X, X}
 * 성적        = 40점
 */
class Ex06 {
    int[] answer = {1, 3, 4, 2, 5};        // 시험답안
    int[] hgd = new int[5];                // 학생답안

    int cnt = 0;                        // 정답 맞춘 개수
    int score = 0;                        // 성적
}

public class Day05006클래스OMR {
    public static void main(String[] args) {
        Solution06 solution = new Solution06();
        solution.mainActor();
    }
}

class Solution06 {
    Ex06 ex06 = new Ex06();

    public void mainActor() {
        studentAnswer();
        showAnswerSheet();
        showHgdAnswer();
        correcting();
    }

    public void studentAnswer() {
        Random random = new Random();
        // 학생 답안 랜덤으로 입력해두기
        for (int i = 0; i < ex06.hgd.length; i++) {
            ex06.hgd[i] = random.nextInt(5) + 1;
        }
    }

    public void showHgdAnswer() {
        System.out.println(Arrays.toString(ex06.hgd));
    }

    public void showAnswerSheet() {
        System.out.println(Arrays.toString(ex06.answer));
    }

    public void correcting() {
        System.out.print("[ ");
        for (int i = 0; i < ex06.answer.length; i++) {
            if (ex06.answer[i] == ex06.hgd[i]) {
                System.out.print("O ");
                ex06.cnt++;
            } else {
                System.out.print("X ");
            }
        }
        System.out.println("] ");
        ex06.score = ex06.cnt * 20;
        System.out.println("성적 : " + ex06.score);
    }
}
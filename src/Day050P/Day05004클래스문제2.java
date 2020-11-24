package Day050P;

import java.util.Random;
import java.util.Scanner;

class Ex04 {
    int[] hakbuns = {1001, 1002, 1003, 1004, 1005};
    int[] scores = new int[5];
}

public class Day05004클래스문제2 {
    public static void main(String[] args) {
        Solution04 solution = new Solution04();
        solution.question1();
        solution.question2();
        solution.question3();
        solution.question4();
        solution.question5();

    }
}

class Solution04 {
    Scanner scanner = new Scanner(System.in);
    Ex04 ex04 = new Ex04();

    // 문제1) scores 배열에 1~100점 사이의 정수를 5개 저장
    // 예 1) 87, 11, 92, 14, 47
    public void question1() {
        Random random = new Random();
        for (int i = 0; i < ex04.scores.length; i++) {
            ex04.scores[i] = random.nextInt(100) + 1;
        }
    }

    // 문제2) 전교생의 총점과 평균 출력
    // 예 2) 총점(251) 평균(50.2)
    public void question2() {
        int total = 0;
        int student = ex04.scores.length;
        for (int i = 0; i < ex04.scores.length; i++) {
            total += ex04.scores[i];
        }
        double avg = (double) total / student;
        System.out.println("총합 : " + total);
        System.out.println("평균 : " + avg);
    }

    // 문제3) 성적이 60점 이상이면 합격. 합격생 수 출력
    // 예 3) 2명
    public void question3() {
        int count = 0;
        for (int i = 0; i < ex04.scores.length; i++) {
            if (ex04.scores[i] >= 60) {
                count++;
            }
        }
        System.out.println("합격자 수 : " + count + "명");
    }

    // 문제4) 인덱스를 입력받아 성적 출력
    // 정답4) 인덱스 입력 : 1 성적 : 11점
    public void question4() {
        System.out.print("인덱스 입력 : ");
        int number = scanner.nextInt();
        System.out.println("해당 성적 : " + ex04.scores[number]);
    }

    // 문제5) 성적을 입력받아 인덱스 출력
    // 정답5) 성적 입력 : 11 인덱스 : 1
    public void question5() {
        System.out.print("성적을 입력하세요 : ");
        int myScore = scanner.nextInt();
        for (int i = 0; i < ex04.scores.length; i++) {
            if (myScore == ex04.scores[i]) {
                System.out.println("해당 인덱스 : " + i);
            }
        }
    }

    // 문제6) 학번을 입력받아 성적 출력
    // 정답6) 학번 입력 : 1003 성적 : 45점
    public void question6() {
        System.out.print("학번을 입력하세요 : ");
        int myHakbun = scanner.nextInt();
        int index = -1;
        for (int i = 0; i < ex04.hakbuns.length; i++) {
            if (myHakbun == ex04.hakbuns[i]) {
                index = i;
            }
        }
        System.out.printf("%d의 점수는 : %d", myHakbun, ex04.scores[index]);
    }

    // 문제7) 학번을 입력받아 성적 출력
    // 단, 없는학번 입력 시 예외처리
    // 예 7)
    // 학번 입력 : 1002 성적 : 11점
    // 학번 입력 : 1000 해당학번은 존재하지 않습니다.
    public void question7() {
        System.out.print("학번을 입력 : ");
        int myHakbun = scanner.nextInt();
        int index = -1;
        for (int i = 0; i < ex04.hakbuns.length; i++) {
            if (myHakbun == ex04.hakbuns[i]) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println(myHakbun + " 해당 학번은 존재하지 않습니다");
        } else {
            System.out.printf("%d의 점수는 : %d", myHakbun, ex04.scores[index]);
        }
    }

    // 문제8) 1등학생의 학번과 성적 출력
    // 정답8) 1004번(98점)
    public void question8() {
        int max = 0;
        int maxIndex = -1;
        for (int i = 0; i < ex04.scores.length; i++) {
            if (max < ex04.scores[i]) {
                max = ex04.scores[i];
                maxIndex = i;
            }
        }
        System.out.printf("1등 학생의 학번 : %d , 성적 : %d점", ex04.hakbuns[maxIndex], max);
    }
}

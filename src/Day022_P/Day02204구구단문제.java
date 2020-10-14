package Day022_P;

import java.util.Random;
import java.util.Scanner;

public class Day02204구구단문제 {
    public static void main(String[] args) {
        Random rn = new Random();
        Scanner sc = new Scanner(System.in);

        int[] answer = new int[5];
        int[] answerSheet = new int[5];
        int x, y;
        int correctCount = 0;
        int wrongCount = 0;
        int[] correct = null;
        int[] wrong = null;
        int[] correctIndex = new int[5];
        int[] wrongIndex = new int[5];

        for (int i = 0; i < 5; i++) {
            x = rn.nextInt(9) + 1;
            y = rn.nextInt(9) + 1;
            int answerNumber = x * y;
            System.out.println((i + 1) + ")번 문제 : " + x + " * " + y + " = ? : ");
            int myAnswer = sc.nextInt();
            answer[i] = answerNumber;
            if (answer[i] == myAnswer) {
                answerSheet[i] = 1;
                correctIndex[correctCount] = i;
                correctCount++;
            } else {
                answerSheet[i] = -1;
                wrongIndex[wrongCount] = i;
                wrongCount++;
            }
        }
        correct = new int[correctCount];
        wrong = new int[wrongCount];
        // 정오표 확인
        for (int j : answer) {
            System.out.print(j + " ");
        }
        System.out.println();
        System.out.println("정답 번호 : ");
        for (int i = 0; i < correct.length; i++) {
            correct[i] = correctIndex[i];
            System.out.print((correct[i] + 1) + " ");
        }
        System.out.println();
        System.out.println("오답 번호 : ");
        for (int i = 0; i < wrong.length; i++) {
            wrong[i] = wrongIndex[i];
            System.out.print((wrong[i] + 1) + " ");
        }
        System.out.println();
        sc.close();
    }
}

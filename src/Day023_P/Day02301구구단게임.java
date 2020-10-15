package Day023_P;

import java.util.Random;
import java.util.Scanner;

public class Day02301구구단게임 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        int[] answer = new int[10]; // 정답지 배열
        int[] answerSheet = new int[10]; // 나의 정답에 대한 배열
        int x, y; // 임의 2개의 정수
        int correctCount = 0; // 정답을 맞춘 개수
        int wrongCount = 0; // 오답의 개수
        int[] correctIndex = new int[answer.length]; // 정답 배열의 순번
        int[] wrongIndex = new int[answer.length]; // 오답 배열의 순번
        int[] correct = null; // 정답 개수만큼 배열 생성
        int[] wrong = null; // 오답 개수만큼 배열 생성

        for (int i = 0; i < answer.length; i++) {
            // 랜덤으로 x, y 두 정수 받기
            x = random.nextInt(8) + 2;
            y = random.nextInt(9) + 1;
            int answerNum = x * y; // x와 y를 곱한 값 저장
            System.out.println((i + 1) + ")번 문제 : " + x + " * " + y + " = ?");
            int myAnswer = scan.nextInt(); // 나의 정답을 입력받기
            answer[i] = answerNum; // answer[] 배열에 각 1 ~ 10까지의 정답 입력 해두기
            if (answer[i] == myAnswer) { // 나의 답안이 정답일 경우
                answerSheet[i] = 1; // 정답이면 1 저장
                correctIndex[correctCount] = i;
                correctCount++;
            } else { // 나의 답안이 오답일 경우
                answerSheet[i] = -1; // 오답이면 -1 저장
                wrongIndex[wrongCount] = i;
                wrongCount++;
            }
            // 3문제 이상 틀린경우 강제종료
            if (wrongCount == 3) { // 오답이 3문제가 찍히는 경우 바로 break로 반복문 탈출
                System.out.println("탈락!");
                break;
            }
        }
        for (int i = 0; i < answer.length; i++) {
            System.out.print((i + 1) + "번 정답 : " + answer[i] + " ");
        } // 전체 문제에 대한 정답표 한번 출력
        System.out.println();
        correct = new int[correctCount]; // correct 배열 초기화
        wrong = new int[wrongCount]; // wrong 배열 초기화
        // 정답에 대한 출력
        for (int i = 0; i < correct.length; i++) {
            correct[i] = correctIndex[i]; // 정답 순번
            System.out.print("정답 : " + (correct[i] + 1) + " "); // 정답 순번 출력시 문제 번호로 출력을 위해 +1
        }
        System.out.println(); // 줄바꿈
        // 오답에 대한 출력
        for (int i = 0; i < wrong.length; i++) {
            wrong[i] = wrongIndex[i]; // 오답 순번
            System.out.print("오답 : " + (wrong[i] + 1) + " "); // 오답 순번 출력시 문제 번호로 출력을 위해 +1
        }
        System.out.println(); // 줄바꿈

        // 전체 문제에 대한 정오표 출력
        for (int i = 0; i < answer.length; i++) {
            if (answerSheet[i] == 1) { // 1 은 정답을 의미
                System.out.print((i + 1) + "번 : [O] "); // 정답에 대한 정오표 출력
            } else { // answer배열 값은 1과 -1만 존재하기에 1인경우 외에 else 사용
                if (answerSheet[i] == -1) { // -1은 오답을 의미
                    System.out.print((i + 1) + "번 : [X] "); // 오답에 대한 정오표 출력
                }
            }
        }
        System.out.println(); // 줄바꿈
        scan.close(); // 메모리 누수 방지
    }
}

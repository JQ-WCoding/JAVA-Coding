package Day025_P;

import java.util.Arrays;
import java.util.Scanner;

public class Day02501복습문제P {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // # 랜덤학생(반복문)
        // # 랜덤학생(배멸)
        int[] hakbuns = {1001, 1002, 1003, 1004, 1005};
        int[] scores = new int[5];
        /*
        성적 임의로 입력받기
         */
        for (int i = 0; i < scores.length; i++) {
            scores[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(scores));
        /*
        반복문 실행 (성적확인 프로그램 실행)
         */
        while (true) {
            System.out.println("[1]성적확인"); // 없는 학번 예외처리
            System.out.println("[2]1등확인"); // 1등 성적(학번)
            System.out.println("[3]꼴등확인"); // 꼴등성적(학번)
            System.out.println("[0]프로그램 종료");

            int choice = scanner.nextInt(); // 메뉴 선택받기

            if (choice == 1) {
                System.out.println("학번을 입력하세요 :");
                int choiceHakbun = scanner.nextInt(); // 학번 입력받기
                int tempHakbun = 0; //
                int check = -1;
                for (int i = 0; i < hakbuns.length; i++) {
                    if (choiceHakbun == hakbuns[i]) {
                        check = i;
                    }
                }
                if (check != -1) {
                    System.out.printf("%d의 성적은 : %d 점입니다.%n", hakbuns[tempHakbun], scores[check]); // 입력받은 학번과 점수
                }
                else {
                    System.out.println("학번이 없습니다");
                }
            } else if (choice == 2) { //1등성적
                int maxScore = 0;
                int maxScoreHakbun = 0;
                for (int i = 0; i < hakbuns.length; i++) {
                    if (scores[i] > maxScore) {
                        maxScore = scores[i]; // 사실 필요없음?
                        maxScoreHakbun = i;
                    }
                }
                System.out.printf("1등 학생 학번 : %d / 성적 : %d점 %n", hakbuns[maxScoreHakbun], maxScore);
            } else if (choice == 3) {
                int minScore = 100;
                int minScoreHakbun = 0;
                for (int i = 0; i < hakbuns.length; i++) {
                    if (minScore > scores[i]) {
                        minScore = scores[i];
                        minScoreHakbun = i;
                    }
                }
                System.out.printf("등 학생 학번 : %d / 성적 : %d점 %n", hakbuns[minScoreHakbun], minScore);
            } else if (choice == 0) {
                System.out.println("프로그램 종료");
                break; // 프로그램 종료
            }
        }
    }
}


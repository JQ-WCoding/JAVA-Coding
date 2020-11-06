package Day038P;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * # 타자연습 게임[1단계]
 * 1. 문제를 섞는다.(shuffle)
 * 2. 순서대로 문제를 출제하고, 문제를 다 맞추면 게임 종료
 * 예)
 * 문제 : mysql
 * 입력 : mdb
 * <p>
 * 문제 : mysql
 * 입력 : mysql		<--- 정답을 맞추면 다음 문제 제시
 * <p>
 * 문제 : jsp
 * ...
 */

public class Day03801타자연습게임P {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String[] words = {"java", "mysql", "jsp", "spring"};
        /*
        맞춘 갯수가 words.length 와 같으면 게임 종료
         */
        int correctCount = 0; // 정답 개수
        // 중복되지 않는 랜덤하게 변경하기
        // 문제 섞기
        for (int i = 0; i < 10; i++) {
            int r = random.nextInt(words.length);
            String temp = "";
            temp = words[0];
            words[0] = words[r];
            words[r] = temp;
        }
//        System.out.println(Arrays.toString(words)); // 랜덤 확인용 출력문
        // 게임 시작
        while (correctCount < words.length) {
            //문자 출력
            System.out.println((correctCount + 1) + "번 문제 : " + words[correctCount]);
            // 입력을 받은 후, 같은 문자일 경우에만 다음 문제로 넘어가기
            System.out.print("입력 : ");
            String myAnswer = scanner.next();
            /*
            정답인 경우 correctCount 증가
            오답인 경우 출력만 등장하고 재입력 받기
             */
            if (words[correctCount].equals(myAnswer)) {
                correctCount++;
            } else {
                System.out.println("다시 입력하세요");
            }
        }
        System.out.println("게임 완료");
        scanner.close();
    }
}

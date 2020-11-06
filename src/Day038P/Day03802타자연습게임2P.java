package Day038P;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * # 타자연습 게임[2단계]
 * 1. 문제를 섞는다.(shuffle)
 * 2. 순서대로 문제를 출제하고, 문제를 다 맞추면 게임 종료
 * 3. 단 문제를 출제할 때, 단어의 랜덤한 위치 한 곳만 *로 출력
 * 예)
 * 문제 : mys*l
 * 입력 : mysql	<--- 정답을 맞추면, 다음 문제 제시
 * 문제 : *sp
 * 입력 : jsp
 * ...
 */

public class Day03802타자연습게임2P {
    Random random = new Random();
    String[] words = {"java", "mysql", "jsp", "spring"};
    String[] starShow = new String[words.length];

    /*
    문제 섞기
     */
    public void shuffle() {
        for (int i = 0; i < 10; i++) {
            int r = random.nextInt(words.length);
            String temp = "";
            temp = words[0];
            words[0] = words[r];
            words[r] = temp;
        }
    }

    /*
    게임 시작
    정답은 온전한 글자여야하지만 출력문에서는 *가 랜덤하게 출력되어야한다.
     */
    public void inGame() {
        shuffle();
        Scanner scanner = new Scanner(System.in);
        int correctCount = 4;
        int temp = 0;
        for (int i = 0; i < correctCount; i++) {
            char[] tempChar;
            tempChar = words[i].toCharArray();
            // words[index] 내의 문자열 길이만큼 랜덤한 범위의 수를 저장받는다
            int randomIndex = random.nextInt(words[i].length());
            tempChar[randomIndex] = '*';
            starShow[i] = new String(tempChar);
            //문자 출력
            System.out.println((i + 1) + "번 문제 : " + starShow[i]);
            // 입력을 받은 후, 같은 문자일 경우에만 다음 문제로 넘어가기
            System.out.print("입력 : ");
            String myAnswer = scanner.next();
            /*
            정답인 경우 correctCount 증가
            오답인 경우 출력만 등장하고 재입력 받기
             */
            if (words[i].equals(myAnswer)) { // 출력문과 다르게 정답은 words에서 비교해야한다
                System.out.println("정답");
            } else {
                System.out.println("다시 입력하세요");
                i--;
            }
        }
        System.out.println("게임 완료");
        scanner.close();
    }

    public static void main(String[] args) {
        Day03802타자연습게임2P day03802 = new Day03802타자연습게임2P();
        day03802.inGame();
    }
}

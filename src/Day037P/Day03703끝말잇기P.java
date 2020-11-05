package Day037P;

import java.util.Scanner;

/**
 * # 끝말잇기 게임
 * (플레이 방식)
 * 제시어 : 자전거
 * 입력 : 거미
 * <p>
 * 제시어 : 거미
 * 입력 : 미술
 * ...
 */
public class Day03703끝말잇기P {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String start = "자전거";
        while (true) {
            System.out.println("제시어 : " + start);
            String myAnswer = scanner.next();
            if (myAnswer.charAt(0) == start.charAt(start.length() - 1)) {
                start = myAnswer;
            } else {
                System.out.println("게임 종료");
                break;
            }
        }
    }
}

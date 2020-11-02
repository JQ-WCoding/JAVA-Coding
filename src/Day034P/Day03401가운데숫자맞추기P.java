package Day034P;

import java.util.Scanner;

public class Day03401가운데숫자맞추기P {
    Scanner scanner = new Scanner(System.in);

    /**
     * # 가운데 숫자 찾기
     * 1. 1 ~ 백만 사이의 숫자를 입력받고 가운데 숫자 출력하기
     * 2. 단, 짝수자리의 수는 짝수라고 출력한다.
     * 예) 123 		정답:2
     * 예) 1234		정답:짝수의 자리이다
     * 예) 1			정답 : 1
     * 예) 1234567	정답 : 4
     */
    // 2, 4, 6자리 수와 같은 값은 짝수의 자리이다
    public int myNum() { // 값 입력받기
        System.out.println("원하는 숫자를 입력하세요 : (1 ~ 1,000,000)");
        int x = scanner.nextInt();
        if (x > 0 && x <= 1_000_000) { // 옳은 값을 입력했을 경우, 그 값을 반환
            return x;
        } else {
            return myNum(); // 다시 입력받기
        }
    }

    public void showAnswer(int x) {
        if (x > 0 && x < 10) {
            System.out.println("정답 :" + x);
        } else if (x >= 100 && x < 1_000) {
            System.out.println("정답 : " + (x % 100) / 10);
        } else if (x >= 10_000 && x < 100_000) {
            System.out.println("정답 : " + (x % 1000) / 100);
        }
        else {
            System.out.println("짝수의 자리이다.");
        }
    }

    public static void main(String[] args) {
        Day03401가운데숫자맞추기P day03401 = new Day03401가운데숫자맞추기P();
        day03401.showAnswer(day03401.myNum());
    }
}

package Day039P;

import java.util.Scanner;

/**
 * # 문자열 비교
 * . equals() 메서드 사용없이 문자의 일치여부 비교
 * 예)
 * 코끼리
 * 입력 = 티라노사우루스
 * 출력 = false
 */
public class Day03901문자열비교P {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String elephant = "코끼리";
        System.out.println(elephant);

        System.out.print("입력 = ");
        String myAnswer = scanner.next();

        System.out.println(elephant.compareTo(myAnswer) == 0);
    }
}

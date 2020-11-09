package Day039P;

import java.util.Arrays;
import java.util.Scanner;

/**
 * # 문자열 속 숫자검사
 * 예) adklajsiod
 * 문자만 있다.
 * <p>
 * 예) 123123
 * 숫자만 있다.
 * <p>
 * 예) dasd12312asd
 * 문자와 숫자가 섞여있다.
 */

public class Day03902문자열속숫자검사P {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("입력 : ");
        String text = scanner.next();
        // char 배열로 변경?

        if (text.matches("^[0-9]*$")){
            System.out.println("숫자만 존재");
        }
        else if (text.matches("^[가-힣]*$")){
            System.out.println("한글만 존재");
        }
        else if (text.matches("^[0-9가-힣]*$")){
            System.out.println("한글 & 숫자");
        }
        else {
            System.out.println("??");
        }
    }
}

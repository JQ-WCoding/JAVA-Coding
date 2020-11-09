package Day039P;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * # 단어 교체하기(replace)
 * 1. text변수 문장 속에서 변경하고 싶은 단어를 입력받아,
 * 2. 교체해주는 기능을 구현한다.
 * 예)
 * Life is too short.
 * 변경하고 싶은 단어입력 : Life
 * 바꿀 단어입력 : Time
 * <p>
 * Time is too short.
 */
public class Day03904단어교체하기P {
    Scanner scanner = new Scanner(System.in);
    String text = "Life is too short."; // 메인 문장

    /*
    변경하고 싶은 문자열 입력 받기
     */
    public String beforeChangeWords() {
        System.out.println(text);
        System.out.print("변경하고 싶은 단어를 입력하세요 : ");
        return scanner.next();
    }

    /*
    변경할 문자열 입력 받기
     */
    public String afterChangeWords() {
        System.out.print("바꿀 단어입력 : ");
        return scanner.next();
    }

    /*
    입력받은 문자열 변경하는 작업
     */
    public void changeWords() {
        text = text.replaceAll(beforeChangeWords(), afterChangeWords());
        System.out.println(text);
    }

    /*
    메인 실행문
     */
    public void mainWork() {
        changeWords();
    }

    public static void main(String[] args) {
        Day03904단어교체하기P day03904 = new Day03904단어교체하기P();
        day03904.mainWork();
    }
}

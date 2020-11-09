package Day039P;

import java.util.Scanner;

/**
 * # 단어 검색
 * 1. 단어를 입력받아 text변수 문장 속에 해당 단어가 있는지 검색한다.
 * 2. 단어가 존재하면 true
 * 단어가 없으면 false를 출력한다.
 * <p>
 * 예)
 * 입력 : too
 * 출력 : true
 * <p>
 * 입력 : too short
 * 출력 : true
 */
public class Day03903단어검색P {
    public String text = "Life is too short.";

    public String mainScreen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);

        System.out.print("검색할 단어를 입력하세요 : ");
        return scanner.next();
    }

    public boolean checkWords(String word) {
        String text1 = text.toLowerCase();
        String text2 = text.toUpperCase();
        if (text.contains(word)) {
            return true;
        } else if (text1.contains(word)) {
            return true;
        } else if (text2.contains(word)) {
            return true;
        } else {
            return false;
        }
    }

    public void showRight(){
        System.out.println(checkWords(mainScreen()));
    }

    public static void main(String[] args) {
        Day03903단어검색P day03903 = new Day03903단어검색P();
        day03903.showRight();
    }
}

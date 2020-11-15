package Day043P;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * # 영어단어맞추기 게임
 * 1. word변수에 저장된 영어단어를 맞추는 게임이다.					예) word = "performance"
 * 2. 처음에는 영어단어의 개수만큼 *로 출력되어 단어가 가려서 보인다.		예) ***********
 * 3. 영어단어를 입력받았을 때, 틀리면 랜덤으로 한글자가 벗겨지게 된다.
 * 단, 영어단어에 같은 철자가 여러개면 한번에 벗겨진다.				예) *e********e
 * 4. 계속 틀려서 단어가 전부 보이게 되거나 정답을 맞추게되면 게임은 종료된다.
 */
public class Day04301영단어맞추기게임 {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    String word = "performance";
    String meaning = "공연";

    public void startGame() {
        int noStarLeft = -1;
        int count = 0;

        char[] tempWord = new char[word.length()];
        Arrays.fill(tempWord, '*');

        while (true) {
            int check = noStarLeft;

            System.out.println("뜻 : " + meaning);
            // 문제 출제
            if (count > 0) {
                while (true) {
                    int randomNumber = random.nextInt(tempWord.length);
                    if (tempWord[randomNumber] == '*') {
                        tempWord[randomNumber] = word.charAt(randomNumber);
                        for (int i = 0; i < tempWord.length; i++) {
                            if (tempWord[randomNumber] == word.charAt(i)) {
                                tempWord[i] = word.charAt(i);
                            }
                        }
                        break;
                    }
                }
            }
                /*
            남은 * 확인 후 전체 노출시, 탈출
             */
            for (int i = 0; i < word.length(); i++) {
                if (tempWord[i] == '*') {
                    check = i;
                }
            }
            if (check == noStarLeft) {
                for (int i = 0; i < tempWord.length; i++) {
                    System.out.print(tempWord[i]);
                }
                System.out.println();
                System.out.println("게임 오버");
                break;
            }

            System.out.print("문제 : ");
            for (int i = 0; i < tempWord.length; i++) {
                System.out.print(tempWord[i]);
            }
            System.out.println();

            // 시도 문구
            System.out.println((count + 1) + "번째 시도 : [" + meaning + "]의 의미를 갖는 영어단어를 입력하세요 >>>");
            String myWord = scanner.next();

            if (myWord.equals(word)) {
                System.out.println("정답");
                break;
            }
            count++;
        }
    }

    public static void main(String[] args) {
        Day04301영단어맞추기게임 englishWordGame = new Day04301영단어맞추기게임();
        englishWordGame.startGame();
    }
}

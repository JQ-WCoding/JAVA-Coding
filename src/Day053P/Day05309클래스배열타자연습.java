package Day053P;

import java.util.Random;
import java.util.Scanner;

class Word {
    Random random = new Random();

    String word;
    int ranPosition;

    // 받은 단어 중 한 단어를 *로 표시하기 위한 메서드
    public void setRandomWordPosition(String sample) {
        word = sample;
        ranPosition = random.nextInt(word.length());
    }

    // 한 자리를 *로 바꾼 단어를 출력하는 메서드
    public void printWord() {
        for (int i = 0; i < word.length(); i++) {
            if (i == ranPosition) {
                System.out.print("*");
            } else {
                System.out.print(word.charAt(i));
            }
        }
        System.out.println();
    }
}

class WordSample {
    Random random = new Random();

    String[] wordSampleList = {"java", "jsp", "python", "android", "spring"};
    boolean[] checkList = new boolean[wordSampleList.length]; // 이미 선택한 단어 체크용
    int count = wordSampleList.length;

    public String getRandomWord() {
        int r = 0;
        while (true) {
            r = random.nextInt(wordSampleList.length);
            if (!checkList[r]) {
                checkList[r] = true;
                count--;
                break;
            }
        }
        return wordSampleList[r];
    }
}

public class Day05309클래스배열타자연습 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        WordSample wordSample = new WordSample();
        Word wordList = new Word();

        boolean run = true;

        long beforeTime = System.currentTimeMillis(); // 코드 실행 전에 시간 받아오기

        while (run) {
            // 단어 하나 보내기
            wordList.setRandomWordPosition(wordSample.getRandomWord());
            while (true) {
                wordList.printWord();
                System.out.print("단어를 입력하세요  : ");
                String inputWord = scanner.next();
                if (inputWord.equals(wordList.word)) {
                    System.out.println("정답입니다");
                    break;
                } else {
                    System.out.println("땡");
                }
            }
            if (wordSample.count == 0) {
                long afterTime = System.currentTimeMillis();
                double secDiffTime = (afterTime - beforeTime) / 1000.0;
                System.out.println("기록 : " + secDiffTime + "초");
                System.out.println("게임 종료");
                break;
            }
        }
    }
}

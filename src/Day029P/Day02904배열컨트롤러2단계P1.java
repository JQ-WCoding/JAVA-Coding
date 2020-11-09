package Day029P;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 배열 컨트롤러2단계
 */
public class Day02904배열컨트롤러2단계P1 {
    Scanner scanner = new Scanner(System.in);
    public int[] score = null;
    public int count = 0;

    /*
    메인 메뉴 선택 메소드
     */
    public int mainMenuChoice() {
        System.out.println("== [벡터 컨트롤러] ==");
        System.out.println(Arrays.toString(score));
        System.out.println("[1]추가");
        System.out.println("[2]삭제(인덱스)");
        System.out.println("[3]삭제(값)");
        System.out.println("[4]삽입");
        System.out.println("[0]종료");
        System.out.print("메뉴 선택 : ");
        return scanner.nextInt();
    }

    /*
    1번 메뉴 인덱스 값으로 바로 추가하기
     */
    public void nOneMenuChoice() { // number one menu choice
        System.out.print("추가 값 입력 : ");
        int insertNum = scanner.nextInt();

        if (count == 0) {
            score = new int[count + 1];
            score[count] = insertNum;
        } else {
            int[] temp = score;
            score = new int[count + 1];

            for (int i = 0; i < count; i++) {
                score[i] = temp[i];
            }
            score[count] = insertNum;
        }
        count++;
    }

    /*
    인덱스 값을 받아 배열 삭제하기
     */
    public void nTwoChoice() {
        while (true) {
            System.out.print("삭제 인덱스 입력 : ");
            int myIndex = scanner.nextInt(); // index value
            // 인덱스를 제외한 값을 입력했을 경우
            if (myIndex > count - 1 || myIndex < 0) {
                continue;
            }
            int[] temp = score;
            score = new int[count - 1];
            int indexCount = 0;
            for (int i = myIndex; i < count; i++) {
                if (i != myIndex) {
                    score[indexCount] = temp[i];
                    indexCount++;
                }
            }
            count--;
            break;
        }
    }

    /*
    프로그램 시작 메인 화면
     */
    public int menuSystem(int menuChoice) {
        if (menuChoice == 1) { // 1번 메뉴
            nOneMenuChoice();
            return 1;
        } else if (menuChoice == 2) { // 2번 메뉴
            nTwoChoice();
            return 2;
        } else if (menuChoice == 0) { // 0번 메뉴 (프로그램 종료)
            System.out.println("프로그램 종료");
            return 0;
        }
        else return -1;
    }

    public static void main(String[] args) {
        Day02904배열컨트롤러2단계P1 day02904 = new Day02904배열컨트롤러2단계P1();
    }
}

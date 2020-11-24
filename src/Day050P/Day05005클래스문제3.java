package Day050P;

import java.util.Arrays;
import java.util.Scanner;

class Ex05 {
    public String name = "";
    public int[] arHakbun = {1001, 1002, 1003, 1004, 1005};
    public int[] arScore = {92, 38, 87, 100, 11};
}

public class Day05005클래스문제3 {
    public static void main(String[] args) {
        Solution05 solution = new Solution05();
        solution.mainActor();
    }
}

class Solution05 {
    Ex05 ex05 = new Ex05();
    Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        ex05.name = "Green";
        System.out.println("=== " + ex05.name + "===");
        System.out.println("1.전교생 성적확인");
        System.out.println("2.1등학생 성적확인");
        System.out.println("3.꼴등학생 성적확인");
        System.out.println("4.성적확인하기");        // 학번 입력받아서 성적확인
        System.out.println("5.종료하기");
    }

    public void mainActor() {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            if (choice == 1) { // 전교생 성적확인
                checkWholeScore();
            } else if (choice == 2) { // 1등학생 성적확인
                firstScore();
            } else if (choice == 3) { // 꼴등학생 성적확인
                lastScore();
            } else if (choice == 4) { // 성적확인하기
                checkSingleScore();
            } else if (choice == 5) { // 종료하기
                break;
            }
        }
    }

    /*
    전교생 성적확인
     */
    public void checkWholeScore() {
        System.out.println(Arrays.toString(ex05.arScore));
    }

    /*
    1등학생 성적확인
     */
    public void firstScore() {
        int max = 0;
        for (int i = 0; i < ex05.arScore.length; i++) {
            if (max < ex05.arScore[i]) {
                max = ex05.arScore[i];
            }
        }
        System.out.println("1등 성적 : " + max + "점");
    }

    /*
    꼴등학생 성적확인
     */
    public void lastScore() {
        int min = 100;
        for (int i = 0; i < ex05.arScore.length; i++) {
            if (min > ex05.arScore[i]) {
                min = ex05.arScore[i];
            }
        }
        System.out.println("꼴들학생 성적 : " + min + "점");
    }

    /*
    성적확인
     */
    public void checkSingleScore() {
        System.out.print("학번을 입력하세요 : ");
        int myNumber = scanner.nextInt();
        int index = -1;
        for (int i = 0; i < ex05.arHakbun.length; i++) {
            if (myNumber == ex05.arHakbun[i]) {
                index = i;
            }
        }
        System.out.printf("%d의 성적은 %d점이다 %n", myNumber, ex05.arScore[index]);
    }
}
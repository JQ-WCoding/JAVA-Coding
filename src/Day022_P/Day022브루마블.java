package Day022_P;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Day022브루마블 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();

        int[] game = new int[10];
        for (int i = 0; i < game.length; i++) {
            game[i] = i;
        }
        int[] p1 = new int[10];
        Arrays.fill(p1, 0);

        int[] p2 = new int[10];
        Arrays.fill(p2, 0);
        // 게임 시작
        boolean run = true;
        p1[0] = 1;
        p2[0] = 2;
        int p1Now = 0;
        int p2Now = 0;

//        for (int j : p1) {
//            System.out.print("  " + j + " ");
//        }
//        System.out.println();
//        for (int j : p2) {
//            System.out.print("  " + j + " ");
//        }
//        System.out.println();
        boolean turn = true;
        while (run) {
            // 게임판
            for (int j : game) {
                System.out.print("[" + j + "] ");
            }
            System.out.println();
            boolean p1inGameRun = true;
            boolean p2inGameRun = true;
            // 턴 확인 및 게임 진행 내용
            if (turn == true) {
                int diceNumber = rn.nextInt(3) + 1;
                System.out.println("1을 눌러 주사위를 굴리세요");
                int diceRoll = sc.nextInt();
                if (diceRoll == 1) {
                    for (int i = 0; i < game.length; i++) {
                        //말 움직이기
                        if (p1[i] == 1) {
                            p1Now = i;
                            if (p1[0] == 1) {
                                p1[diceNumber] = 1;
                                p1[p1Now] = 0;
                            } else {
                                p1[p1Now + diceNumber - 1] = 1;
                                // 전위치 마크 삭제
                                p1[p1Now] = 0;
                            }
                        }
                    }
                    // 같은 자리에 있을 경우 원위치
                    if (p1[p1Now] == p2[p2Now]) {
                        p2[p2Now] = 0;
                        p2[0] = 2;
                    }
                    for (int j : p1) {
                        System.out.print("  " + j + " ");
                    }
                    System.out.println();
                    turn = false;
                }
            } else if (turn == false) {
                int diceNumber = rn.nextInt(3) + 1;
                System.out.println("2를 눌러 주사위를 굴리세요");
                int diceRoll = sc.nextInt();
                if (diceRoll == 2) {
                    for (int i = 0; i < game.length; i++) {
                        if (p2[i] == 2) {
                            p2Now = i;
                            if (p2[0] == 2) {
                                p2[diceNumber] = 2;
                            } else {
                                p2[p2Now + diceNumber] = 2;
                                p2[p2Now - diceNumber] = 0;
                            }
                        }
                    }
                    // 같은 자리에 있을 경우 원위치
                    if (p1[p1Now] == p2[p2Now]) {
                        p1[p1Now] = 0;
                        p1[0] = 1;
                    }
                    for (int j : p2) {
                        System.out.print("  " + j + " ");
                    }
                    System.out.println();
                    turn = false;
                }
            }
            // 승리 유무 체크
            if (p1[9] == 1) {
                System.out.println("1P 승리");
                run = false;
            } else if (p2[9] == 1) {
                System.out.println("2P 승리");
                run = false;
            }
        }
        sc.close();
    }
}

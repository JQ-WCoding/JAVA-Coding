package Day022_P;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Day02203브루마블renew {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();

        int[] game = new int[10];
        for (int i = 0; i < game.length; i++) {
            game[i] = i;
        }
        int[] p1 = new int[10];
        Arrays.fill(p1, 0);
        p1[0] = 1;
        int[] p2 = new int[10];
        Arrays.fill(p2, 0);
        p2[0] = 2;
        // 게임 시작
        int p1Lap = 0; // p1 바퀴수
        int p1Now = 0; // p1 현재 인덱스 위치
        int p2Lap = 0; // p2 바퀴수
        int p2Now = 0; // p2 현재 인덱스 위치
        boolean mainRun = true;
        // 현재는 2P / 나중에 입력받아 플레이어 원하는 만큼 설정 가능하게 하기
        int turn = 1;
        while (mainRun) {
            int diceNumber;
            for (int j : game) {
                System.out.print("[" + j + "] ");
            }
            System.out.println();
            // 1p
            if (turn % 2 == 1) {
                for (int j : p1) {
                    System.out.print("  " + j + " ");
                }
                System.out.println();
                System.out.println("1을 눌러 주사위를 돌려주세요");
                int diceCheck = sc.nextInt();
                if (diceCheck == 1) {
                    diceNumber = rn.nextInt(3) + 1;
                    System.out.println("주사위 눈 : " + diceNumber);
                    System.out.println("현재바퀴 수 : " + p1Lap);
                    p1[(p1Now + diceNumber) % 10] = 1;
                    p1[p1Now] = 0;
                    p1Now += diceNumber;
                } else {
                    continue;
                }
                // p1이 p2와 같은 위치일 경우 p2가 제자리로 돌아간다 (p1차례에 발생했기에)
                if (p1Now == p2Now) {
                    p2[p2Now] = 0;
                    p2[0] = 2;
                    p2Now = 0;
                }
                if (p1Now >= 10) {
                    p1Lap++;
                    p1Now = p1Now % 10;
                }
                turn = 2;
            }
            // 2p
            else if (turn % 2 == 0) {
                for (int j : p2) {
                    System.out.print("  " + j + " ");
                }
                System.out.println();
                System.out.println("2를 눌러 주사위를 돌려주세요");
                int diceCheck = sc.nextInt();
                if (diceCheck == 2) {
                    diceNumber = rn.nextInt(3) + 1;
                    System.out.println("주사위 눈 : " + diceNumber);
                    System.out.println("현재 바퀴 수 : " + p2Lap);
                    p2[(p2Now + diceNumber) % 10] = 2;
                    p2[p2Now] = 0;
                    p2Now += diceNumber;
                } else {
                    continue;
                }
                // p2가 p1 같은 위치일 경우 p1이 제자리로 돌아간다 (p2차례에 발생했기에)
                if (p1Now == p2Now) {
                    p1[p1Now] = 0;
                    p1[0] = 1;
                    p1Now = 0;
                }
                if (p2Now >= 10) {
                    p2Lap++;
                    p2Now = p2Now % 10;
                }
                turn = 1;
            }

            // 종료 조건
            if (p1Lap / 3 == 1) {
                System.out.println("1P 승리");
                mainRun = false;
            } else if (p2Lap / 3 == 1) {
                System.out.println("2P 승리");
                mainRun = false;
            }
        }
        System.out.println("[게임종료]");
    }
}

package Day049P;

import java.util.Scanner;

/**
 * 문제1)
 * . 0은 플레이어이다.
 * . 1)상 2)하 3)좌 4)우 5)되감기
 * 숫자를 입력받아 해당 위치로 이동할 수 있다.
 * (이동할 때 값을 서로 교환한다.)
 * 예 1)
 * . 입력 : 3
 * { 1,  2,  3,  4},
 * { 5,  6,  7,  8},
 * { 9, 10, 11, 12},
 * {13, 14,  0, 15}
 * <p>
 * 문제2) 심화
 * . 한칸 한칸 이동할 때마다 yx 배열에 이동한 경로를 저장했다가
 * . 5)되감기 기능인 5번 입력시 왔던 길로 되돌아가기를 한다.
 */

public class Ex00501숫자이동되감기 {
    public static void main(String[] args) {
        GameActor Game = new GameActor();
        Game.mainActor();
    }
}

class GameActor {
    int[][] game = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };

    int[][] yx = new int[10000][2];

    int playerY = -1, playerX = -1;

    int moveCount = 0;

    /*
    게임 보여주기
     */
    public void showGame() {
        for (int[] ints : game) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }

    /*
    이동키
     */
    public void keySet() {
        System.out.println("      ^(8)");
        System.out.println("<(4)  V(5)   >(6)");
        System.out.println("(1) 되감기");
        System.out.println("(0) 게임 종료");
    }

    /*
    위치 이동
     */
    public void movePLayer() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            findPlayer();
            showGame();
            keySet();
            int move = scanner.nextInt();

            int tempPlayerY = playerY, tempPlayerX = playerX;
            if (move == 8) { // 상단 이동
                tempPlayerY--;
            } else if (move == 4) { // 좌측 이동
                tempPlayerX--;
            } else if ((move == 5)) { // 하단 이동
                tempPlayerY++;
            } else if (move == 6) { // 우측 이동
                tempPlayerX++;
            } else if (move == 0) {
                System.out.println("게임 종료");
                break;
            } else if (move == 1) { // 되감기
                goBack();
                continue;
            }

            if (tempPlayerY < 0 || tempPlayerX < 0 || tempPlayerY > game.length - 1 || tempPlayerX > game.length - 1)
                continue;

            savePosition();

            // 값 옮기기
            int temp = game[tempPlayerY][tempPlayerX];
            game[tempPlayerY][tempPlayerX] = game[playerY][playerX];
            game[playerY][playerX] = temp;

            playerY = tempPlayerY;
            playerX = tempPlayerX;
        }
    }

    /*
    배열 이동 전 현재 위치 저장
     */
    public void savePosition() {
        yx[moveCount][0] = playerY;
        yx[moveCount][1] = playerX;
        moveCount++;
    }

    /*
    되감기
     */
    public void goBack() {
        if (moveCount == 0) {
            System.out.println("이동한적이 없습니다");
        } else {
            int temp = game[playerY][playerX];
            game[playerY][playerX] = game[yx[moveCount - 1][0]][yx[moveCount - 1][1]];
            game[yx[moveCount - 1][0]][yx[moveCount - 1][1]] = temp;
            moveCount--;
        }
    }

    /*
    메인 게임
     */
    public void mainActor() {
        movePLayer();
    }

    /*
    플레이어 위치 찾기
     */
    public void findPlayer() {
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                if (game[i][j] == 0) {
                    playerY = i;
                    playerX = j;
                }
            }
        }
    }

}

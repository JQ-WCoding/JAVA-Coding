package Day043P;

import java.util.Scanner;

/**
 * # 2차원 배열 : 나만의 마블
 * 옷 □ □ □ □
 * □ ■ ■ ■ □
 * □ ■ ■ ■ □
 * □ ■ ■ ■ □
 * □ □ □ □ □
 * <p>
 * 캐릭터(옷)가 이동 숫자를 입력받을 때마다 이동 할 수 있다.
 * 하지만 외각으로만 이동이 가능하다.
 * <p>
 * 옷 □ □ □ □
 * □ ■ ■ ■ □
 * □ ■ ■ ■ □
 * □ ■ ■ ■ □
 * □ □ □ □ □
 * <p>
 * 입력 ==> 3
 * <p>
 * # 나만의 마블
 * □ □ □ 옷 □
 * □ ■ ■ ■ □
 * □ ■ ■ ■ □
 * □ ■ ■ ■ □
 * □ □ □ □ □
 * <p>
 * 입력 ==> 3
 * <p>
 * # 나만의 마블
 * □ □ □ □ □
 * □ ■ ■ ■ □
 * □ ■ ■ ■ 옷
 * □ ■ ■ ■ □
 * □ □ □ □ □
 */

public class Day043032차원반복문심화2 {
    Scanner scanner = new Scanner(System.in);

    int[][] gameBoard = new int[5][5];
    int player = 1, empty = 0;
    int cannotMove = 2;

    /*
    값 2는 갈 수 없는 구역
     */
    public void gameSet() {
        gameBoard[0][0] = player;
        for (int i = 1; i < gameBoard.length - 1; i++) {
            for (int j = 1; j < gameBoard[i].length - 1; j++) {
                gameBoard[i][j] = cannotMove;
            }
        }
    }

    public void inGame() {
        gameSet();
        while (true) {
            int myX = -1, myY = -1;
            // 현재 나의 위치 찾기
            for (int i = 0; i < gameBoard.length; i++) {
                for (int j = 0; j < gameBoard.length; j++) {
                    if (gameBoard[i][j] == 1) {
                        System.out.print("옷\t");
                        myY = i;
                        myX = j;
                    } else if (gameBoard[i][j] == cannotMove) {
                        System.out.print("X\t");
                    } else if (gameBoard[i][j] == empty) {
                        System.out.print("ㅁ\t");
                    }
                }
                System.out.println();
            }
            System.out.print("이동할 칸을 입력하세요 / (-1) 입력시 게임 종료 : ");
            int myNum = scanner.nextInt(); // 0 ~ 4
            if (myNum == -1) {
                break;
            }
            int count = 0;
            while (count < myNum) {
                gameBoard[myY][myX] = empty;
                if (myY == 0 && myX < gameBoard.length - 1) {
                    myX++;
                } else if (myX == gameBoard.length - 1 && myY < gameBoard.length - 1) {
                    myY++;
                } else if (myY == gameBoard.length - 1 && myX > 0) {
                    myX--;
                } else if (myX == 0 && myY > 0) {
                    myY--;
                }
                gameBoard[myY][myX] = player;
                count++;
            }
        }
        System.out.println("게임 종료");
    }

    public static void main(String[] args) {
        Day043032차원반복문심화2 marvel = new Day043032차원반복문심화2();
        marvel.inGame();
    }
}

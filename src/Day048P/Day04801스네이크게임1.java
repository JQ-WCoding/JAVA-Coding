package Day048P;

import java.util.Random;
import java.util.Scanner;

/**
 * # 스네이크 게임
 * 1. 10x10 배열을 설정한다.
 * 2. 스네이크는 12345의 숫자로 표시한다.
 * 3. 스네이크는 상하좌우로 이동이 가능하며, 꼬리가 따라온다.
 * 4. 본인 몸과 부딪히면, 사망하게 된다.
 * ------ 2단계
 * * 5. 랜덤으로 아이템을 생성한다.
 * * 6. 스네이크는 아이템을 먹으면 꼬리가 1개 자란다.
 * * 7. 꼬리는 최대 8개까지만 증가할 수 있다.
 */
public class Day04801스네이크게임1 {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    final int SIZE = 10;
    int[][] map = new int[SIZE][SIZE];

    // 최소 길이가 5 이상이어야 몸과 부딪힐 수 있다
    int snakeSize = 4;
    int[] y = new int[snakeSize];
    int[] x = new int[snakeSize];
    int item = 9;

    /*
    초기 스네이크 설정
    map[0][0 ~ 3] = 1 ~ 4 로 표현
     */
    public void setSnake() {
        for (int i = 0; i < snakeSize; i++) {
            x[i] = i;
            y[i] = 0;

            map[y[i]][x[i]] = i + 1;
        }
    }

    /*
    맵 세팅
     */
    public void setMap() {
        setSnake();
        setItem();
    }

    /*
    아이템 세팅
     */
    public void setItem() {
        int count = 0;
        while (count < 5) {
            int mapX = random.nextInt(SIZE);
            int mapY = random.nextInt(SIZE);
            if (map[mapY][mapX] == 0) {
                map[mapY][mapX] = item;
                count++;
            }
        }
    }

    /*
    뱀 재표현
     */
    public void resetSnake() {
        // 뱀 재표현
        for (int i = 0; i < snakeSize; i++) {
            map[y[i]][x[i]] = i + 1;
        }
    }

    /*
    게임 플레이
     */
    public void mainActor() {
        setMap();
        moveSnake();
    }

    /*
    스네이크 표현
     */
    public void showSnake(int[][] map) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] != 1 && map[i][j] != item && map[i][j] != 0) {
                    System.out.print("⭐️\t");
                } else if (map[i][j] == 1) { // head
                    System.out.print("🌝\t");
                } else if (map[i][j] == item) {
                    System.out.print("🌸\t");
                } else {
                    System.out.print(map[i][j] + "\t");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /*
    키 세팅 보여주기
     */
    public void showKey() {
        System.out.println("     ▲(8)");
        System.out.println("◀(4) ▼(5) ▶(6)");
        System.out.println("(0) 종료");
    }

    /*
    스네이크 움직이기
     */
    public void moveSnake() {
        while (true) {
            showSnake(map);
            showKey();

            int choice = scanner.nextInt();
            // 머리 값만 임의 변수에 옮겨주기
            int tempX = x[0];
            int tempY = y[0];

            if (choice == 4) { // 좌 x--

                tempX--;
            } else if (choice == 5) { // 하 y++
                tempY++;
            } else if (choice == 6) { // 우 x++
                tempX++;
            } else if (choice == 8) { // 상 y--
                tempY--;
            } else if (choice == 0) { // 게임 종료
                break;
            } else { // 이외의 키를 입력했을 경우
                System.out.println("키 입력 오류");
                continue;
            }

            // 머리 부분만 확인
            if (tempX < 0 || tempY < 0 || tempX > map.length - 1 || tempY > map.length - 1) continue;

            if (map[tempY][tempX] != 0 && map[tempY][tempX] != item) {
                System.out.println("으악!");
                break;
            }

            // 꼬리부분만 0으로 초기화
            map[y[snakeSize - 1]][x[snakeSize - 1]] = 0;

            // 아이템에 대한 조건
            if (map[tempY][tempX] == item) {
                if (snakeSize < 8) {
                    snakeSize++; //  길이 증가
                } else {
                    System.out.println("더이상 늘어나지 않습니다");
                }
            }


            int[] tempXArray = new int[snakeSize];
            int[] tempYArray = new int[snakeSize];

            // 몸통 2 ~ 4까지 값 그대로 옮기기
            for (int i = snakeSize - 1; i > 0; i--) {
                tempXArray[i] = x[i - 1];
                tempYArray[i] = y[i - 1];
            }

            x = tempXArray;
            y = tempYArray;

            x[0] = tempX;
            y[0] = tempY;

            resetSnake();
        }
    }
}

class Snake {
    public static void main(String[] args) {
        Day04801스네이크게임1 snakeGame = new Day04801스네이크게임1();
        snakeGame.mainActor();
    }
}

package Day034P;

import java.util.Random;
import java.util.Scanner;

public class Day03403소코반정답 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int size = 7;
        int wall = 9, ball = 3, player = 2, goal = 7;

        // 공의 위치
        int notYetScanned = -1;
        int ballY = notYetScanned, ballX = notYetScanned;
        int goalY = notYetScanned, goalX = notYetScanned;
        int playerY = notYetScanned, playerX = notYetScanned;

        int[][] map = new int[size][size];
        // 벽 설치하기
        System.out.print("설치할 벽의 개수를 입력하세요 : ");
        int wallCount = scanner.nextInt();
        // 벽 설치
        while (wallCount != 0) {
            int y = random.nextInt(size);
            int x = random.nextInt(size);

            if (map[y][x] == 0) {
                map[y][x] = wall;
                wallCount--;
            }
        }
        // 공 설치하기
        while (true) {
            ballY = random.nextInt(5) + 1;
            ballX = random.nextInt(5) + 1;
            if (map[ballY][ballX] == 0) {
                map[ballY][ballX] = ball;
                break;
            }
        }
        // 골대 설치하기
        while (true) {
            goalY = random.nextInt(5) + 1;
            goalX = random.nextInt(5) + 1;
            if (map[goalY][goalX] == 0) {
                map[goalY][goalX] = goal;
                break;
            }
        }
        // 캐릭터 배치
        while (true) {
            System.out.print("캐릭터의 Y좌표 값을 입력하세요 : ");
            playerY = scanner.nextInt();
            System.out.print("캐릭터의 X좌표 값을 입력하세요 : ");
            playerX = scanner.nextInt();
            if (map[playerY][playerX] == 0) {
                map[playerY][playerX] = player;
                break;
            }
        }
        // 게임 시작
        while (true) {
            // 게임 화면 출력
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (map[i][j] == player) {
                        System.out.print("옷\t");
                    } else if (map[i][j] == wall) {
                        System.out.print("벽\t");
                    } else if (map[i][j] == ball) {
                        System.out.print("공\t");
                    } else if (map[i][j] == goal) {
                        System.out.print("골\t");
                    } else {
                        System.out.print(map[i][j] + "\t");
                    }
                }
                System.out.println();
            }
            System.out.println();

            // 게임 종료 조건
            if (ballY == goalY && ballX == goalX) {
                System.out.println("골! 게임을 종료합니다");
                break;
            }
            // 이동숫자 입력받기
            System.out.println("    ^(8)");
            System.out.println("<(4)  V(5)  >(6)");
            int move = scanner.nextInt();

            int tempY = playerY;
            int tempX = playerX;

            if (move == 4) tempX -= 1;
            else if (move == 6) tempX += 1;
            else if (move == 5) tempY += 1;
            else if (move == 8) tempY -= 1;

            // 캐릭터가 상하좌우 끝에 도달했을 경우에 대한 예외처리
            if (size <= tempY || tempY < 0) continue;
            if (size <= tempX || tempX < 0) continue;
            // 캐릭터 앞에 벽이나 골대가 있을 경우에 대한 예외처리
            if (map[tempY][tempX] == wall || map[tempY][tempX] == goal) continue;

            // 공을 만나면
            if (map[tempY][tempX] == ball) {
                int tempB_Y = ballY;
                int tempB_X = ballX;

                if(move == 4) { tempB_X = tempB_X - 1; }
                else if(move == 5) { tempB_Y = tempB_Y + 1; }
                else if(move == 6) { tempB_X = tempB_X + 1; }
                else if(move == 8) { tempB_Y = tempB_Y - 1; }

                // 공이 상하좌우 끝에 도달했을 경우에 대한 예외처리
                if(size <= tempB_Y || tempB_Y < 0) continue;
                if(size <= tempB_X || tempB_X < 0) continue;
                // 공 앞에 벽이 있을 경우에 대한 예외처리
                if(map[tempB_Y][tempB_X] == wall) continue;

                map[ballY][ballX] = 0;

                ballY = tempB_Y;
                ballX = tempB_X;

                map[ballY][ballX] = ball;
            }
            // 캐릭터 이동 전자리 0으로 초기화
            map[playerY][playerX] = 0;
            playerY = tempY;
            playerX = tempX;

            map[playerY][playerX] = player;
        }
    }
}

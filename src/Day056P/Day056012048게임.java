package Day056P;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Game2048 {
    int[][] game = {
            {2, 0, 2, 2},
            {0, 0, 0, 2},
            {0, 0, 0, 0},
            {0, 2, 0, 0}
    };

    public void print() {
        System.out.println("--------------------------");
        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(game[i]));
        }
        System.out.println("--------------------------");
    }

    public void randomNum() {
        Random random = new Random();
        while (true) {
            int y = random.nextInt(4);
            int x = random.nextInt(4);
            if (game[y][x] == 0) {
                game[y][x] = 2;
                break;
            }
        }
    }

    public boolean end() {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (game[i][j] != 0) {
                    count++;
                }
            }
        }
        return count == 16;
    }

    public void move(int direction) {
        for (int i = 0; i < 4; i++) {
            if (direction == 1) {
                int check = 0;
                for (int j = 0; j < 4; j++) {
                    if (game[i][j] != 0) {
                        game[i][check] = game[i][j];
                        if (check != j) {
                            game[i][j] = 0;
                        }
                        check++;
                    }
                }
            } if (direction == 2) {
                int check = 3;
                int k = 3;
                for (int j = 0; j < 4; j++) {
                    if (game[i][k] != 0) {
                        game[i][check] = game[i][k];
                        if (check != k) {
                            game[i][k] = 0;
                        }
                        check--;
                    }
                    k--;
                }
            } if (direction == 3) {
                int check = 0;
                for (int j = 0; j < 4; j++) {
                    if (game[j][i] != 0) {
                        game[check][i] = game[j][i];
                        if (check != j) {
                            game[j][i] = 0;
                        }
                        check++;
                    }
                }
            } if (direction == 4) {
                int check = 3;
                int k = 3;
                for (int j = 0; j < 4; j++) {
                    if (game[k][i] != 0) {
                        game[check][i] = game[k][i];
                        if (check != k) {
                            game[k][i] = 0;
                        }
                        check--;
                    }
                    k--;
                }
            }
        }
    }

    public void sum(int direction) {
        for (int i = 0; i < 4; i++) {
            if (direction == 1) {
                for (int j = 0; j < 3; j++) {
                    if (game[i][j] == game[i][j + 1]) {
                        game[i][j] += game[i][j + 1];
                        game[i][j + 1] = 0;
                        j++;
                    }
                }
            } if (direction == 2) {
                int k = 3;
                for (int j = 0; j < 3; j++) {
                    if (game[i][k] == game[i][k - 1]) {
                        game[i][k] += game[i][k - 1];
                        game[i][k - 1] = 0;
                        k--;
                        j++;
                    }
                }
            } if (direction == 3) {
                for (int j = 0; j < 3; j++) {
                    if (game[j][i] == game[j + 1][i]) {
                        game[j][i] += game[j + 1][i];
                        game[j + 1][i] = 0;
                        j++;
                    }
                }
            } if (direction == 4) {
                int k = 3;
                for (int j = 0; j < 3; j++) {
                    if (game[k][i] == game[k - 1][i]) {
                        game[k][i] += game[k - 1][i];
                        game[k - 1][i] = 0;
                        k--;
                        j++;
                    }
                }
            }
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            randomNum();
            print();
            System.out.println("1) left 2) right 3) up 4) down");
            int direction = scanner.nextInt();
            move(direction);
            sum(direction);
            move(direction);
            if (end()) {
                System.out.println("게임 오버");
                break;
            }
        }
    }
}

public class Day056012048게임 {
    public static void main(String[] args) {
        Game2048 game2048 = new Game2048();
        game2048.play();
    }
}

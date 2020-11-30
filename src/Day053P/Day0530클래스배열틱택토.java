package Day053P;

import java.util.Scanner;

class Game {
    int[] line = new int[3];

    void printLine() {
        for (int i = 0; i < line.length; i++) {
            if (line[i] == 0) {
                System.out.print("[ ]");
            } else if (line[i] == 1) {
                System.out.print("[O]");
            } else if (line[i] == 2) {
                System.out.print("[X]");
            }
        }
        System.out.println();
    }
}

public class Day0530클래스배열틱택토 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Game[] games = new Game[3];
        for (int i = 0; i < games.length; i++) {
            games[i] = new Game();
        }

        boolean turn = true;
        while (true) {
            for (int i = 0; i < games.length; i++) {
                games[i].printLine();
            }
            System.out.println();

            System.out.print("Y좌표 0 ~ 2를 입력하세요 : ");
            int y = scanner.nextInt();
            System.out.print("X좌표 0 ~ 2를 입력하세요 : ");
            int x = scanner.nextInt();

            if (turn && games[y].line[x] == 0) {
                games[y].line[x] = 1;
                turn = false;
                // turn = !turn;
            } else if (!turn && games[y].line[x] == 0) {
                games[y].line[x] = 2;
                turn = true;
            }
        }
    }
}

package Day056P;

import java.util.Scanner;

public class Day05602테트리스회전 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] block = new int[4][4];

        int number = 1;
        for (int i = 0; i < block.length; i++) {
            for (int j = 0; j < block[i].length; j++) {
                block[i][j] = number;
                number++;
                System.out.print(block[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println();
        while (true) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(block[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println("1) left  2) right");
            int move = scanner.nextInt();
            // (0,0) (4,0) (4,4) (0,4)
            if (move == 1) {
                for (int i = 0; i < 4; i++) {
                    int temp = block[0][i];
                    block[3 - i][0] = block[0][i];
                }
            } else if (move == 2) {
                break;
            }
        }
    }
}

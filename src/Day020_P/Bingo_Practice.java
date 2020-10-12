package Day020_P;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Bingo_Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();

        int[][] mine = new int[4][4];
        int[][] com = new int[4][4];
        int[][] check = new int[4][4];
        for (int i = 0; i < com.length; i++) {
            for (int j = 0; j < com[i].length; j++) {
                com[i][j] = rn.nextInt(16) + 1;
                check[i][j] = com[i][j];
                for (int k = 0; k < com[i].length; k++) {
                    if(com[i][j] == check[i][k]){
                        j--;
                    }
                }
            }
        }
//        for (int i = 0; i < com.length; i++) {
//            for (int j = 0; j < com[i].length; j++) {
//                com[i][j] = rn.nextInt(16) + 1;
//            }
//        }
//        Collections.shuffle(com);
        for (int i = 0; i < mine.length; i++) {
            for (int j = 0; j < mine[i].length; j++) {
                System.out.print(com[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
        boolean run = true;

        sc.close();
    }
}


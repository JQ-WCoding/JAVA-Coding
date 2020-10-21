package Day027P;

import java.util.Random;
import java.util.Scanner;

public class Day027041to18renew {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int[][] front = new int[3][3]; // front 3 X 3 array
        int[][] back = new int[3][3]; // back 3 x3 array
        for (int i = 0; i < front.length; i++) {
            for (int j = 0; j < front.length; j++) {
                front[i][j] = (i + j) + (i); // 1 ~ 9
                for (int z = 0; z < j; z++) {
                    if (front[i][j] == front[i][z]) {
                        j--;
                    }
                }
            }
        }
//        for (int i = 0; i < front.length; i++) {
//            for (int j = 0; j < front.length; j++) {
//                front[i][j] = (random.nextInt(3) + 1) + (i * 3); // 1 2 3
//                if (j == 1) {
//                    if (front[i][j - 1] == front[i][j]) {
//                        j--;
//                    }
//                } else if (j == 2) {
//                    if (front[i][j - 1] == front[i][j] || front[i][j - 2] == front[i][j]) {
//                        j--;
//                    }
//                }
//            }
//        } // 'front' array exception / duplicate processing
        for (int i = 0; i < back.length; i++) {
            for (int j = 0; j < back.length; j++) {
                back[i][j] = (random.nextInt(3) + 1) + ((i + 3) * 3); // 1 2 3
                if (j == 1) {
                    if (back[i][j - 1] == back[i][j]) {
                        j--;
                    }
                } else if (j == 2) {
                    if (back[i][j - 1] == back[i][j] || back[i][j - 2] == back[i][j]) {
                        j--;
                    }
                }
            }
        } // 'back' array exception / duplicate processing
        int numberCount = 1;
        while (true) {
            for (int i = 0; i < front.length; i++) {
                for (int j = 0; j < front[i].length; j++) {
                    System.out.print(front[i][j] + " ");
                }
                System.out.println();
            } // printing
            System.out.printf("%d의 위치를 찾으세요 : ", numberCount);
            int myIndex = scanner.nextInt() - 1;
            for (int i = 0; i < front.length; i++) {
                for (int j = 0; j < front.length; j++) {
                    if (front[i][j] == numberCount) {
                        if ((i + j) == myIndex) {
                            front[i][j] = back[i][j];
                            back[i][j] = 0;
                            numberCount++;
                        }
                    }
                }
            }
            if (numberCount == 18) {
                System.out.println("GameEnd");
                break;
            }
        }
    }
}

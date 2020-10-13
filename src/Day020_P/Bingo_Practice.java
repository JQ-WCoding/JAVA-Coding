package Day020_P;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Bingo_Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();
        int checkPointer = 0;
        int mineBingoCheck = 0;
        int comBingoCheck = 0;
        int[] mine = new int[16];
        int[] com = new int[16];
        int turn = 1;
        int[] check = new int[16];
        int checkI = 0;
        int checkJ = 0;

        for (int i = 0; i < 16; i++) {
            com[i] = rn.nextInt(16) + 1;
            check[i] = com[i];
            for (int j = 0; j < i; j++) {
                if (com[i] == check[j]) {
                    i--;
                }
            }
        }
//        for (int j : com){
//            System.out.print(j + " ");
//        }
        boolean mainRun = true;
        int count = 0;
        int[][] newCom = new int[4][4];
        for (int i = 0; i < newCom.length; i++) {
            for (int j = 0; j < newCom.length; j++) {
                newCom[i][j] = com[count];
                count++;
            }
        }
        // -- computer 빙고

        for (int i = 0; i < 16; i++) {
            mine[i] = rn.nextInt(16) + 1;
            check[i] = mine[i];
            for (int j = 0; j < i; j++) {
                if (mine[i] == check[j]) {
                    i--;
                }
            }
        }
        count = 0;
        int[][] newMine = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                newMine[i][j] = mine[count];
                count++;
            }
        }
        while (mainRun) {
            System.out.println("==Com==");
            for (int i = 0; i < newCom.length; i++) {
                for (int j = 0; j < newCom[i].length; j++) {
                    System.out.print(newCom[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();

            System.out.println("==Mine==");
            for (int i = 0; i < newMine.length; i++) {
                for (int j = 0; j < newMine[i].length; j++) {
                    System.out.print(newMine[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            // -- mine의 판

            int size = newMine.length;
            // switch case 이용 -> turn 값에 따라 순서 이동
            switch (turn){
                case 1 :
                    System.out.println("번호 부르기 : ");
                    int myCall = sc.nextInt();
                    for (int i = 0; i < size; i++) {
                        for (int j = 0; j < newMine[i].length; j++) {
                            if (myCall == newMine[i][j]) {
                                newMine[i][j] = checkPointer;
                                newCom[i][j] = checkPointer;
                                turn = 2;
                                if(mineBingoCheck == 3){
                                    turn = 3;
                                }
                            }
                        }
                    }
                case 2:
                    int comCall = rn.nextInt(16) + 1;
                    for (int i = 0; i < size; i++) {
                        for (int j = 0; j < newCom[i].length; j++) {
                            if (comCall == newCom[i][j]) {
                                newMine[i][j] = checkPointer;
                                newCom[i][j] = checkPointer;
                                turn = 1;
                                if(comBingoCheck == 3){
                                    turn = 3;
                                }
                            }
                        }
                    }
                case 3:
                    System.out.println("[게임종료]");
                    mainRun = false;
            }
//            switch (newMine[checkI][checkJ]) {
//                if(checkI == 0){
//                    case 1 :
//
//                }
//
//
//            }
//            while (run == 1) {
//                System.out.println("번호 부르기 : ");
//                int myCall = sc.nextInt();
//                for (int i = 0; i < size; i++) {
//                    for (int j = 0; j < newMine[i].length; j++) {
//                        if (myCall == newMine[i][j]) {
//                            newMine[i][j] = checkPointer;
//                            newCom[i][j] = checkPointer;
//                            run = 2;
//                            if(mineBingoCheck == 3){
//                                run = 3;
//                            }
//                        }
//                    }
//                }
//            }
//            while (run == 2) {
//                int comCall = rn.nextInt(16) + 1;
//                for (int i = 0; i < size; i++) {
//                    for (int j = 0; j < newCom[i].length; j++) {
//                        if (comCall == newCom[i][j]) {
//                            newMine[i][j] = checkPointer;
//                            newCom[i][j] = checkPointer;
//                            run = 1;
//                            if(comBingoCheck == 3){
//                                run = 3;
//                            }
//                        }
//                    }
//                }
//            }

//            if (int i = 0;i<4;i++){
//                switch(newMine[i][0] || newMine[0][i])
//                mineBingoCheck++;
//            }
//            if(){
//                comBingoCheck++;
//            }
        }

//        int[][] check = new int[4][4];
//        for (int i = 0; i < com.length; i++) {
//            for (int j = 0; j < com[i].length; j++) {
//                com[i][j] = rn.nextInt(16) + 1;
//                check[i][j] = com[i][j];
//                for (int k = 0; k < com[i].length; k++) {
//                    if(com[i][j] == check[i][k]){
//                        j--;
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < com.length; i++) {
//            for (int j = 0; j < com[i].length; j++) {
//                com[i][j] = rn.nextInt(16) + 1;
//            }
//        }
//        Collections.shuffle(com);

//        for (int i = 0; i < mine.length; i++) {
//            for (int j = 0; j < mine[i].length; j++) {
//                System.out.print(com[i][j] + "  ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//        boolean run = true;

        sc.close();
    }
}


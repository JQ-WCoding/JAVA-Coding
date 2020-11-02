package Day033P;

import java.util.Random;

public class Day03001P1 {
    public static void main(String[] args) {
        Random random = new Random();

        int[][] loottoSet = new int[5][7];

        boolean check = false;

        for (int i = 0; i < loottoSet.length; i++) { // i가 한번 증가하는

            for (int j = 0; j < loottoSet[i].length; j++) {
                int r = random.nextInt(2);
                if (r == 1) {
                    loottoSet[i][j] = 3;
                } else {
                    loottoSet[i][j] = 0;
                }
            }
            // 당첨여부 확인
            int win = 0;
            int count = 0;
            for (int j = 0; j < loottoSet.length; j++) {
                if (loottoSet[i][j] == 3) {
                    count++;
                } else {
                    count = 0;
                }
                if (count == 3) {
                    win = 1;
                }
            }

            if (win == 0 && check == false) {
                i++;
            } else if (win == 1 && check == false) {
                check = true;
            } else if (win == 1 && check == true) {
                i--;
            }
        } // i for문 종료
        for (int i = 0; i < 10; i++) {
            int r = random.nextInt(5);

            int[] temp = loottoSet[0];
            loottoSet[0] = loottoSet[r];
            loottoSet[r] = temp;
        }

        for (int i = 0; i < loottoSet.length; i++) {
            for (int j = 0; j < loottoSet[i].length; j++) {
                System.out.print(loottoSet[i][j] + " ");
            }
            System.out.println();
        }
    }
}
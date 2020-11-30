package Day053P;

import java.util.Random;

class Lotto {
    boolean win;
    int[] data = new int[8];

    void print() { // 출력하는 방식
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}

public class Day05305로또한세트 {
    public static void main(String[] args) {
        Random random = new Random();
        Lotto[] lottos = new Lotto[5];

        boolean check = false;
        int i = 0;
        while (i < 5) {
            lottos[i] = new Lotto();

            for (int j = 0; j < lottos[i].data.length; i++) {
                int r = random.nextInt();

                if (r == 0) {
                    lottos[i].data[j] = 0;
                } else {
                    lottos[i].data[j] = 3;
                }
            }


            for (int j = 0; j < lottos[i].data.length; j++) {
                int count = 0;
                if (lottos[i].data[j] == 3) {
                    count++;

                    if (count == 3) {
                        lottos[i].win = true;
                        break;
                    }
                }
            }
            if (check == false && lottos[i].win == true) {
                check = true;
                i++;
            } else if (check == true && lottos[i].win == false) {
                check = false;
                i++;
            }
        }
        // shuffle
        for (int j = 0; j < 100; j++) {
            int r = random.nextInt(5);

            Lotto temp = lottos[0];
            lottos[0] = lottos[r];
            lottos[r] = temp;
        }

        for (int j = 0; j < lottos.length; j++) {
            lottos[j].print();
        }
    }
}

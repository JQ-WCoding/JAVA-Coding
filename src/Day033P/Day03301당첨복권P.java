package Day033P;

import java.util.Random;

public class Day03301당첨복권P {
    Random random = new Random();
    public int[][] lottoSet = new int[5][7];
    int count = 0;
    int winner = -1;

    public void insertLottoNumber() {
        for (int i = 0; i < lottoSet.length; i++) {
            for (int j = 0; j < lottoSet[i].length; j++) {
                lottoSet[i][j] = random.nextInt(5);
            }
            for (int z = 0; z < lottoSet[i].length - 2; z++) {
                if (lottoSet[i][z] == 3 && lottoSet[i][z + 1] == 3 && lottoSet[i][z + 2] == 3) {
                    count++;
                }
            }
            if (count > 1) {
                i--;
            }
        }
        for (int i = 0; i < lottoSet.length; i++) {
            for (int j = 0; j < lottoSet[i].length - 2; j++) {
                if (lottoSet[i][j] == 3 && lottoSet[i][j + 1] == 3 && lottoSet[i][j + 2] == 3) {
                    winner = i;
                }
            }
        }
    }

    public void showLotto() {
        for (int i = 0; i < lottoSet.length; i++) {
            for (int j = 0; j < lottoSet[i].length; j++) {
                System.out.print(lottoSet[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void findoutWinner() {
        if (winner != -1) {
            System.out.print("당첨된 해당 번호 : ");
            for (int i = 0; i < lottoSet[winner].length; i++) {
                System.out.print(lottoSet[winner][i]);
            }
        } else {
            System.out.println("당첨번호가 없습니다");
        }
    }

    public static void main(String[] args) {
        /*
         * # 당첨복권 1세트
         * 1. 3이 연속으로 3번 등장하면 당첨복권이다.
         * 2. 랜덤으로 5개의 복권을 생성하되,
         *    당첨복권은 한 개만 생성되도록 설정한다.
         */
        Day03301당첨복권P game = new Day03301당첨복권P();
        game.insertLottoNumber(); // lotto number inserting
        game.showLotto();
        game.findoutWinner();

    }
}

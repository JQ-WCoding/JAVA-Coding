package Day020_P;

import java.util.Random;
import java.util.Scanner;

public class Day02002즉석복권Plus {
    public static void main(String[] args) {
        Random rn = new Random();
        Scanner sc = new Scanner(System.in);

        int[] lotto = new int[8];
        boolean run = true;
        // 로또 당첨 정하기
        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = rn.nextInt(2);
        }
        // CheatKey
        for (int j : lotto){
            System.out.print(j + " ");
        }
        while(run) {
            System.out.println("1) 당첨확인");
            System.out.println("2) 종료");
            int choice = sc.nextInt();
            if (choice == 1) {
                for(int i = 0;i<lotto.length;i++) {
                    if (lotto[i] == 1 && lotto[i + 1] == 1 && lotto[i + 2] == 1) {
                        System.out.println("당첨");
                    }
                }
            }
            else if(choice == 2){

            }
        }
        sc.close();
    }
}

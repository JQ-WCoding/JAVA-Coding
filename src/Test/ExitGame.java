package Test;

import java.util.Scanner;

public class ExitGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0;
        for (int i = 0; i < 5; i++) {
            System.out.print((i + 1) + ")번째 입력 :");
            int myNum = sc.nextInt();
            total += myNum;
            if (total > 100) {
                System.out.println("합 : " + total);
                i = 5;
//                break;
            }
           else{
                System.out.println("합 : " + total);
            }
        }
        System.out.println("프로그램 종료");
        sc.close();
    }
}

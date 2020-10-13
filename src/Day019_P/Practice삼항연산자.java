package Day019_P;

import java.util.Scanner;

public class Practice삼항연산자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 삼항연산자
        int number = 1;
        String check = number > 0 ? "양수" : "음수";
        System.out.println(check);
        if (number == 0) {
            System.out.println("0");
        }

        String plusCheck = (number == 0) ? "0" : (number > 0) ? "양수" : "음수";
        System.out.println(plusCheck);

        // total 구하기
        int total = 0;
        for (int i = 1; i <= 100; i++) {
            total += i;
        }
        System.out.println(total);

        // 5회 반복 총합
        total = 0;

        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + ")번 수를 입력하세요 :");
            int myNum = sc.nextInt();
            total += myNum;
            if (total > 100) {
                System.out.println("총합 : " + total);
                break;
            }
            System.out.println("총합 : " + total);
        }
    }
}

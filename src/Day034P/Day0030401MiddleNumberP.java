package Day034P;

import java.util.Scanner;

public class Day0030401MiddleNumberP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력하세요 : (1 ~ 1,000,000)");
        int num = scanner.nextInt();
        int count = 0;
        int x = 1;
        while (true) {
            if (num / x == 0) { // 더 이상 수가 없을 경우
                System.out.println(count + "자리 수");
                break;
            }
            x *= 10;
            count++;
        }
        if (count % 2 == 0) { // count 값이 짝수이면
            System.out.println("짝의 자리수이다.");
        } else { // num값의 자리수가 홀수인 경우
            for (int i = 1; i <= count; i++) {

            }
        }
//        int count = 0;
//        int index = 0;
//        int[] myNum = new int[7];
//        while (true) {
//            int i = 10;
//            int left = num / 1_000_000;
//            myNum[index] = left;
//            index++;
//            num %= 1_000_000 / i;
//            if (num < 10) {
//                break;
//            }
//            i = i * 10;
//        }
//        for (int i = 0; i < myNum.length; i++) {
//            if (myNum[i] == 0) {
//                count++;
//                if (myNum[i] != 0) {
//                    break; // 중간자리에 0이 있을경우 대비 첫번째 수가 시작된 이후는 계산하지 않는다
//                }
//            }
//        }
//        if (count % 2 == 1) {
//            System.out.println("짝의 자리수 입니다.");
//        } else { // 계산하기
//
//        }
    }
}

package Day023_P;

import java.util.Random;

public class PrimeNumber {
    public static void main(String[] args) {
        /*
         * # 소수찾기[1단계]
         * 1. 소수란, 1과 자기자신으로 나눠지는 수
         * 2. 예) 2, 3, 5, 7, 11, 13, ...
         * 3. 힌트
         * 1) 해당 숫자를 1부터 자기자신까지 나눈다.
         * 2) 나머지가 0일 때마다 카운트를 센다.
         * 3) 그 카운트 값이 2이면 소수이다.
         * 4) 6/1 6/2 6/3 6/4 6/5 6/6	count = 4(소수X)
         *    5/1 5/2 5/3 5/4 5/5		count = 2(소수O)
         *
         * # 정수 1개를 입력받아, 해당 숫자가 소수인지 아닌지 판별한다.
         */
        Random random = new Random();
        int number = random.nextInt(100) + 1; // number 변수에 랜덤한 숫자를 초기화 ( 범위 : 1 ~ 100)
        int count = 0; // 나누어졌을때 마다 카운트 증가
        for (int i = 1; i <= number; i++) {
            if (number % i == 0){
                count++;
            }
        }
        if (count == 2){
            System.out.println(number + "은 소수이다.");
        }
        else {
            System.out.println(number + "은 소수가 아니다.");
        }
    }
}

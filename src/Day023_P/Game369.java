package Day023_P;

public class Game369 {
    public static void main(String[] args) {
        /*
         * # 369게임[2단계]
         * 1. 1 ~ 50까지 반복을 진행한다.
         * 2. 그 안에 해당 숫자의 369게임 결과를 출력한다.
         * 3. 3 6 9 1번 등장 => 짝
         *    3 6 9 2번 등장 => 짝짝
         *    3 6 9 0번 등장 => 숫자
         * 예) 1 2 짝 4 5 짝 7 8 짝 10 11 12 짝 ....
         */
        int clapCount;
        for (int i = 1; i <= 50; i++) {
            // 반복문 내에서 선언 이유 : i가 반복문 조건의 변수
            int unitDigit = i % 10; //  1의 자리 표현
            int tensDigit = i / 10; // 10의 자리 표현
            clapCount = 0;
            if (unitDigit % 3 == 0 && unitDigit != 0) { // 1의 자리수가 3의 배수일때 , 0인경우도 나머지 0이기에 제외
                clapCount++; // 박수 횟수 증가 1
            }
            if (tensDigit % 3 == 0 && tensDigit != 0) { // 10의 자리수가 3의 배수일때, 10의 자리가 없는 경우도 0이기에 제외
                clapCount++; // 박수 횟수 증가 1
            }
            if (clapCount == 0) { // 박수가 0번일땐 본연의 수 출력
                System.out.print(i + " ");
            } else if (clapCount == 1) { // 박수가 한번일때 i가 아닌 박수를 출력
                System.out.print(" 짝 ");
            } else { // clapCount == 2인 경우와 같음, 박수가 두번일때 i가 아닌 박수두번 출력
                System.out.print(" 짝짝 ");
            }
        }
        System.out.println(); // 줄바꿈
        System.out.println("[프로그램 종료]");
    }
}

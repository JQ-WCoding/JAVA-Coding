package Day020_P;

import java.util.Arrays;
import java.util.Scanner;

public class Day02001영화관좌석예매_P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
         * # 영화관 좌석예매
         * 1. 사용자로부터 좌석번호(index)를 입력받아 예매
         * 2. 예매가 완료되면 해당 좌석 값을 1로 변경
         * 3. 이미 예매가 끝난 좌석은 재구매 불가
         * 4. 한 좌석당 예매 가격은 12000원
         * 5. 프로그램 종료 후, 해당 영화관의 총 매출액 출력
         */
        int[] seats = new int[10];
        Arrays.fill(seats, 0);
        int count = 0;
        int total = 0;
        // 예매 완료시 1, 빈좌석 0으로 표시
        while (true) {
            System.out.println("[1]좌석예매");
            System.out.println("[2]좌석확인");
            System.out.println("[0]종료");
            int menuChoice = scanner.nextInt(); // 메뉴 입력받기
            if (menuChoice == 1) { // 1번 메뉴 좌석예매
                for (int i = 0; i < seats.length; i++) {
                    System.out.print(" [" + (i + 1) + "] ");
                }
                System.out.println(); // 줄바꿈
                for (int i : seats) {
                    System.out.print(" [" + i + "] ");
                }
                System.out.println(); // 줄바꿈
                System.out.println("원하는 좌석을 입력해주세요");
                int mySeat = scanner.nextInt() - 1; // 좌석 입력받기 index는 0부터 시작 입력받은 값에 -1 해주기
                int check = -1; // -1인 경우 자리가 비어있음, 1인경우 자리가 이미 존재함
                for (int i = 0; i < seats.length; i++) {
                    if (seats[mySeat] == 1) {
                        check = 1; // seats 배열 내의 값이 1인경우 check도 1로 초기화하여 예약된 자리 확인
                    }
                }
                if (check == -1) { // 예약된 좌석이 없는경우
                    seats[mySeat] = 1;
                    System.out.println("선택한 자리를 예매하였습니다");
                } else {
                    System.out.println("[알림] 예약된 좌석입니다");
                }
            } else if (menuChoice == 2) { // 2번 메뉴 좌석확인
                for (int i = 0; i < seats.length; i++) {
                    System.out.print(" [" + (i + 1) + "] ");
                }
                System.out.println(); // 줄바꿈
                for (int i : seats) {
                    System.out.print(" [" + i + "] ");
                }
                System.out.println(); // 줄바꿈
            } else if (menuChoice == 0) { // 0번 프로그램 종료
                for (int i = 0; i < seats.length; i++) {
                    if (seats[i] == 1) {
                        count++;
                    }
                }
                total = count * 12_000;
                System.out.println("합계 : " + total + "원");
                System.out.println("[알림] 프로그램 종료");
                break; // 반복문 탈출
            }
        }
    }
}

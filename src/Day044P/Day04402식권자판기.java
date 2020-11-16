package Day044P;

import java.util.Arrays;
import java.util.Scanner;

/**
 * # 식권 자판기 프로그램
 * [1] 관리자
 * 1) 식권충전
 * 2) 잔돈충전
 * 3) 뒤로가기
 * <p>
 * [2] 사용자
 * 1) 구입
 * . 구매할 식권 개수 입력(식권의 개수가 부족할 경우, 매진이라 출력)
 * . 입금 금액 입력
 * . 잔돈 출력
 * 2) 뒤로가기
 * <p>
 * 예1)
 * # 거래 전	:: 잔돈(18,000원)
 * 5만원(1)	1만원(1)	5천원(1)	1천원(1)	5백원(1)	1백원(5)
 * # 거래 후
 * 5만원(1)	1만원(1)	5천원(1)	1천원(0)	5백원(0)	1백원(2)
 * <p>
 * 예2)
 * # 거래 전	:: 잔돈(18,000원)
 * 5만원(1)	1만원(1)	5천원(1)	1천원(0)	5백원(0)	1백원(20)
 * # 거래 후
 * 5만원(1)	1만원(1)	5천원(1)	1천원(0)	5백원(0)	1백원(2)
 * <p>
 * 예3)
 * # 거래 전	:: 잔돈(18,000원)
 * 5만원(1)	1만원(1)	5천원(1)	1천원(1)	5백원(1)	1백원(0)
 * # 거래불가함
 */

public class Day04402식권자판기 {
    Scanner scanner = new Scanner(System.in);

    int[] moneys = {50000, 10000, 5000, 1000, 500, 100};        // 화폐 종류
    int[] charges = {1, 1, 1, 1, 1, 5};        // 화폐 종류별 수량

    int ticketCount = 5;        // 식권의 재고 수량
    int ticketPrice = 3200;        // 식권의 가격

    /*
    관리자 메뉴
     */
    public void mainMenu() {
        while (true) {
            System.out.println("[1]관리자");
            System.out.println("[2]사용자");
            System.out.println("[0]종료");

            System.out.println("메뉴를 선택하세요.");
            int select = scanner.nextInt();

            if (select == 1) {
                manager();
            } else if (select == 2) {
                user();
            } else if (select == 0) {
                break;
            }
        }
    }

    public void manager() {
        while (true) {
            System.out.println("1)식권충전");
            System.out.println("2)잔돈충전");
            System.out.println("3)뒤로가기");

            int choice = scanner.nextInt();

            if (choice == 1) {
                manageTicket();
            } else if (choice == 2) {
                manageMoney();
            } else if (choice == 3) {
                break;
            }
        }
    }

    /*
    식권 충전
     */
    public void manageTicket() {
        System.out.println("현재 티켓 수 : " + ticketCount + "개");
        System.out.print("충전할 티켓 수 : ");
        int plusTicket = scanner.nextInt();
        if (plusTicket < 0) {
            System.out.println("입력 오류");
        } else {
            System.out.println("충전완료");
            ticketCount += plusTicket;
            System.out.println("현재 티켓 수 : " + ticketCount + "개");
        }
    }

    /*
    잔돈 관리
     */
    public void manageMoney() {
        System.out.print("충전할 금액권을 입력하세요 : ");
        int checkMoney = scanner.nextInt();
        int checkIndex = -1;
        for (int i = 0; i < moneys.length; i++) {
            if (checkMoney == moneys[i]) {
                checkIndex = i;
            }
        }
        if (checkIndex != -1) {
            System.out.print(checkMoney + "권을 몇장 넣어두시겠어요? : ");
            int plusNumber = scanner.nextInt();
            charges[checkIndex] += plusNumber;
        } else {
            System.out.println("해당 지패권이 등록되어 있지 않습니다");
        }
    }

    /*
    유저 메뉴
     */
    public void user() {
        while (true) {
            System.out.println("1)구입하기");
            System.out.println("2)뒤로가기");

            int choice = scanner.nextInt();

            if (choice == 1) {
                userBuy();
            } else if (choice == 2) {
                break;
            }
        }
    }

    /*
    유저 구입하기 메뉴
     */
    public void userBuy() {
        System.out.println("현재 남은 티켓 수량 : " + ticketCount + "개");
        System.out.print("몇장 구입하시겠습니까? : ");
        int buyTicket = scanner.nextInt();
        // 구매 수량보다 티켓 수량이 부족한 경우
        if (buyTicket > ticketCount) {
            System.out.println("수량이 부족합니다");
        } else { // 구매 수량이 적정하게 있는 경우
            // 총 금액 계산
            int total = buyTicket * ticketPrice;
            System.out.println("총 " + total + "원");
            System.out.print(buyTicket + "개 구매합니다. 현금을 넣어주세요 : ");
            /*
            현금넣는 공간
             */
            int[] firstTempCharges = new int[charges.length];
            while (true) {
                System.out.println("[0] 종료");
                for (int i = 0; i < charges.length; i++) {
                    System.out.println("[" + (i + 1) + "] " + moneys[i] + "원 권");
                }
                int myChoice = scanner.nextInt() - 1;
                if (myChoice == -1) {
                    break;
                }
                System.out.print("몇장을 넣으세요 ? : ");
                int howMany = scanner.nextInt();
                firstTempCharges[myChoice] += howMany;
            }
            // 넣은 금액의 총합
            int chargesTotal = 0;
            for (int i = 0; i < charges.length; i++) {
                chargesTotal += firstTempCharges[i] * moneys[i];
            }
            // 금액이 부족한 경우
            if (chargesTotal < total) {
                System.out.println("금액이 부족합니다");
            } else { // 제대로 금액을 입력한 경우
                // 잔돈 확인을 위한 변수
                int leftMoney = chargesTotal - total;
                // 임시 몫 설정
                int[] tempCharges = new int[charges.length];
                // 제대로 입력된 현금을 각각의 charges 배열 값에 추가한다
                for (int i = 0; i < charges.length; i++) {
                    charges[i] += firstTempCharges[i];
                }

                int index = -1;
                int check = -1;
                for (int i = 0; i < moneys.length; i++) {
                    if (leftMoney / moneys[i] != 0) {
                        index = i;
                        break;
                    }
                }
                for (int i = index; i < moneys.length; i++) {
                    tempCharges[i] = leftMoney / moneys[i];
                    leftMoney %= moneys[i];
                }
                for (int i = index; i < moneys.length; i++) {
                    if (tempCharges[i] > charges[i]) {
                        check = i;
                        break;
                    }
                }
                if (check == -1) {
                    System.out.println("구매 완료");
                    for (int i = index; i < moneys.length; i++) {
                        charges[i] -= tempCharges[i];
                        System.out.print(moneys[i] + "권 : " + tempCharges[i] + "개 ");
                    }
                    System.out.println();
                    System.out.println(Arrays.toString(charges));
                    ticketCount -= buyTicket; // 티켓 수량 재설정
                } else {
                    System.out.println("잔돈 부족 / 거래 불가");
                }
            }
        }
    }

    public static void main(String[] args) {
        Day04402식권자판기 ticket = new Day04402식권자판기();
        ticket.mainMenu();
    }
}

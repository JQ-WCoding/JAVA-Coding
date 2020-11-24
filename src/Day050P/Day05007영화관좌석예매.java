package Day050P;

import java.util.Arrays;
import java.util.Scanner;

/**
 * # 영화관 좌석예매 : 클래스 + 변수
 * 1. 사용자로부터 좌석번호(index)를 입력받아 예매하는 시스템이다.
 * 2. 예매가 완료되면 해당 좌석 값을 1로 변경한다.
 * 3. 이미 예매가 완료된 좌석은 재구매할 수 없다.
 * 4. 한 좌석당 예매 가격은 12000원이다.
 * 5. 프로그램 종료 후, 해당 영화관의 총 매출액을 출력한다.
 * 예)
 * seat = 0 0 0 0 0 0 0
 * <p>
 * 좌석선택 : 1
 * seat = 0 1 0 0 0 0 0
 * <p>
 * 좌석선택 : 3
 * seat = 0 1 0 1 0 0 0
 * <p>
 * 좌석선택 : 3
 * seat = 0 1 0 1 0 0 0
 * 이미 예매가 완료된 자리입니다.
 * ----------------------
 * 매출액 : 24000원
 */
class Ex07 {
    int[] seat = new int[7];
    int money = 0;
}

public class Day05007영화관좌석예매 {
    public static void main(String[] args) {
        Solution07 solution = new Solution07();
        solution.mainActor();
    }
}

class Solution07 {
    Ex07 ex07 = new Ex07();
    int count = 0;

    public void showMenu() {
        System.out.println("[GREEN MOVIE]");
        System.out.println("[1]좌석예매");
        System.out.println("[2]종료하기");
    }

    public void showLeftSeat() {
        System.out.println(Arrays.toString(ex07.seat));
    }

    public void mainActor() {
        while (true) {
            showMenu();
            Scanner scanner = new Scanner(System.in);
            System.out.print("메뉴 선택 : ");
            int sel = scanner.nextInt();

            if (sel == 1) { // 좌석예매
                showLeftSeat();
                booking();
            } else if (sel == 2) {
                totalCharge();
                break;
            }
        }
    }

    public void booking() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("예약할 자리를 선택해주세요 : ");
        int mySeat = scanner.nextInt();

        if (ex07.seat[mySeat] == 0) {
            ex07.seat[mySeat] = 1;
            count++;
        } else {
            System.out.println("이미 예약완료된 좌석입니다");
        }
    }

    public void totalCharge() {
        ex07.money = count * 12000;
        System.out.println("총 : " + ex07.money + "원");
    }
}

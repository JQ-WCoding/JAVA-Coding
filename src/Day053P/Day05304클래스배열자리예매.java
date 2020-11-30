package Day053P;

import java.util.Scanner;

class Seat {
    boolean check;

    void showData() {
        if (check) {
            System.out.print("O ");
        } else {
            System.out.print("X ");
        }
    }
}

public class Day05304클래스배열자리예매 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Seat[] seatList = new Seat[8];

        for (int i = 0; i < seatList.length; i++) {
            seatList[i] = new Seat();
        }

        while (true) {
            for (Seat seat : seatList) {
                seat.showData();
            }
            System.out.println();

            System.out.println("번호를 입력하세요");
            int sel = scanner.nextInt();
            if (sel == 111){
                System.out.println("종료");
                break;
            }

            if (!seatList[sel].check) {
                seatList[sel].check = true;
            }else {
                System.out.println("이미 선택한 자리입니다");
            }
        }
    }
}

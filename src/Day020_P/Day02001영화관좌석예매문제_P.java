package Day020_P;

import java.util.Scanner;

public class Day02001영화관좌석예매문제_P {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] seat = new int[7];
		boolean run = true;
		while (run) {
			System.out.println("[영화관]");
			System.out.println("1) 좌석예매");
			System.out.println("2) 종료");

			int choice = sc.nextInt();

			if (choice == 1) {
				System.out.println("좌석을 입력하세요 : ");
				System.out.println("좌석은 1 ~ 7번까지 있습니다.");
				System.out.println("현재좌석 현황");
				for (int i = 0; i < seat.length; i++) {
					System.out.print(" " + (i + 1) + " ");
				}
				System.out.println();
				for (int j : seat) {
					if (j == 1) {
						System.out.print(" X ");
					} else {
						System.out.print(" O ");
					}
				}
				System.out.println();
				int seatIndex = sc.nextInt();
				if (seatIndex > 0 && seatIndex <= 7) {
					if (seat[seatIndex - 1] != 1) {
						seat[seatIndex - 1] = 1;
						System.out.println("예약 완료");
					} else if (seat[seatIndex - 1] == 1) {
						System.out.println("이미 예약된 좌석");
					}
				} else {
					System.out.println("존재하지 않는 좌석입니다.");
				}

			} else if (choice == 2) {
				int count = 0;
				for (int j : seat) {
					if (j == 1) {
						count++;
					}
				}
				System.out.println("영화관 총 매출액 : " + (count * 12000) + "원");
				System.out.println("프로그램을 종료합니다.");
				run = false;
			}
		}
		sc.close();
	}
}

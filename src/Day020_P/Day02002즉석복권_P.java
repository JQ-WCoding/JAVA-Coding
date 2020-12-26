package Day020_P;

import java.util.Scanner;

public class Day02002즉석복권_P {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//	 7이 연속 3번이면 당첨
		int[] lotto = { 0, 0, 7, 7, 7, 0, 0, 0 };
		boolean run = true;

		while (run) {
			System.out.println("1) 복권결과 확인");
			System.out.println("2) 종료");

			int choice = sc.nextInt();
			if (choice == 1) {
				int check = -1;
				for (int i = 0; i < lotto.length; i++) {
					if (lotto[i] == 7 && lotto[i + 1] == 7 && lotto[i + 2] == 7) {
						check = 1;
					}
				}
				if (check == 1) {
					System.out.println("당첨");
				} else {
					System.out.println("꽝!");
				}
			} else if (choice == 2) {
				System.out.println("시스템 종료");
			}
		}
		sc.close();
	}
}

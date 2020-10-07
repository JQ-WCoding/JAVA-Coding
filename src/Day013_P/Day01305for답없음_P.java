package Day013_P;

import java.util.Scanner;

public class Day01305for답없음_P {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int total = 0;
		for (int i = 1; i <= 5; i++) {
			System.out.println("(" + i + ")정수를 입력하세요 : ");
			int num = sc.nextInt();

			total = total + num;
			System.out.println("합 : " + total);
			if (total >= 100) {
				i = 6;
				System.out.println("강제 종료!");
			}
			if (i == 5) {
				System.out.println("종료!");
			}
		}
		sc.close();
	}
}
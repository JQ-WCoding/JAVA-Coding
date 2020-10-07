package Day013_P;

import java.util.Scanner;

public class Day01305for답없음_P1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int total = 0;
		for (int i = 0; i < 5; i++) {
			System.out.println((i + 1) + "번째 정수를 입력하세요 : ");
			int num = sc.nextInt();
			total += num;
			System.out.println("합 : " + total);
			if (total >= 100) {
				System.out.println("종료!");
				i = 5;
			}
		}
		sc.close();
	}
}

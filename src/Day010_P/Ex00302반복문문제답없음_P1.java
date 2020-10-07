package Day010_P;

import java.util.Scanner;

public class Ex00302반복문문제답없음_P1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int myNum = 0;
		int total = 0;
		for (int i = 0; i < 5; i++) {
			System.out.println((i + 1) + "번째 정수를 입력하세요 :");
			myNum = sc.nextInt();
			total += myNum;
			System.out.println("합 : " + total);
			if (total > 1000) {
				System.out.println("합 : " + total + " 종료!");
				i = 5;
			}
		}
		sc.close();
	}
}

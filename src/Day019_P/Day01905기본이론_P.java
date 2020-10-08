package Day019_P;

import java.util.Scanner;

public class Day01905기본이론_P {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				System.out.println(i + " : " + j);
				// j가 2일 경우 break를 통해 
				if (j == 2) {
					break;
				}
			}
		}
		System.out.println("숫자 입력: ");
		// -100 입력시 반복문 종료
		while (true) {
			int num = sc.nextInt();
			if (num == -100) {
				System.out.println("프로그램 종료");
				break;
			}
			System.out.println("실행될까?"); // -100을 입력하여 break문에 도달하지 않으면 계속해서 출력
		}
		sc.close();
	}
}

package Day009_P;

import java.util.Scanner;

public class Ex00301반복문종료문제_P {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자 입력[EXIT : - 100] : ");
		int num = sc.nextInt();
		
		while(num != -100) {
			System.out.println("숫자 입력[EXIT : - 100] : ");
			num = sc.nextInt();
		}
		System.out.println("프로그램 종료");
		sc.close();
	}
}

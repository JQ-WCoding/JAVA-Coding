package Day009_P;

import java.util.Scanner;

public class Ex00301반복종료문제_P1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

		int run = 1;
		while(run == 1) {
			System.out.println("숫자 입력 [EXIT : -100] : ");
			int num = sc.nextInt();
			if(num == -100) {
				System.out.println("프로그램 종료");
				run = 0;
			}
			else {
				System.out.println(num);
			}
		}
		sc.close();
	}
}

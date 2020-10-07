package Day004_P;

import java.util.Scanner;

public class Day00403조건문기본문제_P {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Q1
		System.out.println("숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num > 0) {
			System.out.println("양수");
		}
		else if(num == 0) {
			System.out.println("0");
		}
		else if(num < 0) {
			System.out.println("음수");
		}
		//Q2
		System.out.println("정수를 입력하세요 : ");
		num = sc.nextInt();
		
		if(num % 4 == 0) {
			System.out.println("4의 배수입니다.");
		}
		if(num % 4 != 0) {
			System.out.println("4의 배수아닙니다.");
		}
		
		sc.close();
	}
}

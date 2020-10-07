package Day001_P;

import java.util.Scanner;

public class Ex00104입력받기_P2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//Q1
		int[] num = new int[2];
		int duplicate1 = 0;
		int duplicate2 = 0;

		for (int i = 0; i < 2; i++) {
			System.out.println("정수(" + (i + 1) + ")를 입력하세요 : ");
			num[i] = sc.nextInt();
			duplicate1 = num[0];
			duplicate2 = num[1];
		}
		int z = duplicate1;
		duplicate1 = duplicate2;
		duplicate2 = z;
		System.out.println("x = " + duplicate1 + " / y = " + duplicate2);

		//Q2
		System.out.println("정수를 입력하세요 : ");
		int number = sc.nextInt();
		if (number % 3 == 0 && number % 2 == 0) {
			System.out.println("3과 2의 배수");
		} else {
			System.out.println("3과 2의 배수가 아니다");
		}

		//Q3
		System.out.println("월급을 입력하세요 : ");
		int salary = sc.nextInt();
		System.out.println("세율을 입력하세요 : ");
		int tax = sc.nextInt();
		int afterTaxSalry = salary - salary / tax;
		System.out.println("세후 연봉 : " + afterTaxSalry * 12 + "원");

		//Q4

		for (int i = 0; i < 2; i++) {
			System.out.println("정수(" + (i + 1) + ")를 입력하세요");
			num[i] = sc.nextInt();
		}
//		int answer = num[0] * num[1];
		//		System.out.println());

		sc.close();
	}
}

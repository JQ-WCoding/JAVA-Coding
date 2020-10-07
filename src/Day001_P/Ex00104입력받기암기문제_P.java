package Day001_P;

import java.util.Scanner;

public class Ex00104입력받기암기문제_P {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Q1
		System.out.println("정수1을 입력하세요 : ");
		int x = sc.nextInt();
		System.out.println("정수2를 입력하세요 : ");
		int y = sc.nextInt();
		int z = x;
		
		x = y;
		y = z;
		System.out.println("x = " + x + "/ y = " + y);
		
		//Q2
		System.out.println("정수를 하나 입력하세요 : ");
		x = sc.nextInt();
		System.out.println(x % 3 == 0 && x % 2 == 0);
		
		//Q3
		System.out.println("월급을 입력하세요 : ");
		int salary = sc.nextInt();
		System.out.println("세금을 입력하세요 : (%)");
		double tax = sc.nextInt();
		double afterTaxSalary = (salary - (salary / tax)) * 12;
		System.out.println(afterTaxSalary + "원");
		
		//Q4
		System.out.println("숫자1을 입력하세요 : ");
		x = sc.nextInt();
		System.out.println("숫자2를 입력하세요 : ");
		y = sc.nextInt();
		int answer = x * y;
		System.out.println(x + " * " + y + " = ?");
		System.out.println("정답은 ? ");
		int myAnswer = sc.nextInt();
		System.out.println(answer == myAnswer);
		
		//Q5
		System.out.println("돈을 입력하세요 : ");
		int myMoney = sc.nextInt();
		int oneCoin = (myMoney % 10000) % 500 / 100;
		System.out.println(oneCoin + "개");
		
		sc.close();
	}
}

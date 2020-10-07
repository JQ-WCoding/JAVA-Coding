package Day007_P;

import java.util.Random;
import java.util.Scanner;

public class Day00705연산자기호맞추기_P1 {
	public static void main(String[] args) {
		Random rn = new Random();
		Scanner sc = new Scanner(System.in);
		
		int num1 = rn.nextInt(10) + 1;
		int num2 = rn.nextInt(10) + 1;
		int num3 = rn.nextInt(4) + 1;

		int answer = 0;
		if(num3 == 1) {
			answer = num1 + num2;
		}
		else if(num3 == 2) {
			answer = num1 - num2;
		}
		else if(num3 == 3) {
			answer = num1 * num2;
		}
		else if(num3 == 4) {
			answer = num1 % num2;
		}
		System.out.println(num1 + " ? " + num2 + " = " + answer);
		System.out.println("?의 값은 : ");
		System.out.println("1) +  2) -  3) *  4) %");
		int myAnswer = sc.nextInt();
		
		if(num3 == myAnswer) {
			System.out.println("정답!");
		}
		else {
			System.out.println("오답!");
		}
		sc.close();
	}
}

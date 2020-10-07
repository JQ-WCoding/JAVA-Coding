package Day008_P;

import java.util.Random;
import java.util.Scanner;

public class Day00805구구단게임3_P1 {
	public static void main(String[] args) {
		Random rn = new Random();
		Scanner sc = new Scanner(System.in);

		int count = 0;

		int num1 = 0;
		int num2 = 0;
		int answer = 0;
		for (int i = 0; i < 5; i++) {
			num1 = rn.nextInt(8) + 2;
			num2 = rn.nextInt(9) + 1;
			answer = num1 * num2;

			System.out.println("(" + (i + 1) + "번) " + num1 + " * " + num2 + " = ?");
			int myAnswer = sc.nextInt();

			if (answer == myAnswer) {
				count++;
			}
		}
		System.out.println("정답 개수 : " + count + "개");
		System.out.println("총점 : " + count * 20 + "점");

		sc.close();
	}
}

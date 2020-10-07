package Day015_P;

import java.util.Scanner;

public class Day01504배열응용1_P1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Q1
		int[] a = { 10, 49, 51, 36, 17 };
		System.out.println("값을 입력하세요 : ");
		int myNum = sc.nextInt();
		int index = 0;
		for (int i = 0; i < 5; i++) {
			if (myNum == a[i]) {
				index = i;
			}
		}
		System.out.println(index);

		//Q2
		int[] b = { 0, 0, 0, 0, 0 };
		for (int i = 0; i < 5; i++) {
			if (a[i] % 2 == 1) {
				b[i] = a[i];
			}
			System.out.print(b[i] + " ");
		}
		System.out.println();

		//Q3
		int[] c = { 0, 0, 0, 0, 0 };
		int count = 0;
		for (int i = 0; i < 5; i++) {
			if (a[i] % 2 == 1) {
				c[count] = a[i];
				count++;
			}
		}
		for (int i = 0; i < 5; i++) {
			System.out.print(c[i] + " ");
		}
		System.out.println();

		//Q4
		int[] info = { 1001, 20, 1002, 45, 1003, 54 };
		System.out.println("학번을 입력하세요 : ");
		int hakbun = sc.nextInt();
		index = 0;
		for (int i = 0; i < 6; i++) {
			if (hakbun == info[i]) {
				index = i + 1;
			}
		}
		System.out.println("성적 : " + info[index] + "점");

		//Q5
		System.out.println("점수를 입력하세요 : ");
		int score = sc.nextInt();
		index = 0;
		for (int i = 0; i < 6; i++) {
			if (score == info[i]) {
				index = i - 1;
			}
		}
		System.out.println("학번 : " + info[index]);

		sc.close();
	}
}

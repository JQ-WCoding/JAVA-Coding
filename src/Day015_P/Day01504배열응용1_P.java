package Day015_P;

import java.util.Scanner;

public class Day01504배열응용1_P {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = { 10, 49, 51, 36, 17 };
		//Q1
		System.out.println("값을 입력하세요 : ");
		int num = sc.nextInt();

		for (int i = 0; i < 5; i++) {
			if (a[i] == num) {
				System.out.println(i);
			}
		}
		//Q2
		int[] b = { 0, 0, 0, 0, 0 };
		for (int i = 0; i < 5; i++) {
			if (a[i] % 2 == 1) {
				b[i] = a[i];
			}
		}
		for (int i = 0; i < 5; i++) {
			System.out.print(b[i] + " ");
		}
		//Q3
		System.out.println();
		int[] c = new int[5];
		int j = 0;
		for (int i = 0; i < 5; i++) {
			if (a[i] % 2 == 1) {
				c[j] = a[i];
				j++;
			}
		}
		for (int i = 0; i < 5; i++) {
			System.out.print(c[i] + " ");
		}
		System.out.println();
		//Q4
		int index = 0;
		int[] info = { 1001, 20, 1002, 45, 1003, 54 };
		System.out.println("학번을 입력하세요 : ");
		int myNum = sc.nextInt();
		for (int i = 0; i < 6; i++) {
			if (info[i] == myNum) {
				index = i;
			}
		}
		System.out.println(info[index + 1]);
		//Q5
		index = 0;
		System.out.println("점수를 입력하세요 : ");
		int myScore = sc.nextInt();
		for (int i = 0; i < 6; i++) {
			if (info[i] == myScore) {
				index = i;
			}
		}
		System.out.println(info[index - 1]);

		sc.close();
	}
}

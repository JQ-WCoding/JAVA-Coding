package Day018_P;

import java.util.Scanner;

public class Day01802배열응용4_P2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Q1
		int[] a = { 10, 20, 30, 40, 50 };
		int[] b = { 0, 0, 0, 0, 0 };

		System.out.println("숫자를 입력하세요 : ");
		int myNum = sc.nextInt();
		int temp = 0;

		for (int i = 0; i < 5; i++) {
			if (myNum != a[i]) {
				b[temp] = a[i];
				temp++;
			}
		}
		for (int i = 0; i < 5; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();
		//Q2
		int[] c = { 1001, 40, 1002, 65, 1003, 70 };
		int[] d = { 0, 0, 0, 0, 0, 0 };
		System.out.println("학번 입력:");
		myNum = sc.nextInt();
		int size = c.length;
		temp = 0;
		for (int i = 0; i < size; i += 2) {
			if (myNum != c[i]) {
				d[temp] = c[i];
				d[temp + 1] = c[i + 1];
				temp += 2;
			}
		}
		for (int i = 0; i < size; i++) {
			System.out.print(d[i] + " ");
		}

		sc.close();
	}
}

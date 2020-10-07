package Day018_P;

import java.util.Scanner;

public class Day01802배열응용4_P1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Q1
		int[] a = { 10, 20, 30, 40, 50 };
		int[] b = { 0, 0, 0, 0, 0 };

		System.out.println("수를 입력하세요 : ");
		int myNum = sc.nextInt();
		int a_size = a.length;
		int index = 0;
		for (int i = 0; i < a_size; i++) {
			if (myNum != a[i]) {
				b[index] = a[i];
				index++;
			}
		}
		for (int i = 0; i < a_size; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();
		//Q2
		int[] c = { 1001, 40, 1002, 65, 1003, 70 };
		int[] d = { 0, 0, 0, 0, 0, 0 };
		index = 0;
		myNum = 1002;
		int c_size = c.length;
		for (int i = 0; i < c_size; i += 2) {
			if (myNum != c[i]) {
				d[index] = c[i];
				d[index + 1] = c[i + 1];
				index += 2;
			}
		}
		for (int i = 0; i < c_size; i++) {
			System.out.print(d[i] + " ");
		}
		sc.close();
	}
}

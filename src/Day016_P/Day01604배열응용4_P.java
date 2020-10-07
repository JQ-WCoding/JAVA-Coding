package Day016_P;

import java.util.Scanner;

public class Day01604배열응용4_P {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = { 10, 20, 30, 40, 50 };
		int[] b = { 0, 0, 0, 0, 0 };
		//Q1
		System.out.println("값을 입력하세요 : ");
		int myNum = sc.nextInt();

		int idx = 0;
		for (int i = 0; i < 5; i++) {
			if (myNum == a[i]) {
				idx = i;
			}
		}
		System.out.println("numIdx : " + idx);
		int bIdx = 0;
		for (int i = 0; i < 5; i++) {
			if (i != idx) {
				b[bIdx] = a[i];
				bIdx++;
			}
		}
		for (int i = 0; i < 5; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();
		
		//Q2
		int[] c = { 1001, 40, 1002, 65, 1003, 70 };
		int[] d = { 0, 0, 0, 0, 0, 0 };
		System.out.println("학번을 입력하세요 : ");
		myNum = sc.nextInt();
		int size = c.length;
		idx = 0;
		for (int i = 0; i < size; i += 2) {
			if (myNum != c[i]) {
				d[idx] = c[i];
				d[idx + 1] = c[i + 1];
				idx += 2;
			}
		}
		for (int i = 0; i < size; i++) {
			System.out.print(d[i] + " ");
		}
		sc.close();
	}
}

package Day016_P;

import java.util.Scanner;

public class Day01604배열응용4_P {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = { 10, 20, 30, 40, 50 };
		int[] b = { 0, 0, 0, 0, 0 };

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
		sc.close();
	}
}

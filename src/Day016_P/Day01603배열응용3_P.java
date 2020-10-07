package Day016_P;

public class Day01603배열응용3_P {
	public static void main(String[] args) {
		int[] a = { 10, 20, 30, 40, 50 };
		int[] b = { 13, 54, 17, 42, 1 };
		int[] c = { 0, 0, 0, 0, 0 };

		//Q1
		int cIndex = 0;
		for (int i = 0; i < 5; i++) {
			if ((a[i] + b[i]) % 2 == 0) {
				c[cIndex] = a[i] + b[i];
				cIndex++;
			}
		}
		for (int i = 0; i < 5; i++) {
			System.out.print(c[i] + " ");
		}
		System.out.println();
		//Q2
		int[] num = { 1001, 1002, 1003 };
		int[] score = { 50, 83, 78 };
		int[] win = new int[3];

		int winIndex = 0;
		for (int i = 0; i < 3; i++) {
			if (score[i] >= 60) {
				win[winIndex] = num[i];
				winIndex++;
			}
		}
		for (int i = 0; i < 3; i++) {
			System.out.print(win[i] + " ");
		}
		System.out.println();

		//Q3
		int[] info = { 1001, 80, 1002, 23, 1003, 78 };
		int[] win2 = { 0, 0, 0 };

		int win2Index = 0;
		for (int i = 0; i < 6; i++) {
			if (i % 2 == 1) {
				if (info[i] >= 60) {
					win2[win2Index] = info[i - 1];
					win2Index++;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			System.out.print(win2[i] + " ");
		}
	}
}

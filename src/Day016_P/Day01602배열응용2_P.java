package Day016_P;

import java.util.Scanner;

public class Day01602배열응용2_P {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Q1
		int[] a = { 10, 20, 30, 40, 50 };
		System.out.println("인덱스를 입력하세요 : ");
		int num = sc.nextInt();
		System.out.println(a[num]);

		//Q2
		int b[] = { 12, 54, 23, 87, 1 };
		int count = 0;

		for (int i = 0; i < 5; i++) {
			if (b[i] % 2 == 1) {
				count++;
			}
		}
		System.out.println("홀수의 개수 : " + count + "개");

		//Q3
		int[] c = { 12, 54, 23, 87, 1 };
		int maxNum = 0;
		for (int i = 0; i < 5; i++) {
			if (maxNum < c[i]) {
				maxNum = c[i];
			}
		}
		System.out.println("가장 큰 값 : " + maxNum);

		//Q4
		int[] d = { 1, 2, 3, 4, 5 };
		int[] e = new int[5];
		int dIndex = 4;
		for (int i = 0; i < 5; i++) {
				e[i] = d[dIndex];
				dIndex--;
		}
		for (int i = 0; i < 5; i++) {
			System.out.print(e[i] + " ");
		}
		sc.close();
	}
}

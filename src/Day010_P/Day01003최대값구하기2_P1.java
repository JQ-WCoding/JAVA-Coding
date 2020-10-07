package Day010_P;

import java.util.Scanner;

public class Day01003최대값구하기2_P1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int myNum = 0;
		int maxNum = 0;
		for (int i = 0; i < 3; i++) {
			System.out.println((i + 1) + "번째 수를 입력하세요 : ");
			myNum = sc.nextInt();
			if (maxNum < myNum) {
				maxNum = myNum;
			}
		}
		System.out.println("[" + maxNum + "] 가장 크다");
		sc.close();
	}
}

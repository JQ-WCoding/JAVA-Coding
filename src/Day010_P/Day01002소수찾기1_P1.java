package Day010_P;

import java.util.Scanner;

public class Day01002소수찾기1_P1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int count = 0;
		System.out.println("숫자를 입력하세요 : ");
		int num = sc.nextInt();
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				count++;
			}
		}
		if (count == 2) {
			System.out.println(num + "은 소수이다.");
		}
		else {
			System.out.println(num + "은 소수가 아니다.");
		}
		sc.close();
	}
}

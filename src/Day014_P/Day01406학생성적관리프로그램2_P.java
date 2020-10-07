package Day014_P;

import java.util.Scanner;

public class Day01406학생성적관리프로그램2_P {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = { 87, 11, 45, 98, 23 };

		//Q1
		System.out.println("번호를 입력하세요  :");
		int index = sc.nextInt();

		System.out.println("성적 : " + arr[index]);

		//Q2
		System.out.println("성적을 입력하세요 : ");
		int score = sc.nextInt();
		for (int i = 0; i < 5; i++) {
			if (score == arr[i]) {
				System.out.println("인덱스 : " + i);
			}
		}

		//Q3
		int[] hakbuns = { 1001, 1002, 1003, 1004, 1005 };
		int[] scores = { 87, 11, 45, 98, 23 };

		System.out.println("학번을 입력하세요 : ");
		int num = sc.nextInt();

		for (int i = 0; i < 5; i++) {
			if (hakbuns[i] == num) {
				System.out.println(scores[i]);
			}
		}
		sc.close();
	}
}

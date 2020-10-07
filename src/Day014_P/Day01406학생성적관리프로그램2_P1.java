package Day014_P;

import java.util.Scanner;

public class Day01406학생성적관리프로그램2_P1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = { 87, 11, 45, 98, 23 };

		//Q1
		int index = 0;
		System.out.println("번호를 입력하세요 : ");
		index = sc.nextInt();
		System.out.println(arr[index]);

		//Q2
		int score = 0;
		System.out.println("성적을 입력하세요 : ");
		score = sc.nextInt();
		for (int i = 0; i < 5; i++) {
			if (score == arr[i]) {
				System.out.println("인덱스 : " + i);
			}
		}

		//Q3
		int[] hakbuns = { 1001, 1002, 1003, 1004, 1005 };
		int[] scores = { 87, 11, 45, 98, 23 };
		System.out.println("학번을 입력하세요 : ");
		int myHakbun = sc.nextInt();

		for (int i = 0; i < 5; i++) {
			if (myHakbun == hakbuns[i]) {
				System.out.println(scores[i]);
			}
		}
		sc.close();
	}
}

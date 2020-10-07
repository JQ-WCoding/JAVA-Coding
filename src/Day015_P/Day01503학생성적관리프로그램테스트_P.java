package Day015_P;

import java.util.Scanner;

public class Day01503학생성적관리프로그램테스트_P {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] hakbuns = { 1001, 1002, 1003, 1004, 1005 };
		int[] scores = { 87, 11, 45, 98, 23 };

		//Q1
		int count = 0;

		for (int i = 0; i < 5; i++) {
			if (scores[i] >= 60) {
				count++;
			}
		}
		System.out.println("합격생 수 : " + count + "명");

		//Q2
		System.out.println("학번을 입력하세요 :");
		int myNum = sc.nextInt();

		int check = -1;
		for (int i = 0; i < 5; i++) {
			if (hakbuns[i] == myNum) {
				check = i;
			}
		}
		if (check != -1) {
			System.out.println("성적 : " + scores[check]);
		} else {
			System.out.println("없는 학번입니다.");
		}

		//Q3
		int maxScore = 0;
		int index = 0;
		for (int i = 0; i < 5; i++) {
			if (scores[i] > maxScore) {
				maxScore = scores[i];
				index = i;
			}
		}
		System.out.println("1등 학생 학번 : " + hakbuns[index] + " / 성적 : " + scores[index] + "점");
		sc.close();
	}
}

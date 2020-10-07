package Day017_P;

import java.util.Random;
import java.util.Scanner;

public class Day017test_P {
	public static void main(String[] args) {
		Random rn = new Random();
		Scanner sc = new Scanner(System.in);

		//Q1
		System.out.println("문제1)");
		int comNum = rn.nextInt(10) + 1;
		int myNum = 0;
		for (int i = 0; i < 5; i++) {
			System.out.println("예상 번호를 입력하세요 :");
			myNum = sc.nextInt();
			if (myNum == comNum) {
				System.out.println("Bingo!");
				i = 5;
			} else if (myNum > comNum) {
				System.out.println("Down");
			} else if (myNum < comNum) {
				System.out.println("Up");
			}
		}
		System.out.println("게임 완료!");

		//Q2
		System.out.println("문제2)");
		int[] arr = { 87, 100, 23, 56, 10 };
		int[] temp = new int[5];
		int size = arr.length;
		int index = 0;
		for (int i = size - 1; i >= 0; i--) {
			if (arr[i] % 2 == 0) {
				temp[index] = arr[i];
				index++;
			}
		}
		for (int i = 0; i < size; i++) {
			System.out.print(temp[i] + " ");
		}
		System.out.println();
		//Q3
		System.out.println("문제3)");
		int[] hakbun = { 1001, 1002, 1003, 1004, 1005 };
		int[] score = new int[5];
		size = score.length;
		
		//1등 꼴등 변
		int firstHakbun = 0;
		int firstScore = 0;
		int lastHakbun = 0;
		int lastScore = 100;
		
		for (int i = 0; i < size; i++) {
			score[i] = rn.nextInt(100) + 1;
		}
		index = 0;
		boolean run = true;
		while (run) {
			System.out.println("[학생성적관리 프로그램]");
			System.out.println("[1] 성적확인");
			System.out.println("[2] 평균확인");
			System.out.println("[3] 1등확인");
			System.out.println("[4] 꼴등확인");
			System.out.println("[0] 종료");

			int select = sc.nextInt();

			if (select == 1) {
				System.out.println("학번을 입력하세요 : ");
				int myHakbun = sc.nextInt();
				int indexHakbun = 0;
				for (int i = 0; i < size; i++) {
					if (myHakbun == hakbun[i]) {
						index = i;
						indexHakbun = hakbun[i];
					}
				}
				if (myHakbun == indexHakbun) {
					System.out.println("학번 : " + myHakbun + " / 성적 : " + score[index]);
				} else {
					System.out.println("잘못입력하였습니다.");
				}
			} else if (select == 2) {
				int total = 0;
				for (int i = 0; i < size; i++) {
					total += score[i];
				}
				double avg = total / (double) size;
				System.out.println("평균 : " + avg + "점");
			} else if (select == 3) {
				for (int i = 0; i < size; i++) {
					if (firstScore < score[i]) {
						firstScore = score[i];
						firstHakbun = hakbun[i];
					}
				}
				System.out.println("1등 : " + firstHakbun + " / 성적 : " + firstScore + "점");
			} else if (select == 4) {
				for (int i = 0; i < size; i++) {
					if(lastScore > score[i]) {
						lastScore = score[i];
						lastHakbun = hakbun[i];
					}
				}
				System.out.println("꼴등 : " + lastHakbun + " / 성적 : " + lastScore + "점");
			} else if (select == 0) {
				System.out.println("[메세지]프로그램을 종료합니다.");
				run = false;
			}
		}
		sc.close();
	}
}

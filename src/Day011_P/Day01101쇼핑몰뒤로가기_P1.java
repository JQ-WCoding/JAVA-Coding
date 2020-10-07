package Day011_P;

import java.util.Scanner;

public class Day01101쇼핑몰뒤로가기_P1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;


		int choice = 0;
		int manualChoice = 0;
		while (run) {
			boolean manualRun = true;
			System.out.println("1. 남성의류");
			System.out.println("2. 여성의류");
			System.out.println("0. 종료");

			choice = sc.nextInt();

			if (choice == 1) {
				while (manualRun) {
					System.out.println("1) 티셔츠");
					System.out.println("2) 바지");
					System.out.println("3) 뒤로가기");
					manualChoice = sc.nextInt();
					if (manualChoice == 3) {
						manualRun = false;
					}
				}
			} else if (choice == 2) {
				while (manualRun) {
					System.out.println("1) 가디건");
					System.out.println("2) 치마");
					System.out.println("3) 뒤로가기");
					manualChoice = sc.nextInt();
					if (manualChoice == 3) {
						manualRun = false;
					}
				}
			} else if (choice == 0) {
				run = false;
			}
		}
		sc.close();
	}
}

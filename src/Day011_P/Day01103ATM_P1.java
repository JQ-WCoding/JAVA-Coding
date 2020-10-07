package Day011_P;

import java.util.Scanner;

public class Day01103ATM_P1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int dbID = 1111;
		int dbPW = 1234;
		int choice = 0;
		boolean run = true;
		int check = -1;

		while (run) {
			System.out.println("1. 로그인");
			System.out.println("2. 로그아웃");
			System.out.println("0. 종료");
			choice = sc.nextInt();

			if (choice == 1) {
				if (check == -1) {
					System.out.println("아이디를 입력하세요 : ");
					int myID = sc.nextInt();

					if (myID == dbID) {
						System.out.println("비밀번호를 입력하세요 : ");
						int myPW = sc.nextInt();
						if (myPW == dbPW) {
							System.out.println("로그인 성공");
							check = 1;
						} else {
							System.out.println("비밀번호를 확인해주세요");
						}
					} else {
						System.out.println("아이디를 확인해주세요");
					}
				} else {
					if (check == 1) {
						System.out.println("회원이 로그인중입니다.");
					}
				}
			} else if (choice == 2) {
				if (check != -1) {
					System.out.println("로그아웃");
					check = -1;
				} else {
					System.out.println("로그인이 필요합니다.");
				}
			} else if (choice == 0) {
				System.out.println("프로그램 종료");
				run = false;
			}
		}
		sc.close();
	}
}

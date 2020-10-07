package Day012_P;

import java.util.Scanner;

public class Day01201ATM4_P1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int myMoney = 10000;
		int yourAcc = 2222;
		int yourAccMoney = 20000;
		int money = 0;
		int dbID = 1111;
		int dbPW = 1234;

		int check = -1;
		int choice = 0;
		int menuChoice = 0;
		boolean run = true;
		while (run) {
			System.out.println("1. 로그인");
			System.out.println("2. 로그아웃");
			System.out.println("0. 종료");
			choice = sc.nextInt();
			if (choice == 1) {
				if (check == -1) {
					System.out.println("ID를 입력하세요 :");
					int myID = sc.nextInt();
					if (myID == dbID) {
						System.out.println("PW를 입력하세요 :");
						int myPW = sc.nextInt();
						if (myPW == dbPW) {
							System.out.println("로그인 되었습니다");
							check = 1;
							boolean menuRun = true;
							while (menuRun) {
								System.out.println("1) 입금");
								System.out.println("2) 출금");
								System.out.println("3) 계좌이체");
								System.out.println("4) 계좌조회");
								System.out.println("0) 메인 메뉴로");

								menuChoice = sc.nextInt();
								if (menuChoice == 1) {
									System.out.println("입금할 금액을 입력하세요 : ");
									money = sc.nextInt();
									myMoney += money;
									System.out.println("현재 잔액 : " + myMoney + "원");
								} else if (menuChoice == 2) {
									System.out.println("출금할 금액을 입력하세요 : ");
									money = sc.nextInt();
									if (myMoney < money) {
										System.out.println("잔액이 부족합니다");
									} else {
										System.out.println("출금되었습니다");
										myMoney -= money;
										System.out.println("현재 나의 잔액 :" + myMoney + "원");
									}
								} else if (menuChoice == 3) {
									boolean inMenuRun = true;
									while (inMenuRun) {
										System.out.println("이체할 계좌번호를 입력하세요 : ");
										int checkYourAcc = sc.nextInt();
										if (checkYourAcc == yourAcc) {
											System.out.println("이체할 금액을 입력하세요 : ");
											money = sc.nextInt();
											if (myMoney < money) {
												System.out.println("잔액이 부족합니다");
												inMenuRun = false;
											} else {
												myMoney -= money;
												yourAccMoney += money;
												System.out.println("이체되었습니다");
												System.out.println("현재 나의 잔액 : " + myMoney + "원");
												System.out.println("현재 다른 잔액 : " + yourAccMoney + "원");
												inMenuRun = false;
											}
										} else {
											System.out.println("계좌번호를 확인해주세요");
										}
									}
								} else if (menuChoice == 4) {
									System.out.println("현재 나의 잔액 :" + myMoney + "원");
									System.out.println("현재 다른 잔액 :" + yourAccMoney + "원");
								} else if (menuChoice == 0) {
									menuRun = false;
								}
							}
						} else {
							System.out.println("PW를 확인해주세요");
						}
					} else {
						System.out.println("ID를 확인해주세요");
					}
				}
				else if(check != -1) {
					System.out.println("로그인 중...");
				}
			} else if (choice == 2) {
				if (check != -1) {
					System.out.println("로그아웃");
					check = -1;
				} else {
					System.out.println("로그아웃이 필요한 서비스입니다");
				}
			} else if (choice == 0) {
				System.out.println("프로그램 종료");
				run = false;
			}
		}

		sc.close();
	}
}

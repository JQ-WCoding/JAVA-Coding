package Day006_P;

import java.util.Scanner;

public class Day00608ATM1_P2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int myAcc = 1234;
		int myMoney = 8700;
		int yourAcc = 4321;
		int yourMoney = 12000;


		boolean run = true;
		while (run) {
			System.out.println("계좌번호를 입력하세요 : ");
			int myCheckAcc = sc.nextInt();
			if (myAcc == myCheckAcc) {
				System.out.println("이체할 계좌번호를 입력하세요 : ");
				int yourCheckAcc = sc.nextInt();
				if (yourCheckAcc == yourAcc) {
					System.out.println("이체할 금액을 입력하세요 : ");
					int myCheckMoney = sc.nextInt();
					if (myMoney >= myCheckMoney) {
						yourMoney = yourMoney + myMoney;
						System.out.println("이체된 금액 : " + myCheckMoney + "원");
						System.out.println("이체된 계좌 잔액 : " + yourMoney + "원");
						run = false;
					} else {
						System.out.println("잔액이 부족합니다");
					}
				}
				else {
					System.out.println("이체할 계좌를 확인해주세요.");
				}
			} else {
				System.out.println("잘못입력하였습니다.");
			}
		}
		sc.close();
	}
}

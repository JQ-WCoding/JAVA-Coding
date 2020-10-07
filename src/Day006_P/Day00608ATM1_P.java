package Day006_P;

import java.util.Scanner;

public class Day00608ATM1_P {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int myAcc = 1234;
		int myMoney = 8700;
		
		int yourAcc = 4321;
		int yourMoney = 12000;
		
		System.out.println("본인 계좌를 입력하세요 : ");
		int checkMyAcc = scan.nextInt();
		
		if(myAcc == checkMyAcc) {
			System.out.println("이체할 계좌번호를 입력하세요 : ");
			int pickAcc = scan.nextInt();
			
			if(pickAcc == yourAcc) {
				System.out.println("입금할 금액을 입력하세요 : ");
				int pickMoney = scan.nextInt();
				if(pickMoney <= myMoney) {
					myMoney = myMoney - pickMoney;
					yourMoney = yourMoney + pickMoney;
					System.out.println("입금 후 잔액 : " + myMoney);
					System.out.println("입금 후 상대 통장 잔액 : " + yourMoney);
				}
				else {
					System.out.println("잔액이 부족합니다.");
				}
			}
			else {
				System.out.println("계좌번호를 확인해주세요");
			}
		}
		else {
			System.out.println("본인 계좌 기입 오류입니다.");
		}
		scan.close();
	}
}

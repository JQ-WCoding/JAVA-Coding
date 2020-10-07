package Day006_P;

import java.util.Scanner;
/*
 * 이준규
 * ATM문제 정답 제출용
 */
public class Day00608ATM1_P1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int myAcc = 1234;
		int myMoney = 15000;
		
		int yrAcc = 4321;
		int yrMoney = 20000;
		
		System.out.println("본인 계좌를 입력하세요 : ");
		int checkMyAcc = scan.nextInt();
		
		if(myAcc == checkMyAcc) {
			System.out.println("이체할 계좌번호를 입력하세요 : ");
			int checkYrAcc = scan.nextInt();
			
			if(yrAcc == checkYrAcc) {
				System.out.println("이체할 금액을 입력하세요 : ");
				int transMoney = scan.nextInt();
				if(transMoney <= myMoney) {
				myMoney = myMoney - transMoney;
				yrMoney = yrMoney + transMoney;
				System.out.println("이체 후 나의 계좌 잔액 : " + myMoney);
				System.out.println("이체 후 상대의 계좌 잔액 : " + yrMoney);
				}
				else {
					System.out.println("잔액이 부족합니다.");
				}
			}
			else {
				System.out.println("이체할 계좌번호를 다시 확인해주세요.");
			}
		}
		else {
			System.out.println("계좌를 다시 확인해주세요.");
		}
		scan.close();
	}
}

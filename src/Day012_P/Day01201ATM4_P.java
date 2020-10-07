package Day012_P;

import java.util.Scanner;

public class Day01201ATM4_P {
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	
//	int myAcc = 1111;
	int myMoney = 50000;
	
	int yourAcc = 2222;
	int yourMoney = 70000;	
	
		boolean run = true;
		while(run) {
		
			System.out.println("1. 입금");
			System.out.println("2. 출금");
			System.out.println("3. 이체");
			System.out.println("4. 조회");
			System.out.println("0. 종료");
		
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			if(sel == 1) {
				System.out.print("입금 금액 입력 : ");
				int money = scan.nextInt();
				myMoney = myMoney + money;
				System.out.println("입금 완료");
			}
			else if(sel == 2) {
				System.out.print("출금 금액 입력 : ");
				int money = scan.nextInt();
				if(money <= myMoney) {
					myMoney = myMoney - money;
					System.out.println("출금 완료.");
				}
				else {
					System.out.println("계좌잔액 부족");
				}
			}
			else if(sel == 3) {
				System.out.print("이체 계좌번호 입력 : ");
				int acc = scan.nextInt();
			
				if(acc == yourAcc) {
					System.out.print("이체 금액 입력 : ");
					int money = scan.nextInt();
					if(money <= myMoney) {
						myMoney = myMoney - money;
						yourMoney = yourMoney + money;
						System.out.println("이체 완료");
					}
					else {
						System.out.println("계좌잔액 부족");
					}
				}
				else {
					System.out.println("계좌번호 확인");
				}
			}
			else if(sel == 4) {
				System.out.println("myMoney = " + myMoney + "원");
				System.out.println("yourMoney = " + yourMoney + "원");
			}
			else if(sel == 0) {
				run = false;
				System.out.println("프로그램 종료");
			}
		}
		scan.close();
	}
}

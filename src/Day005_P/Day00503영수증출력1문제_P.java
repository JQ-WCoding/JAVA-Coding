package Day005_P;

import java.util.Scanner;

public class Day00503영수증출력1문제_P {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int price1 = 3700;
		int price2 = 4200;
		int price3 = 3200;
		
		System.out.println("=McDonald=");
		System.out.println("(1) 불고기 버거 : " + price1 + "원");
		System.out.println("(2) 상하이 스파이시 버거 : " + price2 + "원");
		System.out.println("(3) 치즈버거 : " + price3 + "원");

		
		System.out.println("메뉴를 입력하세요 : ");
		int myMenu = scan.nextInt();
		
		if(myMenu > 3 || myMenu < 1) {
			System.out.println("기입 오류!");
			}
		
		if(myMenu == 3 || myMenu == 2 || myMenu == 1) {
			System.out.println("현금을 입력하세요 : ");
			int myMoney = scan.nextInt();
			int change = 0;
			
			if(myMenu == 1) {
				change = myMoney - price1;
			}
			if(myMenu == 2) {
				change = myMoney - price2;
			}
			if(myMenu == 3) {
				change = myMoney - price3;
			}
			if(change >= 0) {
				System.out.println("잔돈 : " + change + "원");
			}
			if(change < 0) {
				System.out.println("현금이 부족합니다.");
				
			}
		}
	scan.close();
	}
}

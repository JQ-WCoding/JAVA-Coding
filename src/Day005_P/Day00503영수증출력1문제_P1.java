package Day005_P;

import java.util.Scanner;

public class Day00503영수증출력1문제_P1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("===McDonald===");
		int price1 = 3200;
		int price2 = 4400;
		int price3 = 5300;
		System.out.println("(1) 불고기버거 : " + price1 + "원");
		System.out.println("(2) 치즈버거 : " + price2 + "원");
		System.out.println("(3) 상하이버거 : " + price3 + "원");
		
		System.out.println("메뉴를 선택하세요 : ");
		int choice = scan.nextInt();
		System.out.println("현금을 넣어주세요 : ");
		int money = scan.nextInt();
		
		int change = 0;
		if(choice == 1) {
			change = money - price1;
		}
		if(choice == 2) {
			change = money - price2;
		}
		if(choice == 3) {
			change = money - price3;
		}
		if(choice > 3 || choice < 1) {
			System.out.println("메뉴를 다시 선택해주세요.");
		}
		if(change >= 0) {
			System.out.println("잔돈은 : " + change + "원");
		}
		if(change < 0) {
			System.out.println("현금이 부족합니다.");
		}
		scan.close();	
	}
}

package Day008_P;

import java.util.Scanner;

public class Day00806영수증출력2_P1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("==McDonald==");
		System.out.println("1) 불고기 버거 : 3200원");
		System.out.println("2) 치즈 버거 : 4500원");
		System.out.println("3) 상하이 버거 : 5700원");

		int total = 0;
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;

		for (int i = 0; i < 5; i++) {
			System.out.println((i + 1) + "번 메뉴를 선택하세요 : ");
			int myMenu = sc.nextInt();
			if (myMenu == 1) {
				total += 3200;
				count1++;
			} else if (myMenu == 2) {
				total += 4500;
				count2++;
			} else if (myMenu == 3) {
				total += 5700;
				count3++;
			}
		}
		System.out.println("총 금액 : " + total + "원");
		System.out.println("현금을 넣어주세요 : ");
		int myMoney = sc.nextInt();

		if (total <= myMoney) {
			System.out.println("==McDonald 영수증==");
			System.out.println("1) 불고기 버거 : " + count1 + "개");
			System.out.println("2) 치즈 버거 : " + count2 + "개");
			System.out.println("3) 상하이 버거 : " + count3 + "개");
			System.out.println("총 금액 : " + total + "원");
			System.out.println("잔돈 : " + (myMoney - total) + "원");
		} else {
			System.out.println("금액이 부족합니다");
		}
		sc.close();
	}
}

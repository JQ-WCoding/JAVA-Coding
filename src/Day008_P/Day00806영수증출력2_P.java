package Day008_P;
// 9m 49s
import java.util.Scanner;

public class Day00806영수증출력2_P {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		// 메뉴판 출력
		int price1 = 3500; // 불고기 버거
		int price2 = 4200; // 상하이 버거
		int price3 = 6500; // 시그니처 버거
		System.out.println("=== McDonald ===");
		System.out.println("[1] 불고기 버거 : " + price1 + "원");
		System.out.println("[2] 상하이 버거 : " + price2 + "원");
		System.out.println("[3] 시그니처 버거 : " + price3 + "원");
		
		int i = 1;
		// 5번 주문
		while(i <= 5) {
			System.out.println("("+ i + ")메뉴를 입력하세요 : ");
			int choice = scan.nextInt();
			if(choice == 1) {
				count1++;
			}
			else if(choice == 2) {
				count2++;
			}
			else if(choice == 3) {
				count3++;
			}
			i++;
		}
		// 총금액 계산 및 출력
		int total = price1 * count1 + price2 * count2 + price3 * count3;
		System.out.println("총 금액 : " + total + "원");
		// 현금 입력
		System.out.println("현금을 입력하세요 : ");
		int cash = scan.nextInt();
		// 영수증 출력 전 거래가능 여부 확인
		int change = cash - total;
		if(change >= 0) {
			System.out.println("=== McDonald ===");
			System.out.println("[1] 불고기 버거 : " + count1 + "개");
			System.out.println("[2] 상하이 버거 : " + count2 + "개");
			System.out.println("[3] 시그니처 버거 : " + count3 + "개");
			System.out.println("총 금액 : " + total + "원");
			System.out.println("잔돈 : " + change + "원");
		}
		else {
			System.out.println("현금이 부족합니다.");
		}
		scan.close();
	}
}

package Day005_P;

import java.util.Scanner;

public class Day00501조건문복습_P {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int bookReturnDate = 9;
		System.out.println("오늘은 몇일입니까?");
		int today = scan.nextInt();
		if(today >= bookReturnDate) {
			if(today <= 31) {
				System.out.println("반납 연체입니다.");
			}
			if(today > 31) {
				System.out.println("존재하지 않는 일입니다.");
			}
		}
		if(today < bookReturnDate) {
			if(today >= 1) {
				System.out.println("정상 반납되었습니다");
			}
			if(today < 0) {
				System.out.println("존재하지 않는 일입니다.");
			}
		}
		scan.close();
	}
}

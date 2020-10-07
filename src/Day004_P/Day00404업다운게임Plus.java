package Day004_P;

import java.util.Scanner;

public class Day00404업다운게임Plus {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int com = 8;
		
		System.out.println("첫 예상 숫자는?");
		
		for(int me = scan.nextInt(); me != com; me = scan.nextInt()) {
			if(me < com) { 
				System.out.println("Up!"); 
			}
			if(me > com) {
				System.out.println("Down!");
			}
			System.out.println("숫자를 입력하세요 : ");
		}
	System.out.println("Bingo!");
	scan.close();
	}
}

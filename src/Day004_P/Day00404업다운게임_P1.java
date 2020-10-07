package Day004_P;

import java.util.Scanner;

public class Day00404업다운게임_P1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int com = 8;
		System.out.println("숫자를 입력하세요 :");
		int me = sc.nextInt();
		
		if(com == me) {
			System.out.println("Bingo!");
		}
		else if(com > me) {
			System.out.println("Up!");
		}
		else if(com < me) {
			System.out.println("Down!");
		}
		sc.close();
	}
}

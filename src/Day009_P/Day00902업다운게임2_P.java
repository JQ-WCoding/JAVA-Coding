package Day009_P;

import java.util.Random;
import java.util.Scanner;

public class Day00902업다운게임2_P {
	public static void main(String[] args) {
		Random rn = new Random();
		Scanner sc = new Scanner(System.in);
		
		int com = rn.nextInt(100) + 1;
		//CheatKey
		System.out.println(com + " / cheatkey");

		int run = 1;
		while(run == 1) {
			System.out.println("1 ~ 100 예상 숫자를 작성하세요 : ");
			int me = sc.nextInt();
			
			if(me == com) {
				System.out.println("Bingo!");
				run = 0;
			}
			else if(me < com) {
				System.out.println("Up");
			}
			else if(me > com) {
				System.out.println("Down");
			}
		}
		sc.close();
	}
}

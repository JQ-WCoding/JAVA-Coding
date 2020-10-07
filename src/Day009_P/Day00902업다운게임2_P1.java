package Day009_P;

import java.util.Random;
import java.util.Scanner;

public class Day00902업다운게임2_P1 {
	public static void main(String[] args) {
		Random rn = new Random();
		Scanner sc = new Scanner(System.in); 
		
		int com = rn.nextInt(100) + 1;
		//CheatKey
		System.out.println("cheatkey : " + com);

		int run = 1;
		while(run == 1) {
			System.out.println("수를 입력하세요 : ");
			int me = sc.nextInt(); 
			if(com == me) {
				System.out.println("Bingo!");
				run = 0;
			}
			else if(com < me) {
				System.out.println("Down");
			}
			else if(com > me) {
				System.out.println("Up!");
			}
		}
		sc.close();
	}
}

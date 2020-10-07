package Day009_P;

import java.util.Scanner;

public class Day00905배스킨라빈스31_P {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int br = 0;
		System.out.println("===배스킨라빈스31===");
		int p1Num = 0;
		int p2Num = 0;
		boolean turn = true;
		int run = 1;
		
		while(run == 1) {
			if(turn == true) {
				System.out.println("[P1] 숫자 입력 : ");
				p1Num = sc.nextInt();
				if(p1Num >= 1 && p1Num <= 3) {
					br = br + p1Num;
					turn = false;
					System.out.println("(" + br + ")");
				}
			}
			else if(turn == false) {
				System.out.println("[P2] 숫자 입력 : ");
				p2Num = sc.nextInt();
				if(p2Num >= 1 && p2Num <= 3) {
					br = br + p2Num;
					turn = true;
					System.out.println("(" + br + ")");
				}
			}
			if(br > 31) {
				if(turn == true) {
					System.out.println("===[P1] 승리!===");
				}
				else if(turn == false) {
					System.out.println("===[P2] 승리!===");
				}
				run = 0;
			}
			else if(br == 31) {
				if(turn == true) {
					System.out.println("===[P2] 승리!===");
				}
				else if(turn == false) {
					System.out.println("===[P1] 승리!===");
				}
				run = 0;
			}
		}
		sc.close();
	}
}

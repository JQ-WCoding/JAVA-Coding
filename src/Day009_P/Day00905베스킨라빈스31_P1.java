package Day009_P;

import java.util.Scanner;

public class Day00905베스킨라빈스31_P1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

		int run = 1;
		int p1 = 0;
		int p2 = 0;
		int br = p1 + p2;
		boolean turn = true;
		while(run == 1) {
			if(turn == true) {
			System.out.println("[p1] : ");
			p1 = sc.nextInt();
			if(p1 >= 1 && p1 <= 3) {
			br = br + p1;
			turn = false;
			System.out.println("[합]" + br);
			}
			}
			else if(turn == false) {
			System.out.println("[p2] : ");
			p2 = sc.nextInt();
			if(p2 >= 1 && p2 <= 3) {
			br = br + p2;
			turn = true;
			System.out.println("[합]" + br);
			}
			}

			if(br > 31) {
				if(turn == true) {
					System.out.println("p1승리!");	
				}
				else if(turn == false) {
					System.out.println("p2승리!");
				}
				run = 0;
			}
			else if(br == 31) {
				if(turn == true) {
					System.out.println("p2승리!");	
				}
				else if(turn == false) {
					System.out.println("p1승리!");
				}
				run = 0;
		}
		}
		sc.close();
	}
}

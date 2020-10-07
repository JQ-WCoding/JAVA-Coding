package Day009_P;

import java.util.Scanner;

public class Day00905베스킨라빈스31_Plus {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

		int run = 1;
		int playerEnterNum = 0;
		int br = 0;
		
		System.out.println("플레이어를 입력하세요 : ");
		int player_num = sc.nextInt();
	
		int turn = 0;
		
		while(run == 1) {
			System.out.println("[P" + (turn % player_num + 1) + "] 입력");
			playerEnterNum = sc.nextInt();
				if(playerEnterNum >= 1 && playerEnterNum <= 3) {
					br = br + playerEnterNum;
					System.out.println("[합]" + br);
					turn ++;
					}
			if(br > 31) {
				System.out.println("P" + (turn % player_num)+ " 패배!");
				run = 0;
			}
			else if(br == 31) {
				System.out.println("P" + (turn % player_num + 1) + " 패배!");
				run = 0;
			}
		}
		sc.close();
	}
}

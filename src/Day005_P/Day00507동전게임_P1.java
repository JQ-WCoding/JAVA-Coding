package Day005_P;

import java.util.Random;
import java.util.Scanner;

public class Day00507동전게임_P1 {
	public static void main(String[] args) {
		Random ran = new Random();
		Scanner scan = new Scanner(System.in);
		int rNum = ran.nextInt(2);
		System.out.println("동전 앞면(0) / 뒷면은 (1) 이다.");
		//cheat key
		System.out.println(rNum);
		
		System.out.println("동전 앞뒷면을 맞춰보자 : ");
		int myGuess = scan.nextInt();
		
		if(rNum == myGuess) {
			System.out.println("정답!");
		}
		if(rNum != myGuess) {
			System.out.println("오답!");
		}
		scan.close();
	}
}

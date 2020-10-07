package Day005_P;

import java.util.Random;
import java.util.Scanner;

public class Day00507동전게임_P {
	public static void main(String[] args) {
		Random ran = new Random();
		Scanner scan = new Scanner(System.in);
		
		int coin = ran.nextInt(2);
		
		System.out.println("동전의 앞면(0) / 뒷면(1)을 맞춰보세요 : ");
		int myGuess = scan.nextInt();
		System.out.println("동전은 " + coin);
		
		if(coin == myGuess) {
			System.out.println("정답!");
		}
		if(coin != myGuess) {
			System.out.println("오답!");
		}
		scan.close();
	}
}

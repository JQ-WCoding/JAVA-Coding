package Day005_P;

import java.util.Random;
import java.util.Scanner;

public class Day00508홀짝게임_P1 {
	public static void main(String[] args) {
		Random ran = new Random();
		Scanner scan = new Scanner(System.in);
		
		int rNum = ran.nextInt(100) + 1;
		System.out.println(rNum + " 은 짝수일까 홀수일까?");
		
		System.out.println("짝수이면(0) / 홀수이면(1)을 입력하세요 :");
		int myGuess = scan.nextInt();
		
		if(myGuess == 0) {
			if(rNum % 2 == 0) {
				System.out.println("정답");
			}
			if(rNum % 2 == 1) {
				System.out.println("오답");
			}
		}
		if(myGuess == 1) {
			if(rNum % 2 == 0) {
				System.out.println("오답");
			}
			if(rNum % 2 == 1) {
				System.out.println("정답");
			}
		}
		scan.close();
	}
}

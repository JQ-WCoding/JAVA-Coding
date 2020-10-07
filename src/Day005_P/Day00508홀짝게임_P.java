package Day005_P;

import java.util.Random;
import java.util.Scanner;

public class Day00508홀짝게임_P {
	public static void main(String[] args) {
		Random ran = new Random();
		Scanner scan = new Scanner(System.in);
		
		int guessNumber = ran.nextInt(100) + 1;
		System.out.println(guessNumber + "는 짝수일까 홀수일까");
		
		System.out.println("짝수이면 0, 홀수이면 1을 입력하세요 : ");
		int myCheck = scan.nextInt();
		
		if(myCheck == 0) {
			if(guessNumber % 2 == 0) {
				System.out.println("정답");
			}
			if(guessNumber % 2 == 1) {
				System.out.println("오답");
			}
		}
		if(myCheck == 1) {
			if(guessNumber % 2 == 1) {
				System.out.println("정답");
			}
			if(guessNumber % 2 == 0) {
				System.out.println("오답");
			}
		}
		scan.close();
	}
}

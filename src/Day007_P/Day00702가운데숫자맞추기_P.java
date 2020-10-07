package Day007_P;

import java.util.Random;
import java.util.Scanner;

public class Day00702가운데숫자맞추기_P {
	public static void main(String[] args) {
		Random ran = new Random();
		Scanner scan = new Scanner(System.in);

		int rNum = ran.nextInt(101) + 150;
		int answer = rNum % 100 / 10;	
		System.out.println("문제 [" + rNum + "]의 가운데 숫자 : ");

		
		int myAnswer = scan.nextInt();
		
		if(answer == myAnswer) {
			System.out.println("정답!");
		}
		else if(answer != myAnswer) {
			System.out.println("오답!");
		}
		scan.close();
	}
}

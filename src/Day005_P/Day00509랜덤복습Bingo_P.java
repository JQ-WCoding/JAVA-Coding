package Day005_P;

import java.util.Random;
import java.util.Scanner;

public class Day00509랜덤복습Bingo_P {
	public static void main(String[] args) {
		Random ran = new Random();
		Scanner scan = new Scanner(System.in);
		
		int comNum = ran.nextInt(10) + 1;
		System.out.println("예상숫자를 작성하세요 : ");
		
		for(int myNum = scan.nextInt(); comNum != myNum; myNum = scan.nextInt()) {
			System.out.println("다시 적어주세요 : ");
			if(comNum < myNum) {
				System.out.println("Down");
			}
			if(comNum > myNum) {
				System.out.println("Up");
			}
		}
		System.out.println("Bingo!");
		scan.close();
	}
}

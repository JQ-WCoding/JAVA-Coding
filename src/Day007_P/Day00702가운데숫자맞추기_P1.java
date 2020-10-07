package Day007_P;

import java.util.Random;
import java.util.Scanner;

public class Day00702가운데숫자맞추기_P1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rn = new Random();
		
		int comNum1 = rn.nextInt(100) + 150;
		int comNum2 = rn.nextInt(100) + 150;
		double middleNum = (comNum1 + comNum2) / 2.0;
		// CheatKey
		System.out.print(comNum1 + " / ");
		System.out.println(comNum2);
		System.out.println("Cheatkey : " + middleNum);
		
		System.out.println("숫자를 입력하세요 : ");
		double myNum = sc.nextDouble();
		
		if(myNum == middleNum) {
			System.out.println("정답");
		}
		else {
			System.out.println("오답");
		}
		sc.close();
	}
}

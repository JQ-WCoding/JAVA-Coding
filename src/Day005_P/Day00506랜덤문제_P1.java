package Day005_P;

import java.util.Random;

public class Day00506랜덤문제_P1 {
	public static void main(String[] args) {
		Random ran = new Random();
		
		int rNum = ran.nextInt(5) + 1;
		System.out.println(rNum);
		
		int rNum2 = ran.nextInt(7) - 3;
		System.out.println(rNum2);
	}
}

package Day007_P;

import java.util.Random;

public class Day00703_369게임_P {
	public static void main(String[] args) {
		Random ran = new Random();
		
		int rNum = ran.nextInt(50) + 1;
		System.out.println("[369Game] : " + rNum);
		int x = rNum / 10;
		int y = rNum % 10;
		
		int count = 0;
		if(x == 3 || x == 6 || x == 9) {
			count = count + 1;
		}
		if (y == 3 || y == 6 || y ==9) {
			count = count + 1;
		}
		if(count == 0) {
			System.out.println(rNum);
		}
		else if(count == 1) {
			System.out.println("짝");
		}
		else if(count == 2) {
			System.out.println("짝짝");
		}
	}
}

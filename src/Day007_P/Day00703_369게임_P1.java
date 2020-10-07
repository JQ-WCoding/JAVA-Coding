package Day007_P;

import java.util.Random;

public class Day00703_369게임_P1 {
	public static void main(String[] args) {
		Random rn = new Random();

		int comNum = rn.nextInt(50) + 1;

		int count = 0;
		System.out.println(comNum);
		if (comNum / 10 == 3 || comNum / 10 == 6 || comNum / 10 == 9) {
			count++;
		}
		if (comNum % 10 == 3 || comNum % 10 == 6 || comNum % 10 == 9) {
			count++;
		}
		if (count == 2) {
			System.out.println("짝짝");
		} else if (count == 1) {
			System.out.println("짝");
		} else {
			System.out.println(comNum);
		}
	}
}

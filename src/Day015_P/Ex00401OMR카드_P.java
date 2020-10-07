package Day015_P;

import java.util.Random;

public class Ex00401OMR카드_P {
	public static void main(String[] args) {
		Random rn = new Random();

		int[] answer = { 1, 4, 3, 2, 5 };
		int[] hgd = new int[5];
		System.out.print("정답 : {");
		for (int i = 0; i < 5; i++) {
			System.out.print(answer[i] + ", ");
			if (i == 4) {
				System.out.print(answer[i] + " ");
			}
		}
		System.out.print("}");

		System.out.println();

		System.out.print("내답 : {");
		int count = 0;
		for (int i = 0; i < 5; i++) {

			hgd[i] = rn.nextInt(5) + 1;
			//cheatkey
			System.out.print(hgd[i] + ", ");
			if (answer[i] == hgd[i]) {
				count++;
			}
			if (i == 4) {
				System.out.print(hgd[i] + " ");
			}
		}
		System.out.print("}");
		System.out.println();
		System.out.print("정오 : {");
		String[] oX = new String[5];
		for (int i = 0; i < 5; i++) {
			if (hgd[i] == answer[i]) {
				oX[i] = "O";
			} else {
				oX[i] = "X";
			}
		}
		for (int i = 0; i < 5; i++) {
			System.out.print(oX[i] + ", ");
			if (i == 4) {
				System.out.print(oX[i] + " ");
			}
		}
		System.out.print("}");

		System.out.println();

		int score = count * 20;
		System.out.println("성적 : " + score + "점");
	}
}

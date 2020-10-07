package Day015_P;

import java.util.Random;

public class Ex00402OMR카드_P1 {
	public static void main(String[] args) {
		Random rn = new Random();

		int[] answer = new int[5];
		int hgd[] = new int[5];
		String check[] = new String[5];
		
		int count = 0;

		System.out.print("answer = {");
		for (int i = 0; i < 5; i++) {
			answer[i] = rn.nextInt(5) + 1;
			if(i != 4) {
				System.out.print(answer[i] + ", ");
			}
			else {
				System.out.print(answer[i]);
			}
		}
		System.out.println("}");
		
		System.out.print("hgd = {");
		for (int i = 0; i < 5; i++) {
			hgd[i] = rn.nextInt(5) + 1;
			if(i != 4) {
				System.out.print(hgd[i] + ", ");
			}
			else {
				System.out.print(hgd[i]);
			}
		}
		System.out.println("}");
		
		System.out.print("정오표 = {");
		for (int i = 0; i < 5; i++) {
			if (answer[i] == hgd[i]) {
				check[i] = "O";
				count++;
			}
			else {
				check[i] = "X";
			}
			if(i != 4) {
				System.out.print(check[i] + ", ");
			}
			else {
				System.out.print(check[i]);
			}
		}
		System.out.println("}");
		System.out.println("성적 : " + count * 20 + "점");
	}
}

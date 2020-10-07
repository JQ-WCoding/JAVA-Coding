package Day014_P;

import java.util.Random;

public class Day01405학생성적관리프로그램1_P1 {
	public static void main(String[] args) {
		Random rn = new Random();

		int[] arr = new int[5];

		//Q1
		int total = 0;
		int count = 0;
		for (int i = 0; i < 5; i++) {
			arr[i] = rn.nextInt(100) + 1;
			total += arr[i];
			System.out.print(arr[i] + " ");
			if (arr[i] >= 60) {
				count++;
			}
		}
		double avg = total / 5.0;
		System.out.println();
		System.out.println("총점 : " + total + "점");
		System.out.println("평균 : " + avg + "점");
		System.out.println("합격자 : " + count + "명");
	}
}

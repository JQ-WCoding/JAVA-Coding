package Day014_P;

import java.util.Random;

public class Day01405학생성적관리프로그램1_P {
	public static void main(String[] args) {
		Random rn = new Random();
		int[] arr = new int[5];

		int total = 0;
		double avg = 0;
		for (int i = 0; i < 5; i++) {
			arr[i] = rn.nextInt(100) + 1;
			total = total + arr[i];
			System.out.print(arr[i] + " ");
		}
		avg = total / 5.0;
		System.out.println();
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + avg);

		int count = 0;
		for (int i = 0; i < 5; i++) {
			if (arr[i] >= 60) {
				count++;
			}
		}
		System.out.println("합격자 수 : " + count + "명");
	}
}

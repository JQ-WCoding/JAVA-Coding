package Day010_P;

import java.util.Random;

public class Day01004랜덤학생_P1 {
	public static void main(String[] args) {
		Random rn = new Random();

		int score = 0;
		int total = 0;
		int count = 0;
		int highScore = 0;
		int highScoreMember = 0;

		for (int i = 0; i < 10; i++) {
			score = rn.nextInt(100) + 1;
			total += score;
			if (score >= 60) {
				count++;
			}
			if (highScore < score) {
				highScore = score;
				highScoreMember = i + 1;
			}
			//cheatkey
			System.out.print(score + " ");
		}
		double avg = total / 10.0;
		System.out.println();
		System.out.println("10명의 총점 : " + total + "점");
		System.out.println("평균 : " + avg + "점");
		System.out.println("합격자 수 : " + count + "명");
		System.out.println("1등 : " + highScoreMember + "번 학생");
		System.out.println("1등 점수 : " + highScore + "점");
	}
}

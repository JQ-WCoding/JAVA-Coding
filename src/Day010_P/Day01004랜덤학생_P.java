package Day010_P;

import java.util.Random;
import java.util.Scanner;

public class Day01004랜덤학생_P {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		
		System.out.println("학생 수 입력 : ");
		int run = sc.nextInt();
		
		int i = 1;
		int total = 0;
		int count = 0;
		int score = 0;
		int maxScore = 0;
		
		while(i <= run) {
			score = rd.nextInt(100) + 1;
			System.out.println("학생 (" + i + ")의 점수 : " + score + "점");
			if(maxScore < score) {
				maxScore = score;
			}
			total = total + score;
			if(score >= 60) {
				System.out.println("---합격!---");
				count += 1;
			}
			else {
				System.out.println("ㅜㅜㅜ불합격!ㅜㅜㅜ");
			}
			i++;
		}
		double avg = total / (double)run;
		System.out.println("총점 : " + total + "점");
		System.out.println("평균 : " + avg + "점");
		System.out.println("합격자 수 : " + count + "명");
		System.out.println("1등 학생의 성적 : " + maxScore + "점");
		sc.close();
	}
}

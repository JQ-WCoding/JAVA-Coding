package Day004_P;

import java.util.Scanner;

public class Day00408점수유효성검사Plus {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("점수를 입력하세요 : ");
		
		for(int score = scan.nextInt(); score > 100 || score < 0; score = scan.nextInt()) {
			if(score <=100) {
				if(score >= 60) {
					System.out.println("합격");
				}
			}
			if(score < 60) {
				if(score >= 0) {
				System.out.println("불합격");
				}
			}
			System.out.println("오류! 다시 입력하세요 : ");
		}
		System.out.println("입력완료");
		scan.close();
	}
}

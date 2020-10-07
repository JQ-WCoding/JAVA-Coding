package Day004_P;

import java.util.Scanner;

public class Day00408점수유효성검사_P {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("점수를 입력해주세요 : ");
		int score = scan.nextInt();
		
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
		if(score < 0 || score > 100){
			System.out.println("다시 작성해주세요!");
		}
		scan.close(); 
	}
}

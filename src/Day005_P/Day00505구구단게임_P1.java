package Day005_P;

import java.util.Scanner;

public class Day00505구구단게임_P1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("숫자 1을 입력하세요 : ");
		int x = scan.nextInt();
		System.out.println("숫자 2를 입력하세요 : ");
		int y = scan.nextInt();
		
		System.out.println(x + " * " + y + " = ?");
		int answer = x * y;
		
		System.out.println("정답을 입력하세요 : ");
		int myAnswer = scan.nextInt();
		
		if(answer == myAnswer) {
			System.out.println("정답!");
		}
		if(answer != myAnswer) {
			System.out.println("오답!");
		}
		scan.close();
	}
}

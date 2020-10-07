package Day005_P;

import java.util.Scanner;

public class Day00505구구단게임_P {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("숫자1 입력 : ");
		int x = scan.nextInt();
		System.out.println("숫자2 입력 : ");
		int y = scan.nextInt();
		int answer = x * y;
		
		System.out.println(x + " * " + y + " = ?");
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

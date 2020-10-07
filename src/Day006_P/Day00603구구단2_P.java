package Day006_P;

import java.util.Random;
import java.util.Scanner;

public class Day00603구구단2_P {
	public static void main(String[] args) {
		Random rn = new Random();
		Scanner sc = new Scanner(System.in);
		
		int x = rn.nextInt(8) + 2;
		int y = rn.nextInt(9) + 1;
		
		System.out.println(x + " * " + y + " = ?");
		int answer = x * y;
		System.out.println("정답을 입력하세요 : ");
		int myAnswer = sc.nextInt();
		
		if(answer == myAnswer) {
			System.out.println("정답!");
		}
		else {
			System.out.println("오답!");
		}
		sc.close();
	}
}

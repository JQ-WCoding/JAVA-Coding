package Day007_P;

import java.util.Random;
import java.util.Scanner;

public class Day00705연산자기호맞추기_P {
	public static void main(String[] args) {
		Random ran = new Random();
		Scanner scan = new Scanner(System.in);
		
		int x = ran.nextInt(10) + 1;
		int y = ran.nextInt(10) + 1;
		int pick = ran.nextInt(4) + 1;
		int z = 0;
		
		if(pick == 1) {
			z = x + y;
		}
		else if(pick == 2) {
			z = x - y;
		}
		else if(pick == 3) {
			z = x * y;
		}
		else if(pick == 4) {
			z = x % y;
		}
		//Cheat Key
		System.out.println("Cheat Key : " + pick);
		System.out.println(x + " ? " + y + " = " + z);
		System.out.println("1) +  2) -  3) *  4) %");
		int myAnswer = scan.nextInt();
		
		if(pick == myAnswer) {
			System.out.println("정답!");
		}
		else if(pick != myAnswer) {
			System.out.println("오답!");
		}
		scan.close();
	}
}

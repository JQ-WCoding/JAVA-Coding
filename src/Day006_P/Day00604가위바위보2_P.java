package Day006_P;

import java.util.Random;
import java.util.Scanner;

public class Day00604가위바위보2_P {
	public static void main(String[] args) {
		Random rn = new Random();
		Scanner sc = new Scanner(System.in);
		
		int com = rn.nextInt(3);
		//cheatkey
		System.out.println("cheatkey : " + com);
		System.out.println("가위(0) 바위(1) 보(2) ! :");
		int me = sc.nextInt();
		
		if(com == me) {
			System.out.println("비겼다");
		}
		else if(com == 0) {
			if(me == 1) {
				System.out.println("이겼다!");
			}
			else if(me == 2) {
				System.out.println("졌다!");
			}
		}
		else if(com == 1) {
			if(me == 2) {
				System.out.println("이겼다!");
			}
			else if(me == 0) {
				System.out.println("졌다!");
			}
		}
		else if(com == 2) {
			if(me == 0) {
				System.out.println("이겼다!");
			}
			else if(me == 1) {
				System.out.println("졌다!");
			}
		}
		else {
			System.out.println("기입 오류");
		}
		sc.close();
	}
}

package Day004_P;

import java.util.Scanner;

public class Day00407가위바위보_P {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int com = 1;
		
		System.out.println("가위(0) 바위(1) 보(2)를 내세요 :");
		int me = sc.nextInt();
		
		if(me == com) {
			System.out.println("비겼다");
		}
		else if(me == 0) {
			System.out.println("졌다");
		}
		else if(me == 2) {
			System.out.println("이겼다");
		}
		else {
			System.out.println("잘못입력하엿습니다.");
		}
		sc.close();
	}
}

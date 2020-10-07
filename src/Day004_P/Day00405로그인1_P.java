package Day004_P;

import java.util.Scanner;

public class Day00405로그인1_P {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int dbId = 1234;
		int dbPw = 1111;
		
		System.out.println("ID를 입력하세요 : ");
		int myId = sc.nextInt();
		System.out.println("PW를 입력하세요 : ");
		int myPw = sc.nextInt();
		
		if(dbId == myId && dbPw == myPw) {
			System.out.println("로그인 성공");
		}
		if(dbId != myId || dbPw != myPw) {
			System.out.println("로그인 실패");
		}
	sc.close();
	}
}

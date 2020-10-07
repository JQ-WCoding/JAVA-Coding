package Day004_P;

import java.util.Scanner;

public class Day00406로그인2_P {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int dbId = 0;
		int dbPw = 0;
		
		System.out.println("[가입] ID를 입력하세요 : ");
		dbId = sc.nextInt();
		System.out.println("[가입] PW를 입력하세요 : ");
		dbPw = sc.nextInt();
		
		System.out.println("[로그인] ID를 입력하세요 : ");
		int myId = sc.nextInt();
		System.out.println("[로그인] PW를 입력하세요 : ");
		int myPw = sc.nextInt();
		
		if(dbId == myId && dbPw == myPw) {
			System.out.println("로그인 성공!");
		}
		if(dbId != myId || dbPw != myPw) {
			System.out.println("로그인 실패!");		
		}
		sc.close();
	}
}

package Day004_P;

import java.util.Scanner;

public class Day00405로그인1_P1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int dbID = 1234;
		int dbPW = 1111;
		
		System.out.println("ID 입력하세요 : ");
		int myID = sc.nextInt();
		System.out.println("PW 입력하세요 : ");
		int myPW = sc.nextInt();
		if(dbID == myID && dbPW == myPW) {
			System.out.println("로그인 성공");
		}
		else if(dbID != myID || dbPW != myPW) {
			System.out.println("로그인 실패");
		}
		sc.close();
	}
}

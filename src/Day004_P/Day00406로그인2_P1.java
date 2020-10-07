package Day004_P;

import java.util.Scanner;

public class Day00406로그인2_P1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int dbID = 0;
		int dbPW = 0;
		
		System.out.println("가입 ID 입력 : ");
		dbID = sc.nextInt();
		System.out.println("가입 PW 입력 : ");
		dbPW = sc.nextInt();
		
		System.out.println("=== Login ===");
		System.out.println("ID 입력 : ");
		int myID = sc.nextInt();
		System.out.println("PW 입력 : ");
		int myPW = sc.nextInt();
		
		if(dbID == myID && dbPW == myPW) {
			System.out.println("로그인 성공!");
		}
		else {
			System.out.println("로그인 실패");
		}
		sc.close();
	}
}

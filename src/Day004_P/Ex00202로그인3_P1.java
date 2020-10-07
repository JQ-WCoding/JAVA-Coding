package Day004_P;

import java.util.Scanner;

public class Ex00202로그인3_P1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int dbID = 1234;
		int dbPW = 1111;
		
		System.out.println("ID를 입력해주세요 : ");
		int myID = sc.nextInt();
		if(dbID == myID) {
			System.out.println("PW를 입력해주세요 : ");
			int myPW = sc.nextInt();
			if(myPW == dbPW) {
				System.out.println("로그인 완료");
			}
			else {
				System.out.println("PW를 확인해주세요");
			}
		}
		else {
			System.out.println("ID를 확인해주세요");
		}
		sc.close();
	}
}

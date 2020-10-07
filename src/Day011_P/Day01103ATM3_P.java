package Day011_P;

import java.util.Scanner;

public class Day01103ATM3_P {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int dbAcc1 = 1234;
		int dbPw1 = 1111;
		int dbAcc2 = 2345;
		int dbPw2 = 2222;
		
		int log = -1; // -1 로그아웃 , 1 Acc1 로그인, 2 Acc2 로그인
		boolean run = true;
		while(run) {
			System.out.println("1. 로그인");
			System.out.println("2. 로그아웃");
			System.out.println("0. 종료");
			int choice = sc.nextInt();
			if(choice == 1) {
				if(log == -1) {
					boolean runPlus = true;
					while(runPlus) {
						System.out.println("[메세지] 계좌번호 입력 :");
						int myAcc = sc.nextInt();
						System.out.println("[메세지] 비밀번호 입력 :");
						int myPw = sc.nextInt();
						if(myAcc == dbAcc1 && myPw == dbPw1) {	
							System.out.println(dbAcc1 + "님 환영합니다.");
							log = 1;
							runPlus = false;
						}
						else if(myAcc == dbAcc2 && myPw == dbPw2) {
							System.out.println(dbAcc2 + "님 환영합니다.");
							log = 2;
							runPlus = false;
						}
						else {
							System.out.println("계좌번호 혹은 비밀번호를 확인해주세요!");
							//choice = 1; (?)
						}
					}
				}
				else if(log == 1) {
					System.out.println(dbAcc1 + "님 로그인중...");
				}
				else if(log == 2) {
					System.out.println(dbAcc2 + "님 로그인중...");
				}
			}
			else if(choice == 2) {
				if(log != -1) {
					System.out.println("[메세지] 로그아웃 되었습니다.");
					log = -1;
				}
				else{
					System.out.println("로그인이 필요합니다.");
				}
			}
			else if(choice == 0) {
				System.out.println("프로그램 종료");
				run = false;
			}
		}
		sc.close();
	}
}

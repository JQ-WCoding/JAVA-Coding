package Day012_P;

import java.util.Scanner;

public class Ex00303ATM종합_P {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int dbAcc1 = 1111;
		int dbPw1 = 1234;
		int dbMoney1 = 50000;
		
		int dbAcc2 = 2222;
		int dbPw2 = 2345;
		int dbMoney2 = 70000;	
		
		int log = -1;  //dbAcc1 login = 1 , dbAcc2 login = 2
		boolean run = true;
		
		while(run) {
			System.out.println("1. 로그인");
			System.out.println("2. 로그아웃");
			System.out.println("3. 입금");
			System.out.println("4. 출금");
			System.out.println("5. 이체");
			System.out.println("6. 조회");
			System.out.println("0. 종료");
			
			int choice = sc.nextInt();
			//로그인 기능
			if(choice == 1) {
				//로그아웃 상태만 이용가능
				if(log == -1) {
					boolean runPlus = true;
					// 계좌번호 비밀번호 반복 체크
					while(runPlus) {
						System.out.println("[로그인] 계좌번호 입력 : ");
						int myAcc = sc.nextInt();
						System.out.println("[로그인] 패스워드 입력 : ");
						int myPw = sc.nextInt();
					
						if(myAcc == dbAcc1 && myPw == dbPw1) {
							log = 1;
							System.out.println("[메세지]" + dbAcc1 + "님, 환영합니다.");
							runPlus = false;
						}
						else if(myAcc == dbAcc2 && myPw == dbPw2) {
							log = 2;
							System.out.println("[메세지]" + dbAcc2 + "님, 환영합니다.");
							runPlus = false;
						}
						else {
							System.out.println("[메세지] 계좌번호 혹은 비밀번호를 확인해주세요");
						}
					}
				}
				//로그인 중일때
				else {
					if(log == 1) {
						System.out.println(dbAcc1 + "회원 로그인중...");
					}
					else if(log == 2) {
						System.out.println(dbAcc2 + "회원 로그인중...");
					}
				}
			}
			// 로그아웃 기능
			else if(choice == 2) {
				//로그인 중일 때에만 이용 가능
				if(log != -1) {
					System.out.println("[메세지] 로그아웃 되었습니다.");
					log = -1;
				}
				else {
					System.out.println("[메세지] 로그인이 필요한 서비스입니다.");
				}
			}
			// 입금 기능
			else if(choice == 3) {
				System.out.println("=== 입금 ===");
				if(log == 1) {
					System.out.print("입금 금액 입력 : ");
					int money = sc.nextInt();
					dbMoney1 = dbMoney1 + money;
					System.out.println("입금 완료");
				}
				else if(log == 2) {
					System.out.print("입금 금액 입력 : ");
					int money = sc.nextInt();
					dbMoney2 = dbMoney2 + money;
					System.out.println("입금 완료");
				}
				else {
					System.out.println("[메세지] 로그인이 필요한 서비스입니다.");
				}
			}
			// 출금 기능
			else if(choice == 4) {
				System.out.println("=== 출금 ===");
				if(log == 1) {
					System.out.print("출금 금액 입력 : ");
					int money = sc.nextInt();
					if(money <= dbMoney1) {
						dbMoney1 = dbMoney1 - money;
						System.out.println("출금 완료");
					}
					else {
						System.out.println("잔액 부족");
					}
				}
				else if(log == 2) {
					System.out.print("출금 금액 입력 : ");
					int money = sc.nextInt();
					if(money <= dbMoney2) {
						dbMoney2 = dbMoney2 - money;
						System.out.println("출금 완료");
					}
					else {
						System.out.println("잔액 부족");
					}
				}
				else {
					System.out.println("[메세지] 로그인이 필요한 서비스입니다.");
				}
			}
			// 계좌 이체 기능
			else if(choice == 5) {
				System.out.println("=== 계좌 이체 ===");
				if(log == 1) {
					System.out.print("이체할 계좌번호 입력 : ");
					int acc = sc.nextInt();
					if(acc == dbAcc2) {
						System.out.print("이체할 금액 입력 : ");
						int money = sc.nextInt();
						if(money <= dbMoney1) {
							dbMoney1 = dbMoney1 - money;
							dbMoney2 = dbMoney2 + money;
							System.out.println("이체 완료");
						}
						else {
							System.out.println("잔액 부족");
						}
					}
					else {
						System.out.println("계좌번호를 확인해주세요.");
					}
				}
				else if(log == 2) {
					System.out.print("이체할 계좌번호 입력 : ");
					int acc = sc.nextInt();
					if(acc == dbAcc1) {
						System.out.print("이체할 금액 입력 : ");
						int money = sc.nextInt();
						if(money <= dbMoney2) {
							dbMoney2 = dbMoney2 - money;
							dbMoney1 = dbMoney1 + money;
							System.out.println("이체 완료");
						}
						else {
							System.out.println("잔액 부족");
						}
					}
					else {
						System.out.println("계좌번호를 확인해주세요.");
					}
				}
				else {
					System.out.println("[메세지] 로그인이 필요한 서비스입니다.");
				}
			}
			// 잔액 조회 기능
			else if(choice == 6) {
				System.out.println("=== 잔액 조회 ===");
				if(log != -1) {
				System.out.println("1111 = " + dbMoney1 + "원");
				System.out.println("2222 = " + dbMoney2 + "원");
				}
				else {
					System.out.println("[메세지] 로그인이 필요한 서비스입니다.");
				}
			}	
			// 프로그램 종료
			else if(choice == 0) {
				System.out.println("프로그램 종료");
				run = false;
			}
		}
		sc.close();
	}
}

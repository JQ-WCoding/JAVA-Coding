package Day007_P;

import java.util.Scanner;

public class Day00701ATM2_P1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		  int myCash = 20000;		
		  int myAccCash = 30000;	
		  int account = 1234;		
		  int password = 1111;
		  
		  System.out.println("[ATM]");
		  System.out.println("1. 로그인");
		  System.out.println("2. 종료");
		  int select = scan.nextInt();
		  
		  if(select == 1) {
			  System.out.println("[로그인]계좌번호를 입력하세요.");
			  int myAcc = scan.nextInt();
			  System.out.println("[로그인]비밀번호를 입력하세요.");
			  int myPw = scan.nextInt();
			  
			  if(myAcc == account && myPw == password) {
				 System.out.println("1. 입금");
				 System.out.println("2. 출금");
				 System.out.println("3. 잔액조회");
				 int choice = scan.nextInt();
				 
				 if(choice == 1) {
					 System.out.println("[입금]금액을 입력하세요.");
					 int deposit = scan.nextInt();
					 if(myCash >= deposit) {
						 myCash = myCash - deposit;
						 myAccCash = myAccCash + deposit;
						 System.out.println("[메세지] 입금 완료");
						 System.out.println("통장 잔액 : " + myAccCash);
					 }
					 else {
						 System.out.println("돈이 부족하다.");
					 }
				 }
				 else if(choice == 2) {
					 System.out.println("[출금]금액을 입력하세요.");
					 int deposit = scan.nextInt();
					 if(myAccCash >= deposit) {
						 myCash = myCash + deposit;
						 myAccCash = myAccCash - deposit;
						 System.out.println("[메세지] 입금 완료");
						 System.out.println("통장 잔액 : " + myAccCash);
				 }
					 else {
						 System.out.println("[메세지] 통장 잔액이 부족합니다.");
					 }
				 }
				 else if(choice == 3) {
					 System.out.println("[메세지] 현재통장 잔액 : " + myAccCash);
				 }
			  }
			  else {
				  System.out.println("[메세지] 계좌번호와 비밀번호를 확인해주세요.");
			  }
		  }
		  else if(select == 2) {
			  System.out.println("프로그램 종료");
		  }
		  System.out.println("내 수중의 금액 : " + myCash);
		 scan.close();
	}
}

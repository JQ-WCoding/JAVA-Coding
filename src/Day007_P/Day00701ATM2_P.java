package Day007_P;

import java.util.Scanner;

public class Day00701ATM2_P {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		  int myCash = 20000;		// 현금
		  int accCash = 30000;	// 통장잔액
		  int accId = 1234;		// 계좌번호
		  int accPw = 1111;	// 비밀번호
		  
		  System.out.println("[J ATM]");
		  System.out.println("1. 로그인");
		  System.out.println("2. 종료");
		  int loginSelect = scan.nextInt();
		  
		  if(loginSelect == 1) {
			  System.out.println("[메세지] 계좌번호를 입력하세요 : ");
			  int typeAccId = scan.nextInt();
			  if(typeAccId == accId) {
				  System.out.println("[메세지] 비밀번호를 입력하세요 : ");
				  int typeAccPw = scan.nextInt();
				  if(typeAccPw == accPw) {
					  System.out.println("[메세지] 1. 입금");
					  System.out.println("[메세지] 2. 출금");
					  System.out.println("[메세지] 3. 잔액조회");
					  int myChoice = scan.nextInt();
					  if(myChoice == 1) {
						  System.out.println("입금 금액을 입력하세요 : ");
						  int deposit = scan.nextInt();
						  if(myCash >= deposit) {
							  myCash = myCash - deposit;
							  System.out.println("입금 후 남은 돈 : " + myCash + "원");
							  accCash = accCash + deposit;
							  System.out.println("입금 후 통장 잔액 : " + accCash + "원");
						  }
						  else {
							  System.out.println("돈이 없다!");
						  }
					  }
					  if(myChoice == 2) {
						  System.out.println("인출 금액을 입력하세요 : ");
						  int deposit = scan.nextInt();
						  if(accCash >= deposit) {
							  myCash = myCash + deposit;
							  System.out.println("인출 후 남은 돈 : " + myCash + "원");
							  accCash = accCash - deposit;
							  System.out.println("인출 후 통장 잔액 : " + accCash + "원");
						  }
						  else {
							  System.out.println("통장 잔액이 부족합니다.");
						  }
					  }
					  if(myChoice ==3) {
						  System.out.println(accCash + "원");
					  }
					  else if(myChoice != 1 && myChoice !=2 && myChoice != 3){
						  System.out.println("기입 오류~");
					  }
				  }
				  else {
					  System.out.println("비밀번호를 확인해주세요.");
				  }
			  }
			  else {
				  System.out.println("계좌번호를 확인해주세요.");
			  }
		  }
		  else if(loginSelect == 2) {
			  System.out.println("종료합니다.");
		  }
		  else {
			  System.out.println("기입 오류!");
		  }
		  scan.close();
	}
}

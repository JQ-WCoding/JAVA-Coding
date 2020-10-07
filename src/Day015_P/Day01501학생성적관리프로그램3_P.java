package Day015_P;

import java.util.Scanner;

public class Day01501학생성적관리프로그램3_P {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] hakbuns = {1001, 1002, 1003, 1004, 1005};
		int[] scores  = {  87,	 11,   45,   98,   23};
		
		int check = -1;
		
		System.out.println("학번을 입력하세요 :");
		int myNum = sc.nextInt();
		
		for(int i =0;i<5;i++) {
			if(hakbuns[i] == myNum) {
				check = i;
			}
		}
		
		if(check != -1) {
			System.out.println("성적 : " + scores[check]);
		}
		else {
			System.out.println("해당 학번은 존재하지 않습니다.");
		}
		sc.close();
	}
}

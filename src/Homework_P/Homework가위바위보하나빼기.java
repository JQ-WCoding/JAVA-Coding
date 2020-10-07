package Homework_P;

import java.util.Random;
import java.util.Scanner;

//이준규 20/09/29

public class Homework가위바위보하나빼기 {
	public static void main(String[] args) {
		Random rn = new Random();
		Scanner sc = new Scanner(System.in);

		// me(나)의 가위바위보 입력 후 출력
		// 문자열을 입력받는 방법

		String[] mine = new String[2];

		int index_s = 0;
		for (int i = 0; i < 2; i++) {
			System.out.println("가위바위보 중 (" + (i + 1) + ")번째를 입력하세요 : ");
			mine[i] = sc.nextLine();
			index_s = i;
			if (i == 1) {
				if (mine[i].equals(mine[i - 1])) {
					System.out.println("중복! 다시 입력하세요 :");
					i--;
				}
			}
		}
		for (int i = 0; i < 2; i++) {
			System.out.println("나의 (" + (i + 1) + ") 번째 : " + mine[i]);
		}
		// 실험
		String[] com_RPS = { "가위", "바위", "보" };
		// com(컴퓨터)의 가위바위보 출력
		int[] comCheck = new int[2];
		//		int index = 0;
		int com = 0;

		for (int i = 0; i < 2; i++) {
			com = rn.nextInt(3); // 0 1 2
			comCheck[i] = com; // check[0] = 1 check[1] = 1
			if (i == 1) {
				if (comCheck[i] == comCheck[i - 1]) {
					i--;
				}
			}
			//			index = com;

		}
		for (int i = 0; i < 2; i++) {
			System.out.println("컴퓨터의 (" + (i + 1) + ") 번째 : " + com_RPS[comCheck[i]]);
		}

		//me가 낼것 선택하기
		System.out.println("하나빼기! : ");
		String mineLast = "0";
		// mineLast와 mine[index]를 두개 비교하여 둘중 하나라도 같으면
		// 내가 낸 값 중 하나이기에 출력가능
		
		// run 참 거짓을 이용해 무한반복문 생성 후 조건에 부합시에 반복문 탈출하게 하기
		boolean run = true;
		while (run) {
			mineLast = sc.nextLine();
			if (mineLast.equals((mine)[index_s]) || mineLast.equals(mine[index_s - 1])) {
				System.out.println("나의 마지막 선택 : " + mineLast);
				// 정확히 기입했을 경우, 반복문 탈출
				run = false;
			} else {
				// 낸적이 없는 경우 계속 반복
				System.out.println("내가 낸적이 없습니다.");
			}
		}
		//com이 낼것 선택하기 
		// comCheck내의 0,1번방 중 하나 선택을 위해 랜덤 0 또는 1 받기
		int index_r = rn.nextInt(2);
		// comCheck 히프 내에 담긴 수 중 하나를 선택해 com_RPS의 배열 주소로 이동
		System.out.println("마지막 컴퓨터의 선택 : " + com_RPS[comCheck[index_r]]);

		//둘의 승패 비교하기
		if (com_RPS[comCheck[index_r]].equals(mineLast)) {
			System.out.println("비겼습니다");
		}
		//		else if(com_RPS[comCheck[index_r]].equals("가위")) {
		//			
		//		}
		//승패 조건
		else {
			if (com_RPS[comCheck[index_r]].equals("가위")) {
				if (mineLast.equals("바위")) {
					System.out.println("Win!");
				} else if (mineLast.equals("보")) {
					System.out.println("Loose!");
				}
			} else if (com_RPS[comCheck[index_r]].equals("바위")) {
				if (mineLast.equals("가위")) {
					System.out.println("Loose!");
				} else if (mineLast.equals("보")) {
					System.out.println("Win!");
				}
			} else if (com_RPS[comCheck[index_r]].equals("보")) {
				if (mineLast.equals("바위")) {
					System.out.println("Loose!");
				} else if (mineLast.equals("가위")) {
					System.out.println("Win!");
				}
			}
		}
		//
		sc.close();
	}
}

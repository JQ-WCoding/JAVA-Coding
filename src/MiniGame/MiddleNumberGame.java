package MiniGame;

import java.util.Random;
import java.util.Scanner;

public class MiddleNumberGame {
	public static void main(String[] args) {
		Random random = new Random();
		Scanner input = new Scanner(System.in);

//		gameCoin -= 1;
//		run = 0;
//		while (run == 0) {
			System.out.println("======사칙연산 369 게임======");
			System.out.println("[설명] 사칙연산을 통해 나온 정답의 값을 369로 표현하세요");
			System.out.println("[조건] 5번 중 3번 맞추기 승리");
			System.out.println("      % 는 나머지를 의미한다.");
			String[] operator1 = { "+", "-" };
			String[] operator2 = { "*", "%" };
			System.out.println();
			int endCount = 0;
			for (int i = 0; i < 5; i++) {
				int clapCount = 0;
				int numbering = random.nextInt(2);
				int x = random.nextInt(10) + 1;
				int y = random.nextInt(10) + 1;
				int z = random.nextInt(10) + 1;
				int answer = 0;
				//사칙연산 종류 랜덤 받기
				if (numbering == 0) {
					answer = (x + y) * z;
				} else if (numbering == 1) {
					answer = ((x + y) % z);
				}
				// 문제 시작
				System.out.println((i + 1) + "번 문제");
				System.out.println("(" + x + operator1[numbering] + y + ")" + operator2[numbering] + z + " = ?");
				//cheatkey
				System.out.println("cheatkey = " + answer);
				// 정답확인
				int answerCheck1 = answer / 10;
				int answerCheck2 = answer % 10;
				int answerCheck3 = answer % 100;
				//100 초과시
				if (answer >= 100) {
					//100의 자리수
					if (answer / 100 % 3 == 0) {
						clapCount++;
						//10의 자리수
					}
					if ((answerCheck3 / 10) % 3 == 0 && answerCheck3 / 10 != 0) {
						clapCount++;
						//1의 자리수
					}
					if ((answerCheck3 % 10) % 3 == 0 && answerCheck3 % 10 != 0) {
						clapCount++;
					}
				}
				// 100 미만시
				else {
					if (answer != 0) {
						// 10의 자리수
						if (answerCheck1 % 3 == 0 && answerCheck1 != 0) {
							clapCount++;
							//1의 자리수
						}
						if (answerCheck2 % 3 == 0 && answerCheck2 != 0) {
							clapCount++;
						}
					}
				}
				// 정답확인
				System.out.println();
				System.out.println("'짝'의 개수는 ? : ");
				int myCheck = input.nextInt();
				if (clapCount == myCheck) {
					System.out.println("정답");
					endCount++;
				} else {
					System.out.println("오답");
				}
				if (endCount >= 3) {
					i = 5;
					System.out.println("성공!");
					System.out.println("게임 종료");
				} else {
					System.out.println("실패!");
				}
			}
			// 게임 종료 후 재시작 선택
			System.out.println("다시 하시겠습니까?");
			System.out.println("(1) Yes  (2) No");
			int choice = input.nextInt();
			if (choice == 1) {
				System.out.println("====New Game====");
			} else {
//				run = 1;
			}
//		}

		input.close();
	}
}

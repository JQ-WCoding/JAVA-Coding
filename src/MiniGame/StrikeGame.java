package MiniGame;

import java.util.Random;
import java.util.Scanner;

public class StrikeGame {
	public static void main(String[] args) {
		Random random = new Random();
		Scanner input = new Scanner(System.in);

		int[] answerSheet = new int[4];
		int[] mySheet = new int[4];
		int check = -1; // 게임 종료 후 완성된 정답인지 확인
		// 정답지 출제
		// 반복문은 countCoin으로 나중에 수정
		boolean strikeRun = true;
		while (strikeRun) {
			for (int i = 0; i < 4; i++) {
				answerSheet[i] = random.nextInt(10);
				for (int j = 0; j < i; j++) {
					if (answerSheet[i] == answerSheet[j]) {
						i--;
					}
				}
			}
			// 확인용 치트키
			System.out.print("Cheatkey = {");
			for (int i = 0; i < 4; i++) {
				if (i == 3) {
					System.out.print(answerSheet[i]);
				} else {
					System.out.print(answerSheet[i] + ", ");
				}
			}
			System.out.println("}");
			System.out.println();
			// 게임이 완료 판독 (20번 반복 후 게임 종료)
			for (int tryCount = 0; tryCount < 20; tryCount++) {
				int strikeCount = 0; // 스트라이크 개수
				int ballCount = 0; // 볼 개수
				// 몇번의 기회가 남았는지 확인하기
				System.out.println("[" + (20 - tryCount) + "]의 기회");

				for (int i = 0; i < 4; i++) {
					System.out.print((i + 1) + ")번째 숫자 : ");
					mySheet[i] = input.nextInt();
					if (mySheet[i] >= 10 || mySheet[i] < 0) {
						i--;
						System.out.println("[오류]다시 입력하세요");
					}
					for (int j = 0; j < i; j++) {
						//중복방지
						if (mySheet[i] == mySheet[j]) {
							i--;
							System.out.println("[중복]다시 입력하세요");
						}
					}
				}
				System.out.println();
				// 나의 작성 답안
				System.out.print("MyGuess = {");
				for (int i = 0; i < 4; i++) {
					if (i == 3) {
						System.out.print(mySheet[i]);
					} else {
						System.out.print(mySheet[i] + ", ");
					}
				}
				System.out.println("}");

				//정답 확인
				for (int i = 0; i < 4; i++) {
					if (mySheet[i] == answerSheet[i]) {
						strikeCount++;
					} else {
						for (int j = 0; j < 4; j++) {
							if (mySheet[i] == answerSheet[j]) {
								ballCount++;
							}
						}
					}
				}
				// 볼 스트라이크 확인
				System.out.println(ballCount + " ball / " + strikeCount + " Strike");
				System.out.println();
				if(strikeCount == 4) {
					check = 1;
					tryCount = 20;
				}
				else {
					check = -1;
				}
			}
			System.out.println("게임 종료");
			// 종료 후 판독 방법
			if (check != -1) {
				System.out.println("[성공]");
			} else {
				System.out.println("[실패]");
			}
			System.out.println();
			System.out.println("One more? : Use 1 coin");
			System.out.println("(1) Yes  (2) No");
			int choice = input.nextInt();
			if(choice == 1) {
				System.out.println("==New Game==");
			}
			else {
				strikeRun = false;
			}
		}
		input.close();
	}
}

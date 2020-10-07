package Day008_P;
// 6m 52s
import java.util.Random;
import java.util.Scanner;

public class Day00805구구단게임3_P {
	public static void main(String[] args) {
		Random ran = new Random();
		Scanner scan = new Scanner(System.in);
		//1. 5회 반복
		int i = 1;
		int count = 0;
		while(i <= 5) {
			// 2.랜덤하게 구구단 문제 출제
			int x = ran.nextInt(8) + 2;
			int y = ran.nextInt(9) + 1;
			int answer = x * y;
			// 3. 정답 입력받기
			System.out.println("[문제" + i + "번] " + x + " * " + y + " = ?");
			int myAnswer = scan.nextInt();
			// 4. 정답 맞췄을 때
			// 		- count변수를 활용해 맞춘 개수를 저장
			if(answer == myAnswer) {
				count += 1;
				System.out.println("정답!");
			}// 5.정답이 틀렸을 때
			else {
				System.out.println("오답!");
			}
			i++;
		}
		//	6. 게임 종료 후 (= 5회 반복이 끝난 후),
		//		성적 = count(정답을 맞춘 개수) * 20 출력
		System.out.println("성적 : " + count * 20 + "점");
		scan.close();
	}
}

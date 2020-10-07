package Day011_P;

import java.util.Random;
import java.util.Scanner;

public class Day01102카카오택시_P {
	public static void main(String[] args) {
		Random rn = new Random();
		Scanner sc = new Scanner(System.in);
		
		int x = rn.nextInt(21) - 10;
		int y = rn.nextInt(21) - 10;
		int myX = rn.nextInt(21) - 10;
		int myY = rn.nextInt(21) - 10;
		int way = 0;
		int speed = 0;
		int fee = 0;
		int total = 0;
		boolean run = true;
		
		while(run) {
			if(myX != x || myY != y) {

				System.out.println("= 카카오 택시 =");
				System.out.println("목적지 : " + x + ", " + y);
				System.out.println("현위치 : " + myX + ", " + myY);
				System.out.println("방향 설정");
				System.out.println("동(1) 서(2) 남(3) 북(4)");
				way = sc.nextInt();
				if(way == 1 || way == 2 || way == 3 || way == 4) {
				System.out.println("칸 이동 : " + speed + " (속도 조절 가능합니다.)");
				speed = sc.nextInt();
				total = total + speed;
					if(speed == 1 || speed == 2 || speed == 3) {
						if(way == 1) {
							myX = myX + speed;
						}
						else if(way == 2) {
							myX = myX - speed;
						}
						else if(way == 3) {
							myY = myY - speed;
						}
						else if(way == 4) {
							myY = myY + speed;
						}
					}
					else {
						System.out.println("칸이동 입력 오류!");
					}
				}
				else if(way != 1 && way != 2 && way != 3 && way != 4){
					System.out.println("잘못된 방향입니다.");
					way = 0;
				}
				if(myX == x && myY == y) {
					System.out.println("도착!");
					fee = total * 50;
					System.out.println("이동 칸 수 = " + total);
					System.out.println("요금 : " + fee);
					run = false;
				}
			}
			else if(myX == x && myY == y){
				System.out.println("택시가 필요 없습니다.");
				run = false;
			}
		}
		sc.close();
	}
}

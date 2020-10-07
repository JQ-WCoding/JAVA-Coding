package Day010_P;

public class Day01001_369게임2_P {
	public static void main(String[] args) {
		int i = 1;
		System.out.println("[369게임]");
		while(i <= 50) {
			int cnt = 0;
			int x = i / 10;
			int y = i % 10;
			if(x == 3 || x == 6 || x == 9) {
				cnt = cnt + 1;
			}
			if(y == 3 || y == 6 || y == 9) {
				cnt = cnt + 1;
			}
			if(cnt == 2) {
				System.out.println("짝짝");
			}
			else if(cnt == 1) {
				System.out.println("짝");
			}
			else {
				System.out.println(i);
			}
			i++;
		}
	}
}

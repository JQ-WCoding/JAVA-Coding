package Day010_P;

public class Day01001_369게임2_P1 {
	public static void main(String[] args) {

		for (int i = 1; i <= 50; i++) {
			int count = 0;
			int x = i / 10;
			int y = i % 10;
			if (x % 3 == 0 && x != 0) {
				count++;
			}
			if (y % 3 == 0 && y != 0) {
				count++;
			}
			if (count == 1) {
				System.out.print("짝 ");
			} else if (count == 2) {
				System.out.print("짝짝 ");
			} else {
				System.out.print(i + " ");
			}
		}
	}
}

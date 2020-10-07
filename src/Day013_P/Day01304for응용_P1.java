package Day013_P;

public class Day01304for응용_P1 {
	public static void main(String[] args) {

		int count = 0;
		for (int i = 1; i <= 1000; i++) {
			if (i >= 50 && i <= 100) {
				if (i % 9 == 0) {
					count++;
				}
			}
		}
		System.out.println(count + "개");

		int temp = 0;
		for (int i = 1; i <= 1000; i++) {
			if (i % 28 == 0) {
				temp = i;
			}
		}
		System.out.println(temp);

		count = 0;
		for (int i = 0; i <= 1000; i++) {
			if (i % 8 == 0 && count < 5 && i != 0) {
				System.out.print(i + " ");
				count++;
			}
		}
	}
}

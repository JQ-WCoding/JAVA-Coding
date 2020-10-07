package Day013_P;

public class Day01303for응용1_P {
	public static void main(String[] args) {

		int i = 1000;
		int count = 0;
		//Q1
		for (i = 1; i <= 1000; i++) {
			if (i % 9 == 0 && i % 10 == 6) {
				count++;
				if (count == 1) {
					System.out.println(i + " ");
				}
			}
		}
		count = 0;
		//Q2
		for (i = 1; i <= 1000; i++) {
			if (i % 9 == 0 && i % 100 / 10 == 6) {
				count++;
				if (count == 1) {
					System.out.println(i + " ");
				}
			}
		}
		count = 0;
		//Q3
		for (i = 1000; i > 0; i--) {
			if (i % 8 == 0 && i < 150) {
				count++;
				if (count == 1) {
					System.out.println(i + " ");
				}
			}
		}
	}
}

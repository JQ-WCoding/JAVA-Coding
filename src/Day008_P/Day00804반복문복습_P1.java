package Day008_P;

public class Day00804반복문복습_P1 {
	public static void main(String[] args) {
		//Q1
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 1) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		//Q2
		for (int i = 0; i <= 20; i++) {
			if (i % 3 == 0 && i % 4 == 0 && i != 0) {
				System.out.println(i);
			}
		}

		//Q3
		int total = 0;
		for (int i = 0; i <= 10; i++) {
			if (i % 2 == 0) {
				total += i;
			}
		}
		System.out.println(total);

		//Q4
		int count = 0;
		for (int i = 0; i <= 10; i++) {
			if (i % 3 == 0) {
				count++;
			}
		}
		System.out.println(count + "개");
	}
}

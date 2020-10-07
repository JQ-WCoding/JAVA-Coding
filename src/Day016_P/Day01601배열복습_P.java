package Day016_P;
// 9m 14s

public class Day01601배열복습_P {
	public static void main(String[] args) {

		int[] arr = { 12, 87, 34, 100, 22, 5 };

		//Q1
		int count = 0;
		for (int i = 0; i < 6; i++) {
			if (arr[i] % 2 == 0) {
				count++;
			}
		}
		System.out.println("짝수의 개수 : " + count + "개");

		//Q2
		int total = 0;
		for (int i = 0; i < 6; i++) {
			if (arr[i] % 2 == 0) {
				total += arr[i];
			}
		}
		System.out.println("총합 : " + total);

		//Q3
		int[] a = new int[6];
		for (int i = 0; i < 6; i++) {
			if (arr[i] % 2 == 0) {
				a[i] = arr[i];
			}
			System.out.print(a[i] + " ");
		}
		System.out.println();

		//Q4
		int index = 0;
		int[] b = new int[6];
		for (int i = 0; i < 6; i++) {
			if (arr[i] % 2 == 0) {
				b[index] = a[i];
				index++;
			}
		}
		for (int i = 0; i < 6; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();
		//Q5
		total = 0;
		for (int i = 0; i < 6; i++) {
			if (i % 2 == 1) {
				total += arr[i];
			}
		}
		System.out.println("인덱스가 홀수인 수들 총합 : " + total);
	}
}

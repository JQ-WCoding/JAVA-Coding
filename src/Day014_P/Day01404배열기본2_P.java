package Day014_P;

public class Day01404배열기본2_P {
	public static void main(String[] args) {

		//		int[] arr = { 10, 20, 30, 40, 50 };
		int[] arr = new int[5];
		int total = 0;
		int count = 0;
		//Q1
		for (int i = 0; i < 5; i++) {
			arr[i] = 10 * (i + 1);
			if (arr[i] % 4 == 0) {
				System.out.print(arr[i] + " ");
				total = total + arr[i];
				count++;
			}
		}
		System.out.println();
		//Q2
		System.out.println("합 : " + total);

		//Q3
		System.out.println("개수 : " + count);

	}
}

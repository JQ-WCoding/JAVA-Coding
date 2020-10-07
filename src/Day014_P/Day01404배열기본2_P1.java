package Day014_P;

public class Day01404배열기본2_P1 {
	public static void main(String[] args) {

		int[] arr = new int[5];

		int total = 0;
		int count = 0;
		for (int i = 0; i < 5; i++) {
			arr[i] = (i + 1) * 10;
			if (arr[i] % 4 == 0) {
				total += arr[i];
				count++;
				//Q1
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
		//Q2
		System.out.println("합 : " + total);
		//Q3
		System.out.println(count + "개");
	}
}

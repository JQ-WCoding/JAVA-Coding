package Day014_P;

public class Day01403배열기본1_P {
	public static void main(String[] args) {

		int[] arr = new int[5];
		// A1)
		//		arr[0] = 10;
		//		arr[1] = 20;
		//		arr[2] = 30;
		//		arr[3] = 40;
		//		arr[4] = 50;
		int total = 0;
		for (int i = 0; i < 5; i++) {
			arr[i] = 10 * (i + 1);
			System.out.print(arr[i] + " ");
			total = total + arr[i];
		}
		System.out.println();
		// A2)
		System.out.println(total);
	}
}

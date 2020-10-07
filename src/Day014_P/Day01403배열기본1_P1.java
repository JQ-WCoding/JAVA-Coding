package Day014_P;

public class Day01403배열기본1_P1 {
	public static void main(String[] args) {
		
		int[] arr = new int[5];
		//Q1
		int total = 0;
		for(int i =0;i<5;i++) {
			arr[i] = (i+1) * 10; 
			total += arr[i];
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		//Q2
		System.out.println(total);
	}
}

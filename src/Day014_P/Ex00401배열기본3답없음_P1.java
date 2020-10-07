package Day014_P;

public class Ex00401배열기본3답없음_P1 {
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
		int[] temp1 = new int[5];
		int[] temp2 = new int[5];
		int[] temp3 = new int[5];

		//Q1
		for(int i = 0;i<5;i++) {
			temp1[i] = arr[i];
			System.out.print(temp1[i] + " ");
		}
		System.out.println();
		
		//Q2
		for(int i = 0; i<5;i++) {
			temp2[i] = arr[i] * 2;
			System.out.print(temp2[i] + " ");
		}
		System.out.println();
		
		//Q3
		for(int i = 0;i<5;i++) {
			temp3[i] = arr[i] + i;
			System.out.print(temp3[i] + " ");
		}
	}
}

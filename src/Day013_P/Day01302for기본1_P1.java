package Day013_P;

public class Day01302for기본1_P1 {
	public static void main(String[] args) {
		
		//Q1
		for(int i =1;i<=5;i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		//Q2
		for(int i =1;i<=10;i++)
			if(i >= 5 && i <= 9) {
				System.out.print(i + " ");
			}
		System.out.println();
		
		//Q3
		for(int i = 10;i >= 1;i--) {
			if(i <= 6 && i >=3) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		
		//Q4
		for(int i = 1;i<=10;i++) {
			if(i < 3 || i >= 7) {
				System.out.print(i + " ");
			}
		}
	}
}

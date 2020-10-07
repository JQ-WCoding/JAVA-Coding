package Day008_P;

public class Day00802반복분기본1_P {
	public static void main(String[] args) {
		int i = 1;
		while(i <= 10) {
			if(i >= 5 && i <= 9) {
				System.out.print(i + " ");
			}
			i++;
		}
		System.out.println();
		i = 10;
		while(i >= 1) {
			if(i <= 6 && i >= 3) {
				System.out.print(i + " ");
			}
			i--;
		}
		System.out.println();
		i = 1;
		while(i <= 10) {
			if(i % 2 == 0) {
				System.out.print(i + " ");
			}
			i++;
		}
	}
}

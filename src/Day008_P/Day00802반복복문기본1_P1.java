package Day008_P;
// 3m 20s
public class Day00802반복복문기본1_P1 {
	public static void main(String[] args) {
		int i = 1;
		while(i <= 10) {
			if(i >= 5 && i <=9) {
				System.out.print(i + " ");
			}
			i ++;
		}
		System.out.println();
		i = 10;
		while(i >= 1) {
			if(i >= 3 && i <= 6) {
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

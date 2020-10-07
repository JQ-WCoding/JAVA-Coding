package Day008_P;
// 4m 14s
public class Day00803반복문기본2_P2 {
	public static void main(String[] args) {
		int i = 1;
		int total = 0;
		while(i <= 5) {
			total = total + i;
			i++;
		}
		System.out.println(total);
		
		i = 1;
		while(i <= 10) {
			if(i < 3 || i>= 7) {
				System.out.print(i + " ");
			}
			i++;
		}
		System.out.println();
		i = 1;
		total = 0;
		while(i <= 10) {
			if(i < 3 || i >=7) {
				total = total + i;
			}
			i++;
		}
		System.out.println(total);
		
		i = 1;
		int count = 0;
		while(i <= 10) {
			if(i < 3 || i >= 7) {
				count = count + 1;
			}
			i++;
		}
		System.out.println(count + "개");
	}
}

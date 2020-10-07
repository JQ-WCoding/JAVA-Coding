package Day001_P;

public class Ex00103연산자답없음_P2 {
	public static void main(String[] args) {
		//Q1
		int myByte = 8;
		int my_Kbyte = myByte * 1024;
		int my_minByte = my_Kbyte * 1024;
		int forOneByte = my_minByte;
		System.out.println(forOneByte + "byte");
		
		//Q2
		int octopus_Leg = 8;
		int squid_Leg = 10;
		int oct = 3;
		int squ = 7;
		System.out.println("해산물 다리의 총 개수 : " + octopus_Leg * oct + squid_Leg * squ);
		
		//Q3, 4
		int wholeBoard = 20;
		int oneChair = 8;
		int madeChair = wholeBoard / oneChair;
		int leftChair = wholeBoard % oneChair;
		System.out.println("만든의자 : " + madeChair + "개");
		System.out.println("남은 재료 : " + leftChair + "M");
		
		//Q5
		int nonMeetClass = 3;
		int today =10;
		if(today / nonMeetClass == 0) {
			System.out.println("비대면");
		}
		else {
			System.out.println("대면");
		}
 	}
}

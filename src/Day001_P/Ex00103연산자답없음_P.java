package Day001_P;

public class Ex00103연산자답없음_P {
	public static void main(String[] args) {
		//Q1
		int oneByte = 1;
		int kByte = oneByte * 1024;
		int mByte = kByte * 1024;
		System.out.println(8 * mByte + "byte");
		//Q2
		int octopusLeg = 8;
		int squidLeg = 19;
		int totalLeg = octopusLeg * 3 + squidLeg * 7;
		System.out.println(totalLeg + "개");
		//Q3
		int wood = 20;
		int makingChair = 8;
		int canMakeChair = wood / makingChair;
		int leftWood = wood % makingChair;
		System.out.println(canMakeChair + "개 / " + leftWood + "m 남음");
		//Q4
		int nonFaceClass = 3;
		int today = 10;
		System.out.println(today % nonFaceClass == 0);
	}
}

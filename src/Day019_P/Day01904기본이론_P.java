package Day019_P;
/*
 *  많이 읽어봐야할듯!
 */
class Cafe{
	static void read() {
		System.out.println("글읽기");
	}
	static void write() {
		System.out.println("글읽기");
	}
	static void modify() {
		System.out.println("글읽기");
	}
}

public class Day01904기본이론_P {
	public static void main(String[] args) {
		int level = 1;
		switch(level) {
		case 1: Cafe.read();
		break;
		case 2: Cafe.write();
		break;
		case 3: Cafe.modify();
		break;
		}
	}
}

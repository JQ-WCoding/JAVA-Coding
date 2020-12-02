package Day055P;

/**
 * # 래퍼 클래스(wrapper class)
 * - 래퍼 클래스란, 기본 자료형을 클래스로 만들어 놓은 것을 의미한다.
 * [기본형]          [래퍼 클래스]
 * byte             Byte
 * short            Short
 * int              Integer
 * long             Long
 * float            Float
 * double           Double
 * char             Character
 * boolean          Boolean
 */
class MyInteger {
    int num;

    public MyInteger(int num) {
        this.num = num;
    }
}

public class Day05506래퍼클래스 {
    public static void main(String[] args) {
        int x = 10;
        Integer y = new Integer(10);

        float a = 10.1f;
        Float b = new Float(10.1);

        double q = 10.11;
        Double w = new Double(10.11);

        MyInteger r = new MyInteger(100);
    }
}

package SelfWork;

public class MakingMethod {
    public int Sum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {

        int a = 10;
        int b = 20;
        MakingMethod mySum = new MakingMethod();
        int c = mySum.Sum(a, b); // mySum은 객체 , Sum()은 메소드
        System.out.println(c);

    }
}

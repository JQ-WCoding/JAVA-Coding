package SelfWork;

//class Data {
//   public int x; // Data class's member variable
//}

public class PrimitiveParamEx {
    public static void main(String[] args) {
//        Data d = new Data();
//        d.x = 10; // x는 멤버변수 (member) 속성 property®
        int x = 10; // int x
        System.out.println(x);

        change(x); // new address variable is gone
        System.out.println(x); // Line 11 -> x left
    }

    static void change(int y) { // int x (new address)
        y = 1000; // change method's local variable  x -> different address just same name
        System.out.println("change = " + y);
    }
}

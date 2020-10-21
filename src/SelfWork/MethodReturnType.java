package SelfWork;

class MyMath {
    int add() {
        return 2 + 3;
    }
    int subtract() {
        return 7 - 5;
    }
    void nothing(){
        System.out.println("like this?");
    }
    String whatIsThis(){
        return "How about this?";
    }
}

public class MethodReturnType {
    //    static int add(int x, int y) {
//        // in method
//        int result = x + y; // local variable
//        return result; // return to 'int add'
//    }
//    static int multiply(int x,int y){
//        return x * y;
//    }
    public static void main(String[] args) {
        MyMath calculate = new MyMath();
        System.out.println(calculate.add());
        System.out.println(calculate.subtract());
        calculate.nothing();
        System.out.println(calculate.whatIsThis());
//        int result = add(3, 5);
//        System.out.println(result);
//        result = multiply(3, 5);
//        System.out.println(result);
    }
}

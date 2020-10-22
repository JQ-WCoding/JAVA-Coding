package SelfWork;

class MyMath { // 제일 앞에 접근 지원자를 붙여라
    public int add() {
        return 2 + 3;
    }

    public int subtract() {
        return 7 - 5;
    }

    public void nothing() {
        String x = " like this?";
        System.out.println(x);
    }

    public String whatIsThis() {
        return "How about this?";
    }
}

public class MethodReturnType {
//    public int add(){
//        return 5;
//    }
    //    static int add(int x, int y) {
//        // in method
//        int result = x + y; // local variable
//        return result; // return to 'int add'
//    }
//    static int multiply(int x,int y){
//        return x * y;
//    }
    public static void main(String[] args) {
        MyMath calculate = new MyMath(); // 객체(인스턴스)변수 선언 및 생성(생성과 동시에 초기화 됨)
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

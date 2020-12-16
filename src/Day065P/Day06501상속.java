package Day065P;

class A {
    int aa;
}

class B extends A {
    int bb;
}

class C {
    A a = new A();
    int cc;
}

public class Day06501상속 {
    /*
    상속받는 법
    1) class B 옆에 extends 부모클래스
     */
    public static void main(String[] args) {
        // B는 A를 상속받았기에 aa, bb 둘다 사용가능
        B b = new B();
        b.aa = 100;
        b.bb = 200;
        // 상속받지 않고 상속과 같은 관계
        // . 을 2번 찍어야한다
        C c = new C();
        c.cc = 100;
        c.a.aa = 200;
    }
}

package Day067P.추상화;

// # 상속
class A {
    int a;

    void test() {

    }
}

class B extends A {
    int b;
}

/**
 * # 추상화(abstract)
 * 1. 부모 클래스를 상속받은 자식 클래스에서
 * 부모 클래스의 특정 메서드를 만들도록 강제한느 것
 * 2. abstract 의 위치
 * 1) 강제할 메서드 앞에 그리고
 * 2) 클래스 앞에 붙여준다.
 */

// 1) 클래스 앞에 abstract 를 붙여줌
abstract class C {
    int c;
    // 2) 메서드 앞에 abstract 를 붙인다.
    abstract void test();
}
// 3) 클래스 c를 상속받자마자 오류가 발생
class D extends C{
    int d;
    // 4) 강제로 만드어야하는 메서드
    void test(){
        // 추상메서드를 상속 받은 경우 꼭 사용해야 한다
    }
}
public class Day067추상화 {
    public static void main(String[] args) {
        // C c = new C();
        // 추상 클래스는 메모리 생성이 불가능하다
    }
}

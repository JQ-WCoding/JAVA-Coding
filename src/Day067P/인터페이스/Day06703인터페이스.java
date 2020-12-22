package Day067P.인터페이스;

/**
 * 추상 클래스 안에 메서드를 작성할 때
 * abstract를 붙인 메서드(추상 메서드)와
 * 안붙은 메서드(일반 메서드) 모두 만들 수 있다
 */
abstract class AA {
    abstract void test1(); // 추상 메서드 -> 구현되어 있지 않기에 {} 가 존재하지 않는다

    void test2() {
    } // 일반메서드
}

/**
 * 자식 클래스에서는 abstract가 붙어있는 메서드를 강제로 구현해야한다
 */
class BB extends AA {
    @Override
    void test1() {

    }
}

interface EE {
    /* public abstract */ void test3();

    /* public static final */ int NUM = 10;
}

interface CC {
    void test1();

    void test2();
}

/**
 * interface를 구현하면(implements) 메서드를 무조건 강제 구현해야한다.
 */
class DD implements EE, CC {
    @Override
    public void test1() {

    }

    @Override
    public void test2() {

    }

    @Override
    public void test3() {

    }
}

/**
 * # 인터페이스(interface)
 * 1. 인터페이스는 추상 클래스보다 더 추상화된 클래스이다.(강제성)
 * 2. 실제 구현된 것이 전혀 없는 기본 설계도이다.
 * 3. 상수와 추상 메서드만 멤버로 갖는다.
 * 4. 인스턴스를 생성할 수 없고, 클래스 작성에 도움을 줄 목적으로 사용되는 클래스이다.
 * 5. 다중 상속이 가능하다
 */
public class Day06703인터페이스 {
    public static void main(String[] args) {

    }
}

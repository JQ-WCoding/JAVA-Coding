package Day065P;

class Parent {
    public void test() {
        System.out.println("testParent()");
    }
}

class ChildTest extends Parent {
    @Override
    public void test() {
        // 자식의 변수나 메서드가 부모의 변수나 메서드와 이름이 같다면 super 로 구분
        super.test(); // 자식 메서드에서 부모의 test 를 또 실행시키고 싶다면 super 를 사용
        System.out.println("testChild()");
    }
}

public class Day06504super {
    public static void main(String[] args) {
        ChildTest childTest = new ChildTest();
        childTest.test();
    }
}

package Day065P;

class MethodOverloading {
    public void test(int a){};
    public void test(int a, int b){};
    public void test(String a){};
}
class MethodOverride{
    public void test(){
        System.out.println("testParent");
    }
    public void overrideTest(){
        System.out.println("overrideTestParent");
    }
}
class Child extends  MethodOverride{
    @Override
    public void overrideTest() {
        System.out.println("overrideTestChild");
    }
}
public class Day06503메서드오버라이드 {
    public static void main(String[] args) {
        /*
        1) 메서드 오버로딩
        2) 메서드 오버라이드

       메서드 오버로딩은 메서드 이름을 여러개 사용할 수 있는 기능
       메서드 오버라이드는 부모에 있는 메서드를 자식이 같은 이름으로 만들어서 사용(재활용)
         */
        Child child = new Child();
        child.test(); // 부모 메서드 사용가능
        child.overrideTest(); // 부모의 메서드는 실행되지 않고 자식의 메서드가 우선순위를 가진다
    }
}

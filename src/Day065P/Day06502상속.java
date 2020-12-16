package Day065P;

// Object 는 기본 상속되어있다
class ExtendsTest1 extends Object {
    int b;
}

class ExtendsTest2 {
    int a;
}

public class Day06502상속 {
    public static void main(String[] args) {
        ExtendsTest1 test1 = new ExtendsTest1();
        ExtendsTest2 test2 = new ExtendsTest2();
        /*
        자바는 어떤 클래스던지 Object 클래스를 자동으로 상속
        === toString ===
        toString() 은 Object 클래스에 만들어져있는 메서드
        원형은 test1.toString 이지만 펴의상 toString()은 생략가능
        toString() 은 메모리 주소 출력
         */
        System.out.println(test1.toString());
        System.out.println(test1); // 두 결과는 동일하다
    }
}

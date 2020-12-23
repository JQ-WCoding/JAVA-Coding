package Day069P.Day06903instanceOf;

class Parent {
    int x;
}

class Child extends Parent {
    int y;
}

public class Day06903 {
    public static void main(String[] args) {
        /*
        클래스 형변환
       parent 변수는 new 할때 Parent에 있는 내용만 생성한다.
       반면 chile 변수는 new 할때 Parent와 Child 둘 다 생성된다
       결국
       child 변수는 Parent로 형변환이 가능하고
       parent 변수는 Child로 형변환이 불가능하다
         */
        Parent parent = new Parent();
        Child child = new Child();

        // child는 둘다 가지고 있기 때문에 가능
        Parent p = (Parent) child;

        /*
        parent는 한개만 가지고 있기 대문에 에러가 발생한다
        java.lang.ClassCastException
        Child c = (Child) parent;
         */

        // 안전하게 instanceof를 사용해 판별가능

        Parent tempParent = null;
        Child tempChild = null;

        if (child instanceof Parent) {
            tempParent = (Parent) child;
        } else {
            System.out.println("형변환 불가 1");
        }

        if (parent instanceof Child) {
            tempChild = (Child) parent;
        } else {
            System.out.println("형변환 불가2");
        }
    }
}

package Day069P.Day06904instanceOf;

import java.util.Objects;

class Person {
    String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {

        Person person = (Person) object;

        if (object instanceof Person) {
            if (name.equals(person.name)) {
                return true;
            }
        }
        return false;
    }
}

public class Day06904 {
    public static void main(String[] args) {
        Person p1 = new Person("홍길동");
        Person p2 = new Person("홍길동");

        /*
        equals() 메서드를 오버라이딩 하기 전에는
        본래 equals() 메서드의 역할은 주소 비교이기 때문에
        결과는 false가 나온다
         */
        System.out.println(p1.equals(p2));
    }
}

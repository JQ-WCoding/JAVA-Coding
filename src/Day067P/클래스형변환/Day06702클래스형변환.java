package Day067P.클래스형변환;
class Parent{
    int x;
}
class Child extends Parent{
    int y;
}
public class Day06702클래스형변환 {
    public static void main(String[] args) {
        Parent p = new Parent();
        p.x = 10;

        Child c = new Child();
        c.x = 5;
        c.y = 6;

        Parent p1 = (Parent) c;
        System.out.println(p1.x); //5

        Child c2 = (Child) p1;
        System.out.println(c2.y); // 6
    }
}

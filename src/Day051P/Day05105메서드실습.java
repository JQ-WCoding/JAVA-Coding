package Day051P;

public class Day05105메서드실습 {
    public static void main(String[] args) {
        Ex04 ex04 = new Ex04();

        int x = 56;

        ex04.setValue(x);
        System.out.println(x);

    }
}
class Ex04{
    public void setValue(int x){
        x = 100;
    }
}

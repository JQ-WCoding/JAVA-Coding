package Day055P;
class Fruit{
    String name;
    int price;

    // 기본 생성자
    // 기본 생성자는 자동 생성이지만 추가적인 생성자가 만들어지면 기본 생성자도 작성해주어야 한다
    public Fruit(){}

    // 생성자 오버로딩
    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void setData(String name, int price){
        this.name = name;
        this.price = price;
    }

    public void printData(){
        System.out.println(name + " : " + price);
    }
}
public class Day05503생성자오버로딩2 {
    public static void main(String[] args) {
        Fruit apple = new Fruit();

        // 1
        apple.name = "사과";
        apple.price = 1000;
        apple.printData();

        // 2
        Fruit banana = new Fruit();
        banana.setData("바나나", 2000);
        banana.printData();

        // 3
        Fruit melon = new Fruit("멜론", 3000);
        melon.printData();
    }
}

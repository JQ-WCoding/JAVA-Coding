package Day055P;

class Product {
    String name;
    int price;

    public Product() {
        name = "박스";
        price = 1000;
        System.out.println("기본 생성자");
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void printProduct() {
        System.out.println(name + " : " + price);
    }
}

public class Day05502생성자오버로딩 {
    public static void main(String[] args) {
        // 기본 생성자
        Product p1 = new Product();
        p1.printProduct();
        // 생성자 오버로딩
        Product p2 = new Product("빈박스", 200);
        p2.printProduct();
    }
}

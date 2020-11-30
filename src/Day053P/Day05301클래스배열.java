package Day053P;

class Product {
    String name;
    int price;
}

public class Day05301클래스배열 {
    public static void main(String[] args) {
        int[] arr = new int[3];
        int[][] arr2 = new int[2][3];

        Product pr = new Product();
        pr.name = "감자깡";
        pr.price = 1000;

        Product[] products = new Product[2];

        // 각 배열의 새로운 영역을 선언해줘야한다.
        products[0] = new Product();
        products[1] = new Product();

        products[0].price = 10;
        products[1].price = 20;

        products[0].name = "새우깡";
        products[1].name = "고래밥";
    }
}

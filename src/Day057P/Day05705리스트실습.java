package Day057P;

import java.util.ArrayList;

class Tv {
    String name;
    String brand;
    int price;

    public Tv(String name, String brand, int price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }
}

public class Day05705리스트실습 {
    public static void main(String[] args) {
        ArrayList<Tv> list = new ArrayList<>();

        Tv temp = new Tv("TV", "삼성", 1000);
        list.add(temp);

        temp = new Tv("시그니터TV", "LG", 2000);
        list.add(temp);

        temp = new Tv("스마트Tv", "Apple", 3000);
        list.add(temp);

        temp = list.get(1);
        System.out.println(temp.name + temp.brand + temp.price);
    }
}

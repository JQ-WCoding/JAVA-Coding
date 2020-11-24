package Day050P;

class Ex01 {
    int x;
    int y;
}

public class Day05001클래스이론1 {
    public static void main(String[] args) {
        Ex01 e = new Ex01();
        e.x = 10;
        e.y = 20;

        System.out.println(e); // 주소가 출력된다. 클래스도 주소변수이다.
        System.out.println(e.x);
        System.out.println(e.y);

        int[] arr = new int[2];
        System.out.println(arr);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }
}

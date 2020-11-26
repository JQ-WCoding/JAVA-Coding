package Day052P;

class MethodOverloading {

    int add(int x, int y) {
        return x + y;
    }

    int add(int x, int y, int z) {
        return x + y + z;
    }

    int add(int[] arr) {
        int total = 0;
        for (int i : arr) {
            total += i;
        }
        return total;
    }
}

public class DAy05204메서드오버로딩 {
    public static void main(String[] args) {
        MethodOverloading overloading = new MethodOverloading();

        int[] arr = {1, 2, 3, 4, 5};

        int r1 = overloading.add(10, 3);
        int r2 = overloading.add(10, 3, 1);
        int r3 = overloading.add(arr);

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
    }
}

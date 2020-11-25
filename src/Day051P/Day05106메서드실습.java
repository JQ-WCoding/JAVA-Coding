package Day051P;

public class Day05106메서드실습 {
    public static void main(String[] args) {
        Ex05 ex = new Ex05();
        int[] arr = {10, 20, 30, 40, 50};

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 배열은 주소가 전달되기 때문에 값이 변경된다 ***** 중요!
        ex.changeValueInArray(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

class Ex05 {
    public void changeValueInArray(int[] arr) {
        arr[1] = 100;
    }
}

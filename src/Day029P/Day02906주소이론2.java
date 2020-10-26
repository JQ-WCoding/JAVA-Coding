package Day029P;

public class Day02906주소이론2 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int[] temp = arr; // 주소를 전달한다
        System.out.println("arr = " + arr);
        System.out.println("temp = " + temp);
        // 같은 주소
        temp[0] = 100; // arr[0] 도 같은 주소에서 값을 가져오기에 100이다

        System.out.println(arr[0]);
    }
}

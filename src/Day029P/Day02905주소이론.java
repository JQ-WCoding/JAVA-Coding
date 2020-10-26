package Day029P;

public class Day02905주소이론 {
    public static void main(String[] args) {
        // stack에 생성
        int x;
//        System.out.println(x);
//        heap에 생성
        int[] arr = new int[3];  //java 코드에서 new가 등장하면 무조건 heap 생성
        System.out.println(arr[0]); // 값
        System.out.println(arr); // 주소
    }
}

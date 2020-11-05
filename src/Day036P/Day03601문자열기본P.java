package Day036P;

import java.util.Arrays;

public class Day03601문자열기본P {
    public static void main(String[] args) {
        String str = "AppleTree";
        System.out.println(str);

        int size = str.length(); // String 문자열의 길이
        System.out.println(size);

        System.out.println(str.charAt(5)); // T 출력됨

        System.out.println(str.substring(0, 5)); // index1 부터 index2 미만까지

        System.out.println(str.substring(5)); // index 부터 끝까지 툴력

        String name = "java, jsp, spring";
        String[] arr = name.split(",");
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

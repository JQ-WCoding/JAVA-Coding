package Day020_P;

public class Day02007MiniBingo {
    public static void main(String[] args) {
        int arr[] = {
                0, 0, 0,
                0, 0, 0,
                3, 3, 3
        };

        // 문제1) 배열을 위와 같이3줄씩 출력
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if (i % 3 == 2) {
                System.out.println();
            }
        }
        // 문제2) 만약에 가로에 3이 연속으로 3개있으면 "빙고" 출력
//        for (int i = 0; i < arr.length; i++) {
//            if (i >= 0 && i < arr.length - 2) {
//                if (arr[i] == 3 && arr[i + 1] == 3 && arr[i + 2] == 3) {
//                    System.out.println("Bingo!");
//                }
//            }
//        }
        for (int i = 0; i < arr.length; i += 3) {
            if (arr[i] == 3 && arr[i + 1] == 3 && arr[i + 2] == 3) {
                System.out.println("Bingo!");
            }
        }
    }
}

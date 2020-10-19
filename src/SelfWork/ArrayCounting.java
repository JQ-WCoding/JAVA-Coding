package SelfWork;
// 20/10/19
public class ArrayCounting {
    public static void main(String[] args) {
        int[] numArr = new int[10]; // 임의 수 저장소
        int[] counter = new int[10]; // 임의 수 카운팅

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = (int) (Math.random() * 10);
            System.out.print(numArr[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < numArr.length; i++) {
            counter[numArr[i]]++;
        }
        for (int i = 0; i < numArr.length; i++) {
            System.out.println(i + "의 개수 : " + counter[i] + "개");
        }
    }
}

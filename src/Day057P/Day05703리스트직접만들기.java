package Day057P;

import java.util.Scanner;

class MyArray {
    int[] arr;
    int count;

    /**
     * 출력 메소드
     */
    public void print() {
        System.out.print("[");
        for (int i = 0; i < count; i++) {
            System.out.print(arr[i]);
            if (i != count - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    /**
     * 합 메소드
     *
     * @param value
     */
    public void add(int value) {
        if (count == 0) {
            arr = new int[count + 1];
        } else if (count > 0) {
            int[] temp = arr;
            arr = new int[count + 1];

            for (int i = 0; i < count; i++) {
                arr[i] = temp[i];
            }
            temp = null;
        }
        arr[count] = value;
        count++;
    }

    /**
     * add method overload
     */
    public void add(int index, int value) {
        if (count == 0) {
            arr = new int[count + 1];
        } else if (count > 0) {
            int[] temp = arr;
            arr = new int[count + 1];

            int j = 0;
            for (int i = 0; i < count + 1; i++) {
                if (i != index) {
                    arr[i] = temp[j];
                    j++;
                }
            }
            temp = null;
        }
        arr[index] = value;
        count++;
    }

    /**
     * remove method
     *
     * @param index
     */
    public void remove(int index) {
        if (count == 1) {
            arr = null;
        } else if (count > 1) {
            int[] temp = arr;
            arr = new int[count - 1];

            int j = 0;
            for (int i = 0; i < count; i++) {
                if (i != index) {
                    arr[j] = temp[i];
                    j++;
                }
            }
            temp = null;
        }
        count--;
    }

    /**
     * size method
     */
    public int size() {
        return count;
    }
}

public class Day05703리스트직접만들기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MyArray list = new MyArray();

        list.add(10);
        list.add(0,20);
        list.print();

//        while (true){
//            list.print();
//
//            System.out.println("1) 추가 2) 삽입 3) 삭제 4) 종료");
//            int selector = scanner.nextInt();
//
//            if (selector == 1){
//
//            }
//        }
    }
}

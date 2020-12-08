package Day057P;

import java.util.Vector;

public class Day05704벡터 {
    public static void main(String[] args) {
        // Vector 는 ArrayList 와 똑같은것이다.
        // (ArrayList 이전에 만들어진 것으로 ArrayList 가 성능이 더 좋다.)

        Vector<Integer> list = new Vector<>();

        // add(value) : Vector 의 맨 뒤에 value 를 추가한다
        for (int i = 1; i <= 5; i++) {
            list.add(i * 10);
        }
        System.out.println(list);

        // remove(index) : Vector 의 index 번째 데이터를 제거된다
        list.remove(3);
        System.out.println(list);

        // size() : Vector 에 저장된 데이터의 개수를 얻어온다
        int count = list.size();
        System.out.println("count = " + count);

        // get() : Vector 의 index 번째의 value 를 얻어온다
        System.out.print("[");
        for (int i = 0; i < count; i++) {
            System.out.print(list.get(i));
            if (i != count - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        // add(index, value) : Vector 의 index 번째 위치에 value 를 삽입한다
        list.add(0, 9);
        System.out.println(list);

        // set(index, value) : Vector 의 index 번째 위치에 value 를 수정한다
        list.set(3, 5);
        System.out.println(list);

        // clear() : Vector 의 모든 데이터를 제거한다.
        list.clear();
        System.out.println(list.size());
    }
}

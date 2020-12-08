package Day057P;

import java.util.ArrayList;

/**
 * # 배열의 한계
 * - 배열은 한번 선언하면 프로그램에서 그 크기를 바꿀 수 없다.
 *
 * # java.util.ArrayList
 * - ArrayList 클래스는 데이터가 입력되면, 자동으로 크기가 커지고
 * - 데이터가 제거되면, 자동으로 크기가 작아진다.
 * - 중간에 데이터가 삽입되면, 데이터가 삽입될 위치부터 모든 데이터가 뒤로 이동되고
 * - 중간의 데이터가 제거된 다음 위치부터 모든 데이터가 앞으로 이동한다.
 *
 * # <E>
 * - 제네릭(generic)이라 부르며 ArrayList 에 저장될 데이터 타입을
 *   반드시 클래스 타입으로 작성한다.
 * - 기본 자료형 데이터를 저장하는 ArrayList 를 만들어야 하는 경우에는
 *   래퍼 클래스를 사용한다.
 *
 *   ArrayList list = new ArrayList();                       	 // JDK 1.4 이전
 *   ArrayList<Integer> list = new ArrayList<Integer>();    	// JDK 1.5 이후
 *   ArrayList<Integer> list = new ArrayLIst<>();            	// JDK 1.7 이후
 *
 *   // ============ 주요 기능 ===============
 *   // 1) add
 *   // 2) remove
 *   // 3) clear
 *   // 4) size
 *   // 5) get
 *   // 6) set
 */
public class Day05701리스트 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // add(value) : ArrayList 의 맨 뒤에 value 를 추가한다
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        System.out.println(list);

        // remove(index) : ArrayList 의 index 번째 데이터를 제거한다.
        list.remove(3);
        System.out.println(list);

        // size() : ArrayList 에 저장된 데이터의 개수를 얻어온다
        int count = list.size();
        System.out.println("count = " + count);

        // get(index) : ArrayList 의 index 번째의 value 를 언어온다
        System.out.print("[");
        for (int i =0;i<count;i++){
            System.out.print(list.get(i));
            if (i != count - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");

        // add(index, value) : ArrayList 의 index 번째 위치에 value 를 삽입한다
        list.add(0,9);
        System.out.println(list);

        // set(index, value) : ArrayList 의 index 번째 위치에 value 를 수정한다
        list.set(3, 5);
        System.out.println(list);
    }
}

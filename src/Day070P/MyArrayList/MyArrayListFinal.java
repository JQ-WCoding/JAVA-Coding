package Day070P.MyArrayList;

import java.util.ArrayList;

class MyArrayList<T> {
    private Object[] arr;
    private int count;

    /**
     * 추가
     *
     * @param data
     */
    public void add(T data) {
        // 첫 값을 입력할 때
        if (count == 0) {
            arr = new Object[1];
        } else if (count > 0) { // 값이 1개 이상 존재할 경우
            Object[] temp = arr;

            arr = new Object[count + 1];
            for (int i = 0; i < count; i++) {
                arr[i] = temp[i];
            }
//            temp = null;
        }
        arr[count] = data;
        // 값을 추가할때마다 count 1씩 증가
        count++;
    }

    /**
     * 수정
     *
     * @param index
     * @param data
     */
    public void set(int index, T data) {
        // 해당 인덱스에 위치한 값을 변경
        arr[index] = data;
    }

    /**
     * 크기
     *
     * @return count
     */
    public int size() {
        return count;
    }

    /**
     * 가져오기
     *
     * @param index
     * @return
     */
    public T get(int index) {
        return (T) arr[index]; // 형변환
    }

    /**
     * 삭제하기
     *
     * @param index
     */
    public void remove(int index) {
        if (count == 1) {
            arr = null;
        } else {
            Object[] temp = arr;
            arr = new Object[count - 1];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = temp[i];
                if (i >= index){
                    arr[i] = temp[i + 1];
                }
            }
        }
        count--;
    }

    /**
     * 전체 삭제
     */
    public void clear() {
        if (count != 0) {
            arr = null;
            count = 0;
        }
    }

    /**
     * 빈공간 확인
     *
     * @return true or false
     */
    public boolean isEmpty() {
        return count == 0;
    }

}

class User {
    String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class MyArrayListFinal {
    public static void main(String[] args) {
        /*
        MyArrayList는 ArrayList를 모방해서 만든것
         */

        MyArrayList<User> myList = new MyArrayList<>();
        ArrayList<User> arrayList = new ArrayList<>();
        myList.add(new User("홍길동"));
        arrayList.add(new User("홍길동"));

        myList.add(new User("김민수")); // index 1 -> 최민정으로 교체될 예정
        arrayList.add(new User("김민수")); // index 1 -> 최민정으로 교체될 예정

//        myList.add();

        User temp = new User("김소정");
        myList.add(temp);
        arrayList.add(temp);

        myList.add(new User("김철수"));
        arrayList.add(new User("김철수"));

        myList.set(1, new User("최민정"));
        arrayList.set(1, new User("최민정"));

        myList.remove(2); // 김소정 삭제
        arrayList.remove(2);

        for (int i = 0; i < myList.size(); i++) {
            System.out.println((i+1));
            System.out.println("myList : " + myList.get(i).toString());
            System.out.println("arrayList : " + arrayList.get(i).toString());
        }
        System.out.println();

        myList.clear();
        arrayList.clear();

        System.out.println("myList : " + myList.isEmpty());
        System.out.println("arrayList : " + arrayList.isEmpty());
    }
}

package Day070P.MyArrayList;

class MyArrayList<T> {
    private Object[] arr;
    private int count;

    public void add(T data) {
        if (count == 0) {
            arr = new Object[1];
        } else if (count > 0) {
            Object[] temp = arr;

            arr = new Object[count + 1];
            for (int i = 0; i < count; i++) {
                arr[i] = temp[i];
            }
            temp = null;
        }
        arr[count] = data;
        count++;
    }

    public void set(int index, T data) {
        arr[index] = data;
    }

    public int size() {
        return count;
    }

    public T get(int index) {
        return (T) arr[index]; // 형변환
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

        MyArrayList<User> list = new MyArrayList<>();

        list.add(new User("홍길동"));
        list.add(new User("김민수")); // index 1 -> 최민정으로 교체될 예정

        User temp = new User("김소정");
        list.add(temp);

        list.set(1, new User("최민정"));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }
}

package Day057P;

class MyArrayList {
    Tv[] arr;
    int count;

    public void add(Tv e) {
        if (count == 0) {
            arr = new Tv[count + 1];
        } else if (count > 0) {
            Tv[] temp = arr;

            arr = new Tv[count + 1];
            for (int i = 0; i < count; i++) {
                arr[i] = temp[i];
            }
        }
        arr[count] = e;
        count++;
    }

    public int size() {
        return count;
    }

    public void remove(int index) {
        if (count == 1) {
            arr = null;
            count = 0;
        } else if (count > 1) {
            Tv[] temp = arr;

            arr = new Tv[count - 1];
            int j = 0;
            for (int i = 0; i < count; i++) {
                if (i != index) {
                    arr[j] = temp[i];
                    j++;
                }
            }
        }
        count--;
    }

    public Tv get(int index) {
        return arr[index];
    }
}

public class Day05706리스트만들어보기 {
    public static void main(String[] args) {
        MyArrayList myList = new MyArrayList();

        Tv temp = new Tv("TV", "삼성", 1000);
        myList.add(temp);

        temp = new Tv("시그니처", "LG", 2000);
        myList.add(temp);

        temp = new Tv("스마트TV", "Apple", 3000);
        myList.add(temp);

        temp = myList.get(1);
        System.out.println(temp.name);
    }
}

package Day073P;

import java.util.HashMap;

public class Practice {
    public static void main(String[] args) {
        String[] arr = {"aaa", "bbb", "ccc", "ddd", "ccc", "eee"};

        HashMap<String, Integer> count = new HashMap<>();
        for (String s : arr) {
            count.put(s, count.getOrDefault(s, 0) + 1);
        }
        System.out.println(count);
    }
}

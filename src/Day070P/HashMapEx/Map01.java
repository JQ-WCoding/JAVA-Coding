package Day070P.HashMapEx;

import java.util.HashMap;
import java.util.Map;

/**
 * # java.util.Map
 * 1. 기존의 배열은 index가 자동으로 0부터 1씩 증가하면서 순서대로 생성되었따.
 * 2. Map은 index부분을 직접 설정하는 것이다.
 * 3. Map은 index부분을 String으로 저장하고 key로 바꾸어 부른다.
 * <p>
 * 4. HashMap은 K(Key)에 V(Value)를 할당하는 방식으로 저장된다.
 * 5. Key는 String으로 하고, Value는 HashMap에 저장할 데이터의 타입을 쓴다.
 */
public class Map01 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        // put(key, value) : key라는 이름으로 value를 저장한다.
        map.put("apple", 1000);
        map.put("orange", 1400);
        map.put("melon", 5000);
        map.put("water melon", 15000);

        // size() : HashMap 의 요소의 개수
        System.out.println(map.size() + " : " + map);

        System.out.println();

        // get(key) : HashMap의 key에 할당된 value를 얻어온다.
        System.out.println(map.get("melon"));

        // put() : 존재하지 않는 key를 넣어주면 데어타가 저장되고,
        //          존재하는 key를 넣어주면 value 값이 수정된다.
        map.put("apple", 1234);
        System.out.println(map.size() + " : " + map);

        // keySet() : HashMap의 모든 key만 얻어온다.
        System.out.println(map.keySet());

        // 단축 for문과 keySet() 메서드를 이용하면
        // HashMap에 저장된 모든 데이터를 얻어올 수 있다.
        int sum = 0;
        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));

            sum += map.get(key);
        }
        System.out.println("sum = " + sum);

        // remove() : HashMap의 key에 해당되는 값을 제거한다.
        map.remove("apple");
        System.out.println(map.size() + " : " + map);

        // clear() : HashMap의 모든 값을 제거한다.
        map.clear();
        System.out.println(map.size() + " : " + map);
    }
}

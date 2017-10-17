package zhaoyin.p3;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by shugenniu on 2017/10/10.
 */

public class Foo {
    private final int CACHE_SIZE;
    private LinkedHashMap<Integer, Integer> map;

    public Foo(int size) {
        CACHE_SIZE = size;
        int capacity = (int) Math.ceil(CACHE_SIZE / 0.75f) + 1;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > CACHE_SIZE;
            }
        };
    }

    public void put(Integer key, Integer value) {
        map.put(key, value);
    }

    public Integer get(Integer key) {
        return map.get(key) == null ? -1 : map.get(key);
    }

}

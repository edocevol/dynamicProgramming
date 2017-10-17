//package zhaoyin.p3;
//
//import java.util.HashMap;
//
///**
// * Created by shugenniu on 2017/10/10.
// */
//public class FOO2 {
//    package zhaoyin.p3;
//
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.Set;
//
//    /**
//     * Created by shugenniu on 2017/10/10.
//     */
//
//    public class Foo {
//        private static class Entry{
//            zhaoyin.p3.Foo.Entry pre;
//            zhaoyin.p3.Foo.Entry next;
//            int key;
//            int value;
//        }
//
//        private final int CACHE_SIZE;
//        private zhaoyin.p3.Foo.Entry head;
//        private zhaoyin.p3.Foo.Entry tail;
//
//        private HashMap<Integer, zhaoyin.p3.Foo.Entry> cache;
//
//        public Foo(int cacheSize) {
//            CACHE_SIZE = cacheSize;
//            cache = new HashMap<>();
//        }
//
//        public void put(int key, int value) {
//            zhaoyin.p3.Foo.Entry entry = getEntry(key);
//            if (entry == null) {
//                if (cache.size() >= CACHE_SIZE) {
//                    cache.remove(tail.key);
//                    removeTail();
//                }
//                entry = new zhaoyin.p3.Foo.Entry();
//                entry.key = key;
//                entry.value = value;
//                moveToHead(entry);
//                cache.put(key, entry);
//            } else {
//                entry.value = value;
//                moveToHead(entry);
//            }
//        }
//
//        public int get(int key) {
//            zhaoyin.p3.Foo.Entry entry = getEntry(key);
//            if (entry == null) {
//                return -1;
//            }
//            moveToHead(entry);
//            return entry.value;
//        }
//
//
//
//        private void removeTail() {
//            if (tail != null) {
//                zhaoyin.p3.Foo.Entry prev = tail.pre;
//                if (prev == null) {
//                    head = null;
//                    tail = null;
//                } else {
//                    tail.pre = null;
//                    tail = prev;
//                    tail.next = null;
//                }
//            }
//        }
//
//        private void moveToHead(zhaoyin.p3.Foo.Entry entry) {
//            if (entry == head) {
//                return;
//            }
//            if (entry.pre != null) {
//                entry.pre.next = entry.next;
//            }
//            if (entry.next != null) {
//                entry.next.pre = entry.pre;
//            }
//            if (entry == tail) {
//                zhaoyin.p3.Foo.Entry prev = entry.pre;
//                if (prev != null) {
//                    tail.pre = null;
//                    tail = prev;
//                    tail.next = null;
//                }
//            }
//
//            if (head == null || tail == null) {
//                head = tail = entry;
//                return;
//            }
//
//            entry.next = head;
//            head.pre = entry;
//            entry.pre = null;
//            head = entry;
//        }
//
//        private zhaoyin.p3.Foo.Entry getEntry(int key) {
//            return cache.get(key);
//        }
//
//
//
//        public static void main(String[] args) {
//            zhaoyin.p3.Foo lru2 = new zhaoyin.p3.Foo(2);
//            lru2.put(1, 1);
//            lru2.put(2, 2);
//            System.out.println(lru2.get(1));
//            lru2.put(3, 3);
//            System.out.println(lru2.get(2));
//            lru2.put(4, 4);
//
//            System.out.println(lru2.get(1));
//            System.out.println(lru2.get(3));
//            System.out.println(lru2.get(4));
//        }
//    }
//
//}

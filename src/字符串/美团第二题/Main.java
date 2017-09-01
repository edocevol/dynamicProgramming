//package 字符串.美团第二题;
//
//import java.util.*;
//
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNext()) {
//            int n = scanner.nextInt();
//            HashMap<String,Integer> map = new HashMap<>();
//            for(int i=0;i<n;i++) {
//                map.put(scanner.next(),0);
//            }
//
//            int m = scanner.nextInt();
//            for(int i=0;i<m;i++) {
//                String net = scanner.next();
//                if(map.containsKey(net)) {
//                    int val = map.get(net);
//                    map.put(net,++val);
//                }
//            }
//            for(String key : map.keySet()) {
//                if(map.get(key) >0) {
//                    map.remove(key)
//                }
//            }
//            //对key键值按字典升序排序
//            Collection<String> keyset= map.keySet();
//            List<String> list = new ArrayList<String>(keyset);
//            Collections.sort(list);
//
//        }
//        scanner.close();
//    }
//}

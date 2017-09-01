package 字符串.美团;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            HashMap<String,Integer> map = new HashMap<>();
            for(int i=0;i<n;i++) {
                map.put(scanner.next(),0);
            }

            int m = scanner.nextInt();
            for(int i=0;i<m;i++) {
                String net = scanner.next();
                if(map.containsKey(net)) {
                    int val = map.get(net);
                    map.put(net,++val);
                }
            }

            //过虑掉大于0的
            Iterator<Map.Entry<String, Integer>> iter=map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<String, Integer> entry =  iter.next();
                if(entry.getValue()>0) {
                    iter.remove();
                }
            }
            //对key键值按字典升序排序
            Collection<String> keyset= map.keySet();
            List<String> list = new ArrayList<String>(keyset);
            Collections.sort(list);
            for(String key : list) {
                System.out.println(key);
            }

        }
        scanner.close();
    }
}

package zhaoyin;

import java.util.ArrayList;

/**
 * Created by shugenniu on 2017/10/10.
 */
public class Main {
    public static ArrayList<ArrayList<Integer>> allSubsets(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        int n = 1 << set.size();
        for (int i = 0; i < n; i++) {
            int index = 0;
            int k = i;
            ArrayList<Integer> list = new ArrayList<Integer>();
            while (k > 0) {
                if ((k & 1) > 0) {
                    list.add(set.get(index));
                }
                k >>= 1;
                index++;
            }
            lists.add(list);
        }
        return lists;
    }
}

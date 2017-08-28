package alibaba.p3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by shugenniu on 2017/8/26.
 */
public class Main {
    public static int resolve(List<Integer> list) {
        if (list == null || list.size() < 1) {
            return 0;
        }
        // 记录最大的子数组和，开始时是最小的整数
        int max = Integer.MIN_VALUE;
        // 当前的和
        int curMax = 0;
        // 数组遍历
        for (int num : list) {
            // 如果当前和小于等于0，就重新设置当前和
            if (curMax <= 0) {
                curMax = num;
            }
            // 如果当前和大于0，累加当前和
            else {
                curMax += num;
            }
            // 更新记录到的最在的子数组和
            if (max < curMax) {
                max = curMax;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextInt());
        }
        System.out.println(resolve(list));
    }
}


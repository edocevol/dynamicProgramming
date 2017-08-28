package 子数组.数组中两个元素的绝对值;

import java.util.*;

/**
 * Created by shugenniu on 2017/8/24.
 */
public class Solution {
    public int findPairs(int[] nums, int k) {
        int len = nums.length, result = 0;
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> sameSet = new HashSet<Integer>();
        if (k != 0) {
            for (int i = 0; i < len; i++) {
                //如果当前元素没有其他元素被匹配，且存在nums[i] - k被其他元素匹配过
                //这里的数组是已经拍完顺序的
                if (!set.contains(nums[i]) && set.contains(nums[i] - k))
                    result++;
                set.add(nums[i]);
            }
        }
        else {
            for (int i = 0; i < len; i++) {
                if (!sameSet.contains(nums[i]) && set.contains(nums[i])) {
                    result++;
                    sameSet.add(nums[i]);
                }
                set.add(nums[i]);
            }
        }
        return result;
    }
}

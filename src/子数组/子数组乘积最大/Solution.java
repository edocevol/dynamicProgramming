package 子数组.子数组乘积最大;

/**
 * Created by shugenniu on 2017/8/23.
 */
class Solution {
    public long maxProduct(int[] nums) {
        if(nums.length<=0) {
            return 0;
        }else if(nums.length==1) {
            return nums[0];
        }
        int len = nums.length;
        int maxDp = nums[0];//每一步的最大值
        int minDp = nums[0];//每一步的最小值
        int product = maxDp;
        for(int i=1;i<len;i++) {
            int tmp = maxDp;
            maxDp = Math.max(minDp*nums[i],Math.max(maxDp*nums[i],nums[i]));
            minDp = Math.min(Math.min(tmp*nums[i],nums[i]),minDp*nums[i]);
            product = Math.max(maxDp,product);
        }
        return product;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new int[]{2,3,-2,4}));
    }
}
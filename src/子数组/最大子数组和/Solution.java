package 子数组.最大子数组和;

/**
 * Created by shugenniu on 2017/8/23.
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length<=0) {
            return 0;
        }
        int sum = 0;
        int m = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        //dp[i + 1] = max(dp[i], dp[i] + a[i + 1])
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
            m = Math.max(sum,m);
            if(sum < 0 ) {
                sum = 0;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int res = new Solution().maxSubArray(arr);
        System.out.println(res);
    }
}
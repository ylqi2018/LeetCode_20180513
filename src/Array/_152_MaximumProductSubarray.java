package Array;

public class _152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for(int i=1; i<nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max*nums[i], min*nums[i]), nums[i]);
            min = Math.min(Math.min(temp*nums[i], min*nums[i]), nums[i]);
            if(max > res) {
                res = max;
            }
        }
        return res;
    }
}

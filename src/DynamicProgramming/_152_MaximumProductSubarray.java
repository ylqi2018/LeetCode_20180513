package DynamicProgramming;

public class _152_MaximumProductSubarray {

	/*
	 * Method 1
	 */
	public int maxProduct(int[] nums) {
		if(nums==null || nums.length==0) {
			return 0;
		}
		int minVal = nums[0];
		int maxVal = nums[0];
		int res = nums[0];
		for(int i=1; i<nums.length; i++) {
			int temp = minVal;
			minVal = Math.min(Math.min(maxVal*nums[i], minVal*nums[i]), nums[i]);
			maxVal = Math.max(Math.max(maxVal*nums[i], temp*nums[i]), nums[i]);
			if(maxVal > res) {
				res = maxVal;
			}
		}
		return res;
	}
}

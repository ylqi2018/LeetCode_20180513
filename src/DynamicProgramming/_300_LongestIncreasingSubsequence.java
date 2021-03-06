package DynamicProgramming;

import java.util.Arrays;

public class _300_LongestIncreasingSubsequence {

	/*
	 * Method 1.
	 */
	public int lengthOfLIS(int[] nums) {
		if(nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		dp[0] = 1;
		int maxans = 1;
		for(int i=1; i<nums.length; i++) {
			int maxVal = 0;
			for(int j=0; j<i; j++) {
				if(nums[i] > nums[j]) {
					maxVal = Math.max(maxVal, dp[j]);
				}
			}
			dp[i] = maxVal + 1;
			maxans = Math.max(maxans, dp[i]);
		}
		return maxans;
	}
	
	/*
	 * Method 2.
	 */
	public int lengthLIS1(int[] nums) {
		int[] dp = new int[nums.length];
		int len = 0;
		for(int num: nums) {
			int i = Arrays.binarySearch(dp, 0, len, num);
			if(i < 0) {
				i = -(i + 1);
			}
			dp[i] = num;
			if(i == len) {
				len++;
			}
		}
		return len;
	}
}

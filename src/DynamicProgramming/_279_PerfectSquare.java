package DynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _279_PerfectSquare {
	public int numSquares(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for(int i = 1; i <= n; ++i) {
			int min = Integer.MAX_VALUE;
			int j = 1;
			while(i - j*j >= 0) {
				min = Math.min(min, dp[i - j*j] + 1);
				++j;
			}
			dp[i] = min;
		}		
		return dp[n];
	}
	
	/*
	 * Method 2.
	 */
	public int numSquares1(int n) {
		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> set = new HashSet<>();
		int step = 0;
		queue.offer(n);
		while(!queue.isEmpty()) {
			
		}
	}
	
}

package DynamicProgramming;

public class _62_Unique_Paths {
	/*
	 * Method 1. Dynamic Programming of 2D.
	 */
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for(int i=0; i<n; i++) {
            dp[i] = 1;
        }
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                dp[j] = dp[j-1] + dp[j];
            }
        }
        return dp[n-1];
    }
    
    /*
     * Method 2. More space.
     */
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i > 0) {
                    dp[i][j] += dp[i-1][j];
                }
                if(j > 0) {
                    dp[i][j] += dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}

package DynamicProgramming;

public class _91_DecodeWays {

	/*
	 * Method 1
	 */
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i=2; i<=len; i++) {
            int one = Integer.valueOf(s.substring(i-1, i));
            int two = Integer.valueOf(s.substring(i-2, i));
            if(one >= 1 && one <= 9) {
                dp[i] += dp[i-1];
            }
            if(two >=10 && two <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[len];
    }
    
    /*
     * Method 2.
     */
    public int numDecodings1(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i=2; i<=n; i++) {
            if(s.charAt(i-1) > '0') {
                dp[i] += dp[i-1];
            }
            if(s.charAt(i-2)=='1' || s.charAt(i-2)=='2' && s.charAt(i-1)<'7') {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}

package DynamicProgramming;

public class _44_WildcardMatching {
	/*
	 * Method 1. DP
	 */
	public boolean isMatch(String s, String p) {
        if(s == "" && p == "")
            return true;
        else if(s == "" || p == "")
            return false;
        int i = 0;
        int j = 0;
        int match = 0;
        int seq = -1;
        while(i < s.length()){
            if(j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')){
                i++;
                j++;
            }
            else if(j < p.length() && p.charAt(j) == '*'){
                seq = j;
                match = i;
                j++;
            }
            else if(seq != -1){
                j = seq + 1;
                match++;
                i = match;
            }
            else
                return false;
        }
        
        while(j < p.length() && p.charAt(j) == '*')
            j++;
        
        return j==p.length();
    }
    
    /*
     * Method 2. DP
     */
    public boolean isMatch1(String s, String p) {
        if(s.equals("") && p.equals("")) {
            return true;
        }
        if(!s.equals("") && p.equals("")) {
            return false;
        }
        
        boolean dp[][] = new boolean[p.length()+1][s.length()+1];
        dp[0][0] = true;
        
        if(p.charAt(0) == '*') {
            dp[1][0] = true;
        }
        for(int i=0; i<=p.length(); i++) {
            for(int j=0; j<=s.length(); j++) {
                if(i==0 && j==0) {
                    dp[i][j] = true;
                } else if(i == 0 && j > 0) {
                    dp[i][j] = false;
                } else if(p.charAt(i-1) == '*') {
                    if(j == 0) {
                        dp[i][j] = dp[i-1][j];
                    } else {
                        dp[i][j] = dp[i-1][j] || dp[i][j-1];
                    }
                } else if(j > 0 && (p.charAt(i-1) == '?' || p.charAt(i-1) == s.charAt(j-1))) {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}

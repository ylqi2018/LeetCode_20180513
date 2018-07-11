package DynamicProgramming;

public class _10_RegularExpressionMatching {
	/*
	 * Method 1. Recursion.
	 */
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) {
            return s.isEmpty();
        }
        boolean firstMatch = !s.isEmpty() && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.');
        if(p.length() >= 2 && p.charAt(1) == '*') {
            return (firstMatch && isMatch(s.substring(1), p)) || isMatch(s, p.substring(2));
        } else {
            return (firstMatch && isMatch(s.substring(1), p.substring(1)));
        }
    }
    
    /*
     * Method 2.
     */
    boolean[][] memo;
    public boolean isMatch1(String s, String p) {
    	memo = new boolean[s.length()+1][p.length()+1];
    	return match(0, 0, s, p);
    }
    
    private boolean match(int i, int j, String s, String p) {
    	if(memo[i][j] != false) {
    		return memo[i][j] == true;
    	}
    	boolean ans;
    	if(j == p.length()) {
    		ans = i == s.length();
    	} else {
    		boolean firstMatch = (i < s.length() &&
    				(p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));
    		if(j+1 < p.length() && p.charAt(j+1)=='*') {
    			ans = (match(i, j+2, s, p)) || (firstMatch && match(i+1, j, s, p));
    		} else {
    			ans = firstMatch && match(i+1, j+1, s, p);
    		}
    	}
    	memo[i][j] = ans ? true : false;
    	return ans;
    }
    
    /*
     * Method 3.
     */
    public boolean isMatch2(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return isMatch(s, p, 0, 0, memo);
    }

    private boolean isMatch(String s, String p, int i, int j, Boolean[][] memo){
        if (j == p.length()){
            return i == s.length();
        }
        if (memo[i][j] != null){
            return memo[i][j];
        }
        if (j + 1 < p.length() && p.charAt(j+1) == '*'){
            memo[i][j] = isMatch(s, p, i, j + 2, memo) || i < s.length() && match(s.charAt(i), p.charAt(j)) && isMatch(s, p, i + 1, j, memo);
            return memo[i][j];
        }
        memo[i][j] = i < s.length() && match(s.charAt(i), p.charAt(j)) && isMatch(s, p, i + 1, j + 1, memo);
        return memo[i][j];
    }

    private boolean match(char sChar, char pChar){
        return pChar == '.' || sChar == pChar;
    }
}

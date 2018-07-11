package DynamicProgramming;

public class _5_Longest_PalindromicSubstring {

	/*
	 * Method 1.
	 */
	private int lo;
    private int maxLen = 0;
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2) {
            return s;
        }
        for(int i=0; i<len-1; i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i+1);
        }
        return s.substring(lo, lo+maxLen);
    }
    
    private void extendPalindrome(String s, int j, int k) {
        while(j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if(maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
    
    /*
     * Method 2.
     */
    
    public static void main(String[] args) {
    	_5_Longest_PalindromicSubstring test = new _5_Longest_PalindromicSubstring();
    	String s = "abcdmadamabcd";
    	String res = test.longestPalindrome(s);
    	System.out.println(res);
    }
}

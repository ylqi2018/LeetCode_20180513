package DynamicProgramming;

import java.util.Arrays;
import java.util.List;

public class _139_WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		int len = s.length();
		String hold = s;
		// Fix pointer at 0 and traverse from right end, trying different substrings.
		for(int i=s.length(); i>=0; i--) {
			String check = s.substring(0, i);
			if(wordDict.contains(check)) {
				s = s.substring(i, len);
				i = s.length() + 1;
				len = s.length();
			}
		}
		if(s.equals("")) {
			return true;
		} else { //fix pointer at length of the string and traverse from left to see if any subtring matches
			s = hold;
			len = s.length();
			for(int i=0; i<=len; i++) {
				String check = s.substring(i,len);
				if(wordDict.contains(check)) {
					s = s.substring(0, i);
					i = -1;
					len = s.length();
				}
			}
		}
		if(s.equals("")) {
			return true;
		} else {
			return false;
		}
	}
	
//	public boolean wordBreak1(String s, List<String> wordDict) {
//		int[][] dp = new int[s.length()][s.length()];
//		
//		for(int i=0; i < dp.length; i++) {
//			for(int j=0; j < dp[i].length; j++) {
//				dp[i][j] = -1;	// -1 indicates string between i to j cannot be split.
//			}
//		}
//		
//		// fill up the matrix in bottom up manner
//		for(int l=1; l<=s.length(); l++) {
//			for(int i=0; i<s.length()-l+1; i++) {
//				int j = i + l - 1;
//				String str = s.substring(i, j+1);
//				// if string between i and j is in dictionary T[i][j] is true
//				if(wordDict.contains(str)) {
//					dp[i][j] = i;
//					continue;
//				}
//				// find a k between i+1 to j such that dp[i][k-1] && t[k][j] are both true
//				for(int k=i+1; k<=j; k++) {
//					if(dp[i][k-1] != -1 && dp[k][j] != -1) {
//						dp[i][j] = k;
//						break;
//					}
//				}
//			}
//		}
//		if(dp[0][s.length()-1] == -1) {
//			return false;
//		} else {
//			return true;
//		}
//	}
	
	/*
	 * Method 2.
	 */
	public boolean wordBreak1(String s, List<String> wordDict) {
		int[][] dp = new int[s.length()][s.length()];
		
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				dp[i][j] = -1;	// -1 indicates string between i to j cannot be split.
			}
		}
		
		// fill up the matrix in bottom up manner.
		for(int l=1; l<=s.length(); l++) {
			for(int i=0; i<s.length()-l+1; i++) {
				int j = i + l - 1;
				String check = s.substring(i, j+1);
				// if string between i and j is in dictionary, dp[i][j] is true
				if(wordDict.contains(check)) {
					dp[i][j] = i;
					continue;
				}
				// find a k between i+1 to j such that dp[i][k-1] and dp[k][j] are both true
				for(int k=i+1; k <= j; k++) {
					if(dp[i][k-1] != -1 && dp[k][j] != -1) {
						dp[i][j] = k;
						break;
					}
				}
			}
		}
		if(dp[0][s.length()-1] == -1) {
			return false;
		} else {
			return true;
		}
	}
	
	/*
	 * Method 3.
	 */
	public boolean wordBreak2(String s, List<String> wordDict) {
		int[] memo = new int[s.length()];
		Arrays.fill(memo, -1);
		return canBreak(0, s, wordDict, memo);
	}
	
	private boolean canBreak(int start, String s, List<String> wordDict, int[] memo) {
		if(start >= s.length()) {
			return true;
		}
		if(memo[start] != -1) {
			return memo[start] == 1;
		}
		String subs = s.substring(start);
		for(int w=0; w<wordDict.size(); w++) {
			if(subs.startsWith(wordDict.get(w))) {
				boolean result = canBreak(start+wordDict.get(w).length(), s, wordDict, memo);
				if(result) {
					memo[start] = 1;
					return true;
				}
			}
		}
		memo[start] = 0;
		return false;
	}
	
}

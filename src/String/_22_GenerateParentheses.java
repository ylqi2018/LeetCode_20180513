package String;

import java.util.ArrayList;
import java.util.List;

public class _22_GenerateParentheses {
	
	/*
	 * Method 1.
	 */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    private void backtrack(List<String> list, String str, int open, int close, int n) {
        if(str.length() == 2 * n) {
            list.add(str);
        }
        if(open < n) {
            backtrack(list, str + "(", open+1, close, n);
        }
        if(close < open) {
            backtrack(list, str + ")", open, close+1, n);
        }
    }
    
    /*
     * Method 2.
     */
    public List<String> generateParenthesis1(int n) {
    	List<String> res = new ArrayList<>();
    	dfs(res, new StringBuilder(), 0, 0, n);
    	return res;
    }
    
    private void dfs(List<String> res, StringBuilder sb, int left, int right, int n) {
    	if(right == n) {
    		res.add(sb.toString());
    		return;
    	}
    	if(right < left) {
    		sb.append(")");
    		dfs(res, sb, left, right+1, n);
    		sb.setLength(sb.length()-1);
    	}
    	if(left < n) {
    		sb.append("(");
    		dfs(res, sb, left+1, right, n);
    		sb.setLength(sb.length()-1);
    	}
    }
}

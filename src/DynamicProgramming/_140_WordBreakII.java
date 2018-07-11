package DynamicProgramming;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class _140_WordBreakII {
	/*
	 * Method 1.
	 */
    public List<String> wordBreak(String s, List<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }
    
    private List<String> DFS(String s, List<String> wordDict, HashMap<String, LinkedList<String>> map) {
        if(map.containsKey(s)) {
            return map.get(s);  // the returned value should be a list
        }
        
        LinkedList<String> res = new LinkedList<>();
        if(s.length() == 0) {
            res.add("");
            return res;
        }
        for(String word: wordDict) {
            if(s.startsWith(word)) {
                List<String> sublist = DFS(s.substring(word.length()), wordDict, map);
                for(String sub: sublist) {
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}

package String;

import java.util.HashMap;
import java.util.Map;

public class _3_LongestSubstringWithoutRepeatingCharacters {

	/*
	 * Method 1.
	 */
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2) {
            return s.length();
        }
        Map<Character, Integer> map = new HashMap<>();
        int h = 0;
        int len = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, i);
            } else {
                if(map.get(c) < h) {
                    map.put(c, i);
                } else {
                    len = Math.max(len, i - h);
                    h = map.get(c) + 1;
                    map.put(c, i);
                }
            }
        }
        return Math.max(s.length()-h, len);
    }
    
    /*
     * Method 2.
     */
    public int lengthOfLongestSubstring1(String s) {
        if(s.length() < 2) {
            return s.length();
        }
        boolean[] set = new boolean[256];
        int start = 0;
        int len = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            while(set[c]) {
                set[s.charAt(start)] = false;
                start++;
            }
            len = Math.max(len, i - start + 1);
            set[c] = true;
        }
        return len;
    }
}

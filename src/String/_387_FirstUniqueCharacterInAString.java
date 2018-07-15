package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class _387_FirstUniqueCharacterInAString {

	/*
	 * Method 1.
	 */
	public int firstUniqChar(String s) {
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<len; i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        int index = Integer.MAX_VALUE;
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            if(entry.getValue() == 1) {
                index = Math.min(s.indexOf(entry.getKey()), index);
            }
        }
        return index == Integer.MAX_VALUE ? -1 : index;
    }
	
	/*
	 * Method 2.
	 */
    public int firstUniqChar1(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(set.contains(c)) {
                if(map.get(c) != null) {
                    map.remove(c);
                }
            } else {
                map.put(c, i);
                set.add(c);
            }
        }
        
        return map.size() == 0 ? -1 : map.entrySet().iterator().next().getValue();
    }
    
    /*
     * Method 3.
     */
    public int firstUniqChar2(String s) {
    	int[] freq = new int[26];
    	for(int i=0; i<s.length(); i++) {
    		freq[s.charAt(i)-'a']++;
    	}
    	for(int i=0; i<s.length(); i++) {
    		if(freq[s.charAt(i)-'a'] == 1) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    /*
     * Method 4.
     */
    public int firstUniqChar3(String s) {
    	int res = Integer.MAX_VALUE;
    	for(char c='a'; c<='z'; c++) {
    		int index = s.indexOf(c);
    		if(index != -1 && index == s.lastIndexOf(c)) {
    			res = Math.min(res, index);
    		}
    	}
    	return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    /*
     * Method 5.
     */
    public int firstUniqChar4(String s) {
        if (s==null || s.length()==0) return -1;
        int len = s.length();
        if (len==1) return 0;
        char[] cc = s.toCharArray();
        int slow =0, fast=1;
        int[] count = new int[256];
        count[cc[slow]]++;
        while (fast < len) {
            count[cc[fast]]++;
            // if slow pointer is not a unique character anymore, move to the next unique one
            while (slow < len && count[cc[slow]] > 1) slow++;  
            if (slow >= len) return -1; // no unique character exist
            if (count[cc[slow]]==0) { // not yet visited by the fast pointer
                count[cc[slow]]++; 
                fast=slow; // reset the fast pointer
            }
            fast++;
        }
        return slow;
    }
	
}

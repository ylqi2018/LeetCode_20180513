package HashTable;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class _387_FirstUniqueCharacterInAString {

	/*
	 * Method 1. count the freq
	 */
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for(int i=0; i<s.length(); i++) {
            if(freq[s.charAt(i)-'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
    
    /*
     * Method 2. LinkedHashMap
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
     * Method 3
     */
    public int firstUniqChar2(String s) {
        int resIndex = s.length();
        
        if(resIndex == 0) {
            return -1;
        }
        
        for(char c='a'; c<='z'; c++) {
            int index = s.indexOf(c);
            if(index != -1 && index == s.lastIndexOf(c)) {
                resIndex = Math.min(resIndex, index);
            }
        }
        return resIndex == s.length() ? -1 : resIndex;
    }
}

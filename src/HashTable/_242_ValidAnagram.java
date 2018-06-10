package HashTable;

import java.util.Arrays;

public class _242_ValidAnagram {

	/*
	 * Method 1. Sorting
	 */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
    
    /*
     * Method 2. Hash Table
     */
    public boolean isAnagram1(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        
        int[] counter = new int[26];
        for(int i=0; i<s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for(int count: counter) {
            if(count != 0) {
                return false;
            }
        }
        return true;
    }
    
    /*
     * Method 3. Hash Table
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
    
    /*
     * Method 4. sorting
     */
    public boolean isAnagram3(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        
        if(s.length() == 0) {
            return true;
        }
        
        char[] str1 = s.toCharArray();
        Arrays.sort(str1);
        char[] str2 = t.toCharArray();
        Arrays.sort(str2);
        for(int i=0; i<s.length(); i++) {
            if(str1[i] != str2[i]) {
                return false;
            }
        }
        return true;
    }
}

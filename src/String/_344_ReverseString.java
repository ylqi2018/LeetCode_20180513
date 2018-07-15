package String;

public class _344_ReverseString {
	/*
	 * Method 1.
	 */
	public String reverseString(String s) {
        char[] sChar = s.toCharArray();
        int len = s.length();
        for(int i=0; i<len/2; i++) {
            exchange(sChar, i, len-1-i);
        }
        return new String(sChar);
    }
    
    private void exchange(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
    
    /*
     * Method 2.
     */
    public String reverseString1(String s) {
        char[] sChar = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        
        while(end > start) {
            char temp = sChar[end];
            sChar[end] = sChar[start];
            sChar[start] = temp;
            
            start++;
            end--;
        }
        
        return new String(sChar);
    }
}

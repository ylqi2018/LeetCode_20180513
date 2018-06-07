package Stack;

public class _394_DecodeString {

	/*
	 * Method 1
	 */
    private int pos = 0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        String num = "";
        for (int i = pos; i < s.length(); i++) {
            if (s.charAt(i) != '[' && s.charAt(i) != ']' && !Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else if (Character.isDigit(s.charAt(i))) {
                num += s.charAt(i);
            } else if (s.charAt(i) == '[') {
                pos = i + 1;
                String next = decodeString(s);
                for (int n = Integer.valueOf(num); n > 0; n--) sb.append(next);
                num = "";
                i = pos;
            } else if (s.charAt(i) == ']') {
                pos = i;
                return sb.toString();
            }
        }
        return sb.toString();
    }
    
    /*
     * Method 2
     */
    public String decodeString1(String s) {
        if(s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                int digit_begin = i;
                while(s.charAt(i) != '[') {
                    i++;        // to find the index of the first '['
                }
                int num = Integer.valueOf(s.substring(digit_begin, i)); // s(digit_begin)-s(i-1)
                int count = 1;  // one '[' now, count the number of '[' and ']'
                int str_begin = i + 1;  // the begin index of str
                i++;        // because the '[' at index i has already be counted
                while(count != 0) {
                    if(s.charAt(i) == '[') {
                        count++;
                    } else if(s.charAt(i) == ']') {
                        count--;
                    }
                    i++;
                }
                i--;    // i is added 1 additional 1 time, it will out of the length of string s
                String str = decodeString(s.substring(str_begin, i));    // the substring int the first pair []
                for(int j=0; j<num; j++) {
                    sb.append(str);
                }                
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

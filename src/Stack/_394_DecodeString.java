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
}

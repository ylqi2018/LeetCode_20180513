package String;

public class _28_ImplementstrStr {

	/*
	 * Method 1.
	 */
	public int strStr(String haystack, String needle) {
		for(int i=0; ; i++) {
			for(int j=0; ; j++) {
				if(j == needle.length()) {
					return i;
				}
				if(i + j == haystack.length()) {
					return -1;
				}
				if(needle.charAt(j) != haystack.charAt(i+j)) {
					break;
				}
			}
		}
	}
	
	/*
	 * Method 2.
	 */
	public int strStr1(String haystack, String needle) {
		if(needle.length() == 0) {
			return 0;
		}
		if(haystack.length() < needle.length()) {
			return -1;
		}
		if(haystack.length() == needle.length()) {
			return haystack.equals(needle) ? 0 : -1;
		}
		for(int i=0; i<haystack.length(); i++) {
			int hIndex = i;
			int nIndex = 0;
			while(hIndex < haystack.length() && nIndex < needle.length() 
					&& haystack.charAt(hIndex) == needle.charAt(nIndex)) {
				hIndex++;
				nIndex++;
			}
			if(nIndex == needle.length()) {
				return i;
			}
		}
		return -1;
	}
	
	/*
	 * Method 2.1
	 */
	public int strStr2(String haystack, String needle) {
        if(needle.length() == 0) {
            return 0;
        }
        if(haystack.length() < needle.length()) {
            return -1;
        }
        if(haystack.length() == needle.length()) {
            return haystack.equals(needle) ? 0 : -1;
        }
        for(int i=0; i<=haystack.length()-needle.length(); i++) {
            int hIndex = i;
            int nIndex = 0;
            while(nIndex < needle.length() && haystack.charAt(hIndex) == needle.charAt(nIndex)) {
                hIndex++;
                nIndex++;
            }
            if(nIndex == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}

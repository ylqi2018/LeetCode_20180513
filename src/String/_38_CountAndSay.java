package String;

public class _38_CountAndSay {

	/*
	 * Method 1. Recursion
	 */
	public String countAndSay(int n) {
		String ans = "1";
		if(n == 1) {
			return ans;
		}
		String pre = countAndSay(n - 1);
		StringBuilder tmp = new StringBuilder();
		int j = 0;
		while(j < pre.length()) {
			int count = 1;
			while(j+count < pre.length() && pre.charAt(j)==pre.charAt(j+count)) {
				count++;
			}
			tmp.append(count);
			tmp.append(pre.charAt(j));
			j+=count;
		}
		return tmp.toString();
	}
}

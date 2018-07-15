package String;

public class _125_ValidPalindrome {

	/*
	 * Metho 1.
	 */
	public boolean isPalindrome(String s) {
		s = s.toUpperCase();
		for(int i=0, j=s.length()-1; i<j; i++, j--) {
			char start = s.charAt(i);
			char end = s.charAt(j);
			while(!((start>='A' && start<='Z') || (start>='a' && start<='z')) && (i<j)) {
				i++;
				start = s.charAt(i);
			}
			while(!((end>='A' && end<='Z') || (end>='a' && end<='z')) && (i<j)) {
				j--;
				end = s.charAt(j);
			}
			if(start != end) {
				return false;
			}
		}
		return true;
	}
}

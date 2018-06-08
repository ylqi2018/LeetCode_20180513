package Array;

public class _66_PlusOne {
	
	/*
	 * Method 1
	 */
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }
        
        int[] newNumber = new int[n+1];
        newNumber[0] = 1;
        
        return newNumber;
    }
	
	/*
	 * Method 2
	 */
	public int[] plusOne1(int[] digits) {
        int l = digits.length - 1;
        if(digits[l] < 9) {
            digits[l]++;
            return digits;
        }
        
        while(l >= 0 && digits[l] == 9) {
            digits[l] = 0;
            l--;
        }
        if(l < 0) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                res[i + 1] = digits[i];
            }
            digits = res;
        } else {
            digits[l]++;
        }
        return digits;
    }
}

package BinarySearch;

public class _50_Pow {
	/*
	 * Method 1
	 */
    public double myPow(double x, int n) {
        double temp = x;
        
        if(n == 0) {
            return 1;
        }
        
        temp = myPow(x, n/2);
        
        if(n % 2 == 0) {
            return temp * temp;
        } else {
            if(n > 0) {
                return x * temp * temp;
            } else {
                return temp * temp / x;
            }
        }
    }
	
	/*
	 * Method 2
	 */
    public double myPow1(double x, int n) {
        long m = n > 0 ? n : -(long)n;
        double ans = 1.0;
        while(m != 0) {
            if((m & 1) == 1) {
                ans *= x;
            }
            x *= x;
            m >>= 1;
        }
        return n >= 0 ? ans : 1/ans;
    }
}

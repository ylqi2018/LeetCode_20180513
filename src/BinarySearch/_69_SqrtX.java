package BinarySearch;

public class _69_SqrtX {

	/*
	 * Method 1
	 */
    public int mySqrt(int x) {
        if(x < 4) {
            return (x == 0 ? 0 : 1);
        }
        int res = 2 * mySqrt(x / 4);
        if(((res + 1) * (res + 1) <= x) && ((res + 1) * (res + 1) >= 0)) {
            return res + 1;
        }
        return res;
    }
    
    /*
     * Method 2
     */
    public int mySqrt1(int x) {
    	int start = 1;
    	int end = x;
    	int res = 0;
    	
    	if(x < 4) {
    		return x == 0 ? 0 : 1;
    	}
    	
    	while(start + 1 < end) {
    		int mid = start + (end - start) / 2;
    		if(mid > x / mid) {
    			end = mid;
    		} else if(mid < x / mid) {
    			start = mid;
    		} else {
    			return mid;
    		}
    	}
    	res = start;
    	return res;
    }
    
    /*
     * Newton Method.
     */
    public int mySqrt2(int x) {
        if(x == 0) {
            return 0;
        }
        long i = x;
        while(i > x / i) {
            i = (i + x / i) / 2;
        }
        return (int)i;
    }
}

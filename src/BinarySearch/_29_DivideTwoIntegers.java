package BinarySearch;

public class _29_DivideTwoIntegers {

	/*
	 * Method 1
	 */
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if((dividend>0 && divisor<0) || (dividend<0 && divisor>0)) {
            sign = -1;
        }
        
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        
        if(ldivisor == 0) {
            return Integer.MAX_VALUE;
        }
        if(ldividend ==0 || ldividend < ldivisor) {
            return 0;
        }
        
        long lans = ldivide(ldividend, ldivisor);
        int ans;
        if(lans > Integer.MAX_VALUE) {
            ans = (sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE);
        } else {
            ans = (int)(sign * lans);
        }
        return ans;
    }
    
    private long ldivide(long ldividend, long ldivisor) {
        if(ldividend < ldivisor) {
            return 0;
        }
        
        long sum = ldivisor;
        long multiple = 1;
        while(sum + sum < ldividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + ldivide(ldividend - sum, ldivisor);
    }
    
    /*
     * Method 2
     */
    public int divide1(int dividend, int divisor) {
        if(dividend == 0){
            return 0;
        }
        boolean isPositive = (dividend>0)^(divisor>0) ? false : true;
        if(divisor==0 || (dividend==Integer.MIN_VALUE && (divisor==-1 || divisor==1))) {
            return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        long res = 0;
        long dvd = Math.abs((long)dividend);
        long dvr = Math.abs((long)divisor);
        while(dvd >= dvr) {
            long tem = dvr;
            long mul = 1;
            while(dvd >= (tem + tem)) {
                tem = tem << 1;
                mul = mul << 1;
            }
            dvd -= tem;
            res += mul;
        }
        return isPositive ? (int)res : (int)-res;
    }
}

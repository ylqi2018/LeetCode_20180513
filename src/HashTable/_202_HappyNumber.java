package HashTable;

import java.util.HashSet;
import java.util.Set;

public class _202_HappyNumber {

	/*
	 * Method 1
	 */
    public boolean isHappy(int n) {
        Set<Integer> inLoop = new HashSet<>();
        int squareSum;
        int remain;
        while(inLoop.add(n)) {
            squareSum = 0;
            while(n > 0) {
                remain = n % 10;
                squareSum += remain * remain;
                n = n / 10;
            }
            if(squareSum == 1) {
                return true;
            } else {
                n = squareSum;   
            }         
        }
        return false;
    }
    
    /*
     * Method 2
     */
    public boolean isHappy1(int n) {
        while(n != 1 && n != 4) {
            int squareSum = 0;
            int remain = 0;
            while(n > 0) {
                remain = n % 10;
                squareSum += remain * remain;
                n /= 10;
            }
            n = squareSum;
        }
        return n == 1;
    }
    
    /*
     * Method 3
     */
    public boolean isHappy2(int n) {
        while(n != 1 && n != 4) {
            int cur = n;
            n = 0;
            while(cur > 0) {
                int remain = cur % 10;
                n += remain * remain;
                cur /= 10;
            }
        }
        return n == 1;
    }
}

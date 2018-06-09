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
}

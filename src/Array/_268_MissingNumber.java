package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _268_MissingNumber {

	/*
	 * Method 1
	 */
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        if(nums[nums.length-1] != nums.length) {    // Ensure that n is at the last index
            return nums.length;
        } else if(nums[0] != 0) {   // Ensure that 0 is at the first index
            return 0;
        }
        
        // If we get here, then the missing number is on the range(0, n)
        for(int i=1; i<nums.length; i++) {
            int expectedNum = nums[i-1] + 1;
            if(nums[i] != expectedNum) {
                return expectedNum;
            }
        }
        
        return -1;
    }
    
    /*
     * Method 2
     */
    public int missingNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        
        for(int i=0; i<=nums.length; i++) {
            if(!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }
    
    /*
     * Method 3. Bit manipulation
     * This method harness the fact that XOR is its own inverse to find
     * the missing element in linear time.
     */
    public int missingNumber2(int[] nums) {
        int missing = nums.length;
        for(int i=0; i<nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}

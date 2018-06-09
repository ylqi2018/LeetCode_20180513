package HashTable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _217_ContainsDuplicate {

	/*
	 * Method 1. Sorting
	 */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }
    
    /*
     * Method 2. Set
     */
    public boolean containsDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            if(set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}

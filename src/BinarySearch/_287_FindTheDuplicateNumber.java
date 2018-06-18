package BinarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _287_FindTheDuplicateNumber {

	/*
	 * Method 1.
	 */
    public int findDuplicate(int[] nums) {
        boolean[] res = new boolean[nums.length+1];
        for(int i=0; i<nums.length; i++) {
            if(res[nums[i]] == true) {
                return nums[i];
            } else {
                res[nums[i]] = true;
            }
        }
        return -1;
    }
    
    /*
     * Method 2
     */
    public int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                return nums[i];
            }
        }
        return -1;
    }
    
    /*
     * Method 3
     */
    public int findDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            if(set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }
}

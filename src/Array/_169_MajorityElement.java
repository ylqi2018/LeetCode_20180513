package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _169_MajorityElement {
	
	/*
	 * Array's sorting
	 */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
	
	/*
	 * Brute Force
	 */
	public int majorityElement1(int[] nums) {
        int majorityCount = nums.length/2;

        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count += 1;
                }
            }

            if (count > majorityCount) {
                return num;
            }

        }

        return -1;    
    }
	
	/*
	 * HashMap
	 */
	public int majorityElement2(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);
        
        Map.Entry<Integer, Integer> majorityEntry = null;
        for(Map.Entry<Integer, Integer> entry: counts.entrySet()) {
            if(majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }
    
    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for(int num: nums) {
            if(!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num)+1);
            }
        }
        return counts;
    }
    
    /*
     * Iteration
     */
    public int majorityElement3(int[] nums) {
        return major(nums, 0, nums.length - 1);
    }
    
    private int major(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int mid = left + (right - left) / 2;
        int lm = major(nums, left, mid);
        int rm = major(nums, mid + 1, right);
        if (lm == rm) return rm;
        return getCount(nums, left, mid, lm) > getCount(nums, mid + 1, right, rm) ? lm : rm;
    }
    
    private int getCount(int[] nums, int left, int right, int val) {
        int cnt = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == val) cnt++;    
        }    
        return cnt;
    }
}

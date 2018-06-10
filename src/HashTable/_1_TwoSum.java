package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1_TwoSum {

	/*
	 * Method 1. HashMap
	 */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                res[0] = i;
                res[1] = map.get(complement);
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
    
    /*
     * Method 2. Binary Search
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] oldNums = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            oldNums[i] = nums[i];
        }
        int[] answer = new int[2];
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            int currTarget = target - nums[i];
            int index = binarySearch(nums, currTarget, 0, i-1);
            if(index == -1) {
                index = binarySearch(nums, currTarget, i+1, nums.length - 1);
            }
            if(index != -1) {
                int answerIndex = 0;
                for(int j=0; j<nums.length; j++) {
                    if(oldNums[j] == nums[i]) {
                        answer[answerIndex++] = j;
                    } else if(oldNums[j] == currTarget) {
                        answer[answerIndex++] = j;
                    }
                }
                return answer;
            }
        }
        return answer;
    }
    
    private int binarySearch(int[] nums, int target, int lo, int hi) {
        if(lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if(nums[mid] == target) {
            return mid;
        }
        if(target < nums[mid]) {
            return binarySearch(nums, target, lo, mid-1);
        } else {
            return binarySearch(nums, target, mid+1, hi);
        }
    }
}

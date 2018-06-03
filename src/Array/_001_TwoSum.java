package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _001_TwoSum {
	/*
	 * Brute Force
	 */
    public int[] twoSum1(int[] nums, int target) {
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[j] == target - nums[i]) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No solution.");
    }
    
    /*
	 * Two-pass Hash Table
	 */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int i=0; i<nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement) && (map.get(complement)!=i)) {
                return new int[] {i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No solution.");
    }
	
    /*
	 * One-pass Hash Table
	 */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[] {i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution");
    }
    
    
	public int[] twoSum(int[] nums, int target) {
        int[] oldNums = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            oldNums[i] = nums[i];
        }
        int[] answer = new int[2];
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            int currentTarget = target - nums[i];
            int index = binarySearch(nums, currentTarget, 0, i-1);
            if(index == -1) {
                index = binarySearch(nums, currentTarget, i+1, nums.length-1);
            }
            if(index != -1) {
                int answerIndex = 0;
                for(int j=0; j<nums.length; j++) {
                    if(oldNums[j] == nums[i]) {
                        answer[answerIndex++] = j;
                    } else if(oldNums[j] == currentTarget) {
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
        int mid = lo + (hi - lo)/2;
        if(nums[mid] == target) {
            return mid;
        }
        if(nums[mid] < target) {
            return binarySearch(nums, target, mid+1, hi);
        } else {
            return binarySearch(nums, target, lo, mid-1);
        }
    }

}

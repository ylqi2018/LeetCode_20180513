package Array;

import java.util.Arrays;
import java.util.Stack;

public class _581_ShortestUnsortedContinuousSubarray {
	
	/*
	 * Using stack
	 */
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int l = nums.length;
        int r = 0;
        for(int i=0; i<nums.length; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                l = Math.min(l, stack.pop());
            }
            stack.push(i);
        }
        for(int i=nums.length-1; i>=0; i--) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                r = Math.max(r, stack.pop());
            }
            stack.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;
    }
    
    /*
     * Using sorting.
     */
    public int findUnsortedSubarray1(int[] nums) {
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = snums.length, end = 0;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }
    
    /*
     * Without Using Extra Space [Accepted]
     */
    public int findUnsortedSubarray2(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean flag = false;

        for(int i=1; i<nums.length; i++) {
            if(nums[i] < nums[i-1]) {
                flag = true;
            }
            if(flag) {
                min = Math.min(min, nums[i]);
            }
        }
        flag = false;
        for(int i=nums.length-2; i>=0; i--) {
            if(nums[i] > nums[i+1]) {
                flag = true;
            }
            if(flag) {
                max = Math.max(max, nums[i]);
            }
        }
        int l, r;
        for(l=0; l<nums.length; l++) {
            if(min < nums[l]) {
                break;
            }
        }
        for(r=nums.length-1; r>=0; r--) {
            if(max>nums[r]) {
                break;
            }
        }
        return r - l < 0 ? 0: r - l + 1;
    }
    
    /*
     * Method
     */
    public int findUnsortedSubarray3(int[] nums) {
        int len = nums.length;
        
        // Find the start index where unsorting begins
        int start = 0;
        while((start < len-1) && (nums[start] <= nums[start+1])) {
            start++;    // If nums[start] < nums[start+1], the order is right
        }
        if(start == len-1) {
            return 0;   // when start == len-1, this means the nums is sorted.
        }
        
        // Find the end index where unsorting ends
        int end = len - 1;
        while((end > start) && (nums[end] >= nums[end-1])) {
            end--;
        }
        
        // Now find the minValue and maxValue between nums[start] to nums[end]
        int minValue = nums[start];
        int maxValue = nums[end];
        for(int i=start; i<=end; i++) {
            if(nums[i] < minValue) {
                minValue = nums[i];
            }
            if(nums[i] > maxValue) {
                maxValue = nums[i];
            }
        }
        
        while(start>=0 && nums[start]>minValue) {
            start--;
        }
        while(end<len && nums[end]<maxValue) {
            end++;
        }
        return end - start - 1;
    }

    
}

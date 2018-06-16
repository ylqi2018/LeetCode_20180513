package BinarySearch;

public class _34_SearchForARange {
	/*
	 * Method 1. Linear scan
	 */
	public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        
        // Find the index of the leftmost appearance of `target`
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == target) {
                targetRange[0] = i;
                break;
            }
        }
        
        // if the last loop does not find any index, then there is
        // no valid range and return [-1, -1]
        if(targetRange[0] == -1) {
            return targetRange;
        }
        
        // Find the index of the rightmost appearance of `target`
        for(int j=nums.length-1; j>=0; j--) {
            if(nums[j] == target) {
                targetRange[1] = j;
                break;
            }
        }
        return targetRange;
    }
	
	/*
	 * Method 2. binary search
	 */
    public int[] searchRange1(int[] nums, int target) {
        int[] range = {-1, -1};
        
        int left = helper(nums, target, true);
        
        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if(left == nums.length || nums[left] != target) {
            return range;
        }
        
        range[0] = left;
        range[1] = helper(nums, target, false) - 1;
        return range;
    }
    
    // returns leftmost (or rightmost) index at which `target` should be
    // inserted in sorted array `nums` via binary search.
    private int helper(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;
        
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            if(nums[mid] > target || (left && nums[mid] == target)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}

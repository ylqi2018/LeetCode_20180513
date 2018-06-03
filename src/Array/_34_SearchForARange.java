package Array;

public class _34_SearchForARange {
	
	/*
	 * method 1
	 */
    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        
        // find the leftmost appearance
        for(int i=0; i<nums.length; i++) {
            if(target==nums[i]) {
                targetRange[0] = i;
                break;
            }
        }
        
        // if the last loop did not find any index, there is no valid range
        // and return [-1, -1]
        if(targetRange[0] == -1) {
            return targetRange;
        }
        
        // find the rightmost appearance
        for(int j=nums.length-1; j>=0; j--) {
            if(target==nums[j]) {
                targetRange[1] = j;
                break;
            }
        }
        return targetRange;
    }
    
    /*
     * Method 2
     */
    public int[] searchRange1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }

        return new int[]{leftEdge(nums, target), rightEdge(nums, target)};
    }
    private int leftEdge(int[] nums, int target) {
        int left  = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;

            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        } else if (nums[right] == target) {
            return right;
        } else {
            return -1;
        }
    }
    private int rightEdge(int[] nums, int target){
        int left  = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;

            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[right] == target) {
            return right;
        } else if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }
}

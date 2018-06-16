package BinarySearch;

public class _33_SearchInRotatedSortedArray {
	/*
	 * Method 1
	 */
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            // whether the first half is sorted
            if(nums[start] <= nums[mid]) {
                if(target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // whether the second half is sorted
            if(nums[mid] <= nums[end]) {
                if(target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
    
    /*
     * Method 2. Still do not understand.
     */
    public int search1(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid])) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start == end && nums[start] == target ? start : -1;
    }
}

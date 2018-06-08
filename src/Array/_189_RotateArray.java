package Array;

public class _189_RotateArray {

	/*
	 * Method 1. Brute Force
	 */
    public void rotate(int[] nums, int k) {
        int temp = 0;
        int prev = 0;
        for(int i=0; i<k; i++) {
            prev = nums[nums.length - 1];
            for(int j=0; j<nums.length; j++) {
                temp = nums[j];
                nums[j] = prev;
                prev = temp;
            }
        }
    }
    
    /*
     * Method 2
     * The number at index i in the original array is placed at
     * index (i+k) at the new array.
     */
    public void rotate1(int[] nums, int k) {
        int[] newNums = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            newNums[(i+k) % nums.length] = nums[i];
        }
        for(int i=0; i<nums.length; i++) {
            nums[i] = newNums[i];
        }
    }
    
    /*
     * Method 3
     */
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        int[] extra = new int[k];
        for (int i = 0; i < k; i++)
            extra[i] = nums[nums.length-k+i];
        
        for (int i = nums.length - 1; i >= k; i--)
            nums[i] = nums[i-k];
        
        for (int i = 0; i < k; i++)
            nums[i] = extra[i];
    }
    
    /*
     * Method 4, beat 100%
     */
    public void rotate3(int[] nums, int k) {
        k %= nums.length;
        int[] extra = new int[k];
        System.arraycopy(nums, nums.length-k, extra, 0, k);
        System.arraycopy(nums, 0, nums, k, nums.length-k);
        System.arraycopy(extra, 0, nums, 0, k);
    }
    
    /*
     * Method 5, beat 100%, not analyse
     */
    public void rotate4(int[] nums, int k) {
        k %= nums.length;
        int x = nums.length-k;
        reverse(nums, 0, x);
        reverse(nums, x, nums.length);
        reverse(nums, 0, nums.length);
    }
    
    void reverse(int[] nums, int i, int j) {
        j--;
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}

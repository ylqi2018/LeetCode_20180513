package Array;

import java.util.ArrayList;
import java.util.List;

public class _448_FindAllNumbersDisappearedInAnArray {
	
	/*
	 * Method 1
	 * nums[nums[i] - 1] = -nums[nums[i] - 1]
	 */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        
        for(int i=0; i<nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
    
    /*
     * Method 2
     * 
     */
    public List<Integer> findDisappearedNumbers1(int[] nums) 
    {
		List<Integer> ans= new ArrayList<Integer>();
		boolean arr[]=new boolean[nums.length+1];
		for(int i=0;i<nums.length;i++)
		{
			arr[nums[i]]=true;
		}
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]==false)
				ans.add(i);
		}
		return ans;
    }
}

package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _78_Subsets {
	/*
	 * method 1
	 */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
    
    private void backTrack(List<List<Integer>> result, List<Integer> templist, int[] nums, int start) {
        result.add(new ArrayList<>(templist));
        for(int i=start; i<nums.length; i++) {
            templist.add(nums[i]);
            backTrack(result, templist, nums, i+1);
            templist.remove(templist.size()-1);
        }
    }
}

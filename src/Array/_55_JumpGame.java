package Array;

public class _55_JumpGame {

	/*
	 * Method 1
	 */
    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }
    
    private boolean canJumpFromPosition(int position, int[] nums) {
        if(position == nums.length - 1) {
            return true;
        }
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for(int nextPosition=position+1; nextPosition <= furthestJump; nextPosition++) {
            if(canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }
        return false;
    }
    
    /*
     * or
     */
    public boolean canJump1(int[] nums) {
        return canJumpFromPosition1(nums, 0);
    }
    
    private boolean canJumpFromPosition1(int[] nums, int position) {
        if(position == nums.length - 1) {
            return true;
        }
        
        int furthest = Math.min(position + nums[position], nums.length - 1);
        for(int nextPosition=position+1; nextPosition<=furthest; nextPosition++) {
            if(canJumpFromPosition1(nums, nextPosition)) {
                return true;
            }
        }
        return false;
    }
    
    /*
     * Method 3
     */
    public boolean canJump2(int[] nums) {
        return canJumpFromPosition2(nums, 0);
    }
    
    private boolean canJumpFromPosition2(int[] nums, int position) {
        if(position == nums.length - 1) {
            return true;
        }
        
        int furthest = Math.min(position + nums[position], nums.length - 1);
        for(int nextPosition=furthest; nextPosition>position; nextPosition--) {
            if(canJumpFromPosition2(nums, nextPosition)) {
                return true;
            }
        }
        return false;
    }
}

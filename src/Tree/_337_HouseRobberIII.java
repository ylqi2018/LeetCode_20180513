package Tree;

public class _337_HouseRobberIII {

	/*
	 * Method 1. Dynamic programming
	 */
    public int rob(TreeNode root) {
        int[] result = helper(root);
        return Math.max(result[0], result[1]);
    }
    
    private int[] helper(TreeNode root) {
        // [0] is max value if not rob current one
        // [1] is max value if rob current one
        int[] result = new int[2];
        if(root == null) {
            return result;
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;
        return result;
    }
}

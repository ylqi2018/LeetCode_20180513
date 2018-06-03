package Tree;

import java.util.Stack;

public class _538_ConvertBSTToGreaterTree {

	/*
	 * Method 1. Recursion
	 * When root == null, the recursion will backward.
	 */
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
    
    /*
     * Method 2. Iteration
     */
    public TreeNode convertBST1(TreeNode root) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        
        while(!stack.isEmpty() || node != null) {
            while(node != null) {
                stack.add(node);
                node = node.right;
            }
            
            node = stack.pop();
            sum += node.val;
            node.val = sum;
            
            node = node.left;
        }
        return root;
    }
}

package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94_BinaryTreeInorderTraversal {
	/*
	 * Method 1. recursion
	 */
    public List<Integer> inorderTraversal0(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    
    private void helper(TreeNode root, List<Integer> res) {
        if(root != null) {
            if(root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if(root.right != null) {
                helper(root.right, res);
            }
        }
    }
    
    /*
     * Method 2. Iteration using stack
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

	/*
	 * Method 3
	 */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;
        while(curr != null) {
            if(curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                pre = curr.left;
                while(pre.right != null) {
                    pre = pre.right;
                }
                pre.right = curr;       // put curr after the rightmost node
                TreeNode temp = curr;   // Srote the curr node
                curr = curr.left;
                temp.left = null;
            }
        }
        return res;
    }
}

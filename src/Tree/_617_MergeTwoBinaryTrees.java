package Tree;

import java.util.Stack;

public class _617_MergeTwoBinaryTrees {

	/*
	 * Method 1
	 */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null) {
            return t2;
        }
        if(t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
    
    /*
     * Method 2
     */
    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        if(t1 == null) {
            return t2;
        }
        if(t2 == null) {
            return t1;
        }
        Stack<TreeNode[]> stack = new Stack<>();
        stack.add(new TreeNode[] {t1, t2});
        while(!stack.isEmpty()) {
            TreeNode[] t = stack.pop();
            if(t[1] == null) {
                continue;
            }
            t[0].val += t[1].val;
            if(t[0].left == null) {
                t[0].left = t[1].left;
            } else {
                stack.add(new TreeNode[] {t[0].left, t[1].left});
            }
            if(t[0].right == null) {
                t[0].right = t[1].right;
            } else {
                stack.add(new TreeNode[] {t[0].right, t[1].right});
            }
        }
        return t1;
    }
    
    /*
     * Method 3
     */
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if(t1==null && t2==null) {
            return null;
        }
        
        int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        TreeNode newNode = new TreeNode(val);
        
        newNode.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        newNode.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        
        return newNode;
    }
}

package BinarySearch;

import java.util.Stack;

public class _230_KthSmallestElementInABST {

	/*
	 * Method 1. DFS
	 */
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if(k <= count) {
            return kthSmallest(root.left, k);
        } else if(k > count + 1){
            return kthSmallest(root.right, k - 1 - count);
        }
        return root.val;    // k = count + 1
    }
    
    private int countNodes(TreeNode node) {
        if(node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
    
    /*
     * Method 2
     */
    private int count = 0;
    private int number = 0;
    
    public int kthSmallest1(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }
    
    private void helper(TreeNode node) {
        if(node.left != null) {
            helper(node.left);
        }
        count--;
        if(count == 0) {
            number = node.val;
            return;
        }
        if(node.right != null) {
            helper(node.right);
        }
    }
    
    /*
     * Method 3
     */
    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        
        while(root != null) {
            st.push(root);
            root = root.left;
        }
        
        while(k != 0) {
            TreeNode n = st.pop();
            k--;
            if(k == 0) {
                return n.val;
            }
            TreeNode right = n.right;
            while(right != null) {
                st.push(right);
                right = right.left;
            }
        }
        return -1;
    }
}

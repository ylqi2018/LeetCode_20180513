package Tree;

import java.util.Stack;

public class _230_KthSmallestElementInABST {
	/*
	 * Method 1
	 */
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if(k <= count) {
            return kthSmallest(root.left, k);
        } else if(k > count + 1) {
            return kthSmallest(root.right, k-1-count);
        }
        return root.val;
    }
    
    /*
     * Count the number of nodes under this node, including this node
     */
    private int countNodes(TreeNode node) {
        if(node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
    
    /*
     * Method 2. This method should make number and count act as parameters
     */
    private int number = 0;
    private int count = 0;
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
     * Method 3. Using stack
     */
    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        
        while(k != 0) {
            TreeNode node = stack.pop();
            k--;
            if(k == 0) {
                return node.val;
            }
            node = node.right;
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return -1;
    }
}

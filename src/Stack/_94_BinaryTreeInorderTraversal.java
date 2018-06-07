package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94_BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre = null;
        while(curr != null) {
            if(curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                pre = curr.left;
                while(pre.right != null) {
                    pre = pre.right;
                }
                pre.right = curr;
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }
        return res;
    }
    
    /*
     * Method 2. Recursion
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return helper(root, res);
    }
    
    private List<Integer> helper(TreeNode root, List<Integer> res) {
        if(root == null) {
            return res;
        }
        if(root.left != null) {
            helper(root.left, res);
        }
        res.add(root.val);
        if(root.right != null) {
            helper(root.right, res);
        }
        return res;
    }
    
    /*
     * Method 3. Using stack
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
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
}

package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _104_MaximumDepthOfBinaryTree {

	/*
	 * Method 1. recursive
	 */
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
    
    /*
     * Method 2. iterative, DFS (Depth First Search)
     */
    public int maxDepth1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        
        stack.push(root);
        value.push(1);
        int max = 0;
        
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int temp = value.pop();
            max = Math.max(max, temp);
            
            if(node.left != null) {
                stack.push(node.left);
                value.push(temp + 1);
            }
            
            if(node.right != null) {
                stack.push(node.right);
                value.push(temp + 1);
            }
        }
        return max;
    }
    
    /*
     * Method 3. iterative, BFS (Breadth First Search)
     */
    public int maxDepth2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }
        return count;
    }
}

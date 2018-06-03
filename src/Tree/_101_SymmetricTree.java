package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class _101_SymmetricTree {
	
	/*
	 * Method 1: recursive
	 */
	public boolean isSymmetric(TreeNode root) {
		return isMirror(root, root);
	}
	
	private boolean isMirror(TreeNode t1, TreeNode t2) {
		if(t1 == null && t2 == null) {
			return true;
		}
		if(t1 == null || t2 == null) {
			return false;
		}
		
		return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
	}
	
	/*
	 * Method 2: iterative
	 */
    public boolean isSymmetric1(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if(t1 == null && t2 == null) {
                continue;
            }
            if(t1 == null || t2 == null) {
                return false;
            }
            if(t1.val != t2.val) {
                return false;
            }
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
    
    /*
     * Method 3
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        
        return isSymmetric(root.left, root.right);
    }
    
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return (left.val == right.val) && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

}

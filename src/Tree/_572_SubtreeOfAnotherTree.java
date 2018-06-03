package Tree;

public class _572_SubtreeOfAnotherTree {

	/*
	 * Method 1.
	 */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String tree1 = preOrder(s, true);
        String tree2 = preOrder(t, true);
        return tree1.indexOf(tree2) >= 0;
    }
    
    private String preOrder(TreeNode t, boolean left) {
        if(t == null) {
            if(left) {
                return "lnull";
            } else {
                return "rnull";
            }
        }
        return "#" + t.val + preOrder(t.left, true) + preOrder(t.right, false);
    }
    
    /*
     * Method 2.
     */
    public boolean isSubtree1(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }
    
    private boolean traverse(TreeNode s, TreeNode t) {
        return (s != null) && (equals(s, t) || traverse(s.left, t) || traverse(s.right, t));
    }
    
    private boolean equals(TreeNode s, TreeNode t) {
        if(s == null && t == null) {
            return true;
        }
        if(s == null || t == null) {
            return false;
        }
        return (s.val == t.val) && equals(s.left, t.left) && equals(s.right, t.right);
    }
    
    /*
     * Method 3.
     */
    public boolean isSubtree2(TreeNode s, TreeNode t) {
        if(s == null && t == null) {
            return true;
        }
        if(s == null || t == null) {
            return false;
        }
        
        if(s.val == t.val) {
            int s_l = -1;
            int s_r = -1;
            int t_l = -1;
            int t_r = -1;
            if(s.left != null) {
                s_l = s.left.val;
            }
            if(s.right != null) {
                s_r = s.right.val;
            }
            if(t.left != null) {
                t_l = t.left.val;
            }
            if(t.right != null) {
                t_r = t.right.val;
            }
            if((s_l==t_l && s_r==t_r) && (isSubtree(s.left, t.left) && isSubtree(s.right, t.right))) {
                return true;
            }
        }
        return (isSubtree(s.left, t) || isSubtree(s.right, t));
    }
}

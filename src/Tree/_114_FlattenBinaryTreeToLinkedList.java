package Tree;

public class _114_FlattenBinaryTreeToLinkedList {

	/*
	 * Method 1
	 */
    private TreeNode pre = null;
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
    
    /*
     * Method 2
     */
    public void flatten1(TreeNode root) {
        TreeNode prev = null;
        helper(root, prev);
    }
    
    private TreeNode helper(TreeNode root, TreeNode prev) {
        if (root == null) {
            return prev;
        }
        prev = helper(root.right, prev);
        prev = helper(root.left, prev);
        root.right = prev;
        root.left = null;
        prev = root;
        return prev;
    }
}

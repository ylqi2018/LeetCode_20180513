package Tree;

public class _105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

	/*
	 * Method 1, recursion
	 */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(0, 0, inorder.length-1, preorder, inorder);
    }
    
    private TreeNode buildTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        // preorder.length-1 is the index of the last element
        if(preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        // find the index of root in inorder
        int inIndex = 0;
        for(int i=inStart; i<=inEnd; i++) {
            if(inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = buildTree(preStart+1, inStart, inIndex-1, preorder, inorder);
        root.right = buildTree(preStart+inIndex-inStart+1, inIndex+1, inEnd, preorder, inorder);
        return root;
    }
    
    /*
     * Method 2.
     */
    private int inIndex=0, preIndex=0;
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, Integer.MAX_VALUE);
    }
    private TreeNode helper(int[] preorder, int[] inorder, int target) {
        if (inIndex >= inorder.length || inorder[inIndex] == target) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex++;
        root.left = helper(preorder, inorder, root.val);
        inIndex++;
        root.right = helper(preorder, inorder, target);
        return root;
    }
}

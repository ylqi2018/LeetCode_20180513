package Array;

public class _105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

	/*
	 * Method 1
	 */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length-1, preorder, inorder);
    }
    
    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preOrder, int[] inOrder) {
        if(preStart>preOrder.length-1 || inStart>inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preStart]);
        int index = 0;
        for(int i=0; i<inOrder.length; i++) {
            if(inOrder[i]==root.val) {
                index = i;
            }
        }
        root.left = helper(preStart+1, inStart, index-1, preOrder, inOrder);
        root.right = helper(preStart+1+index-inStart, index+1, inEnd, preOrder, inOrder);
        return root;
    }
    
    /*
     * Method 2
     */
    private int inIndex=0, preIndex=0;
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        return helper1(preorder, inorder, Integer.MAX_VALUE);
    }
    private TreeNode helper1(int[] preorder, int[] inorder, int target) {
        if (inIndex >= inorder.length || inorder[inIndex] == target) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex++;
        root.left = helper1(preorder, inorder, root.val);
        inIndex++;
        root.right = helper1(preorder, inorder, target);
        return root;
    }
}

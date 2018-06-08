package Tree;

public class _116_PopulatingNextRightPointersInEachNode {
	
	/*
	 * Method 1
	 */
    public void connect(TreeLinkNode root) {
        TreeLinkNode start = root;
        while(start != null) {
            TreeLinkNode curr = start;
            while(curr != null) {
                if(curr.left != null) {
                    curr.left.next = curr.right;
                }
                if(curr.right != null && curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            start = start.left;
        }
    }
    
    /*
     * Method 2
     */
    public void connect1(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        
        if(root.left != null) {
            root.left.next = root.right;
            if(root.next != null) {
                root.right.next = root.next.left;
            }
        }
        
        
        connect(root.left);
        connect(root.right);
    }
    
    /*
     * Method 3
     */
    public void connect2(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        
        if(root.left != null) {
            root.left.next = root.right;
        }
        
        if(root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }
        
        connect(root.left);
        connect(root.right);
    }
}

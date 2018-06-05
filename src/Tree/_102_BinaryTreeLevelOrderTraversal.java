package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _102_BinaryTreeLevelOrderTraversal {

	/*
	 * Method 1. Iteration using Queue
	 */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<>();
        helper(root, levelList, 0);
        return levelList;
    }
    
    private void helper(TreeNode node, List<List<Integer>> levelList, int level) {
        if (node == null) return;
        if (levelList.size() <= level) {
            levelList.add(new ArrayList<Integer>());
        }
        levelList.get(level).add(node.val);
        helper(node.left, levelList, level+1);
        helper(node.right, levelList, level+1);
    }
    
    /*
     * Method 2. DFS
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, root, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, TreeNode root, int height) {
        if(root == null) {
            return;
        }
        if(height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        helper(res, root.left, height+1);
        helper(res, root.right, height+1);
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindElements {
    TreeNode root;

    public FindElements(TreeNode root) 
    {
        this.root = root;
        root.val = 0;
        helper(root, 0, "root");
    }

    public void helper(TreeNode root, int val, String position) 
    {
        if (root == null) 
        {
            return;
        }
        if (position.equals("left")) 
        {
            root.val = val * 2 + 1;
        }
        if (position.equals("right")) 
        {
            root.val = val * 2 + 2;
        }
        helper(root.left, root.val, "left");
        helper(root.right, root.val, "right");
    }

    private boolean find(TreeNode root, int target) 
    {
        if (root == null) 
        {
            return false;
        }
        if (root.val == target) 
        {
            return true;
        }
        return find(root.left, target) || find(root.right, target);
    }

    public boolean find(int target) 
    {
        return find(root, target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
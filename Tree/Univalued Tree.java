import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) 
        {
            return true;
        }

        int targetVal = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) 
        {
            TreeNode curr = queue.poll();

            //exit if mismatch
            if (curr.val != targetVal) 
            {
                return false;
            }

            if (curr.left != null) 
            {
                queue.add(curr.left);
            }
            if (curr.right != null) 
            {
                queue.add(curr.right);
            }
        }

        return true;
    }
}
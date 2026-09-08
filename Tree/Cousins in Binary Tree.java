//BFS
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) 
        return false;

        Queue<TreeNode> queue = new LinkedList<>(); // create queue
        queue.add(root); // add root as first element in queue

        while (!queue.isEmpty()) 
        {
            int size = queue.size(); //for level
            boolean foundX = false;  //standard value for both
            boolean foundY = false;

            for (int i = 0; i < size; i++) 
            {
                TreeNode curr = queue.poll(); // traverse

                if (curr.val == x) 
                foundX = true;
                if (curr.val == y) 
                foundY = true;

                // (siblings check)
                if (curr.left != null && curr.right != null) 
                {
                    if ((curr.left.val == x && curr.right.val == y) || 
                        (curr.left.val == y && curr.right.val == x)) 
                        {
                        return false;
                    }
                }

                if (curr.left != null)
                 queue.add(curr.left);
                if (curr.right != null) 
                queue.add(curr.right);
            }

            
            if (foundX && foundY) 
            return true;
            
            if (foundX || foundY) 
            return false;
        }

        return false;
    }
}
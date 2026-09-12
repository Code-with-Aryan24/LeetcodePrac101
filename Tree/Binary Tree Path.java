import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) 
        {
            return result;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();

        nodeQueue.add(root);
        pathQueue.add(String.valueOf(root.val));

        while (!nodeQueue.isEmpty()) 
        {
            TreeNode currNode = nodeQueue.poll();
            String currPath = pathQueue.poll();

            // Check if current node is a leaf
            if (currNode.left == null && currNode.right == null) 
            {
                result.add(currPath);
            }

            if (currNode.left != null) 
            {
                nodeQueue.add(currNode.left);
                pathQueue.add(currPath + "->" + currNode.left.val);
            }

            if (currNode.right != null) 
            {
                nodeQueue.add(currNode.right);
                pathQueue.add(currPath + "->" + currNode.right.val);
            }
        }

        return result;
    }
}
import java.util.ArrayList;
import java.util.List;

class Solution {
    private Integer prev = null;
    private int currentCount = 0;
    private int maxCount = 0;
    private List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) 
    {
        TreeNode curr = root;

        while (curr != null) 
        {
            if (curr.left == null) 
            {
                processNode(curr.val);
                curr = curr.right;
            } else 
            {
                //inorder predecessor
                TreeNode pred = curr.left;
                while (pred.right != null && pred.right != curr) 
                {
                    pred = pred.right;
                }

                if (pred.right == null)
                 {
                    // Create thread
                    pred.right = curr;
                    curr = curr.left;
                } else 
                {
                    // Remove thread and visit current node
                    pred.right = null;
                    processNode(curr.val);
                    curr = curr.right;
                }
            }
        }

        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) 
        {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void processNode(int val) 
    {
        if (prev != null && val == prev) 
        {
            currentCount++;
        } else {
            currentCount = 1;
        }

        if (currentCount > maxCount) 
        {
            maxCount = currentCount;
            modes.clear();
            modes.add(val);
        } else if (currentCount == maxCount) 
        {
            modes.add(val);
        }

        prev = val;
    }
}
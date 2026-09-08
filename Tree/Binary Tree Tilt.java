class Solution {
    public int findTilt(TreeNode root) {
        return helper(root)[1];
    }

    private int[] helper(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0}; // {subtreeSum, tiltSum}
        }

        int[] left = helper(node.left);
        int[] right = helper(node.right);

        int currentTilt = Math.abs(left[0] - right[0]);
        int subtreeSum = node.val + left[0] + right[0];
        int totalTilt = currentTilt + left[1] + right[1];

        return new int[]{subtreeSum, totalTilt};
    }
}
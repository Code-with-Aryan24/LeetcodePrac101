/*class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int minDistance = Integer.MAX_VALUE; //assign initially
        
        for (int i = 0; i < nums.length; i++) 
        {
            if (nums[i] == target) 
            {
                minDistance = Math.min(minDistance, Math.abs(i - start));
            }
        }
        
        return minDistance;
    }
}*/

class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        return dfs(nums, target, start, 0);
    }
    
    private int dfs(int[] nums, int target, int start, int d) 
    {
        int n = nums.length;
        if (start + d >= n && start - d < 0) 
        {
            return -1;
        }
        
        if (start + d < n && nums[start+d] == target) 
        {
            return d;
        }
        if (d > 0 && start - d >= 0 && nums[start - d] == target) 
        {
            return d;
        }
        return dfs(nums, target, start, d + 1);
    }
}
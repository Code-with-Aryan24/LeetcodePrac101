class Solution {
    public int maxProduct(int[] nums) {
        
        int globalMax = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];
        
        // Loop rest of array starting from 1
        for (int i = 1; i < nums.length; i++) 
        {
            int num = nums[i];
            
            
            int tempMax = currentMax * num;
            
            
            currentMax = Math.max(num, Math.max(tempMax, currentMin * num));
            currentMin = Math.min(num, Math.min(tempMax, currentMin * num));
            
            
            globalMax = Math.max(globalMax, currentMax);
        }
        
        return globalMax;
    }
}

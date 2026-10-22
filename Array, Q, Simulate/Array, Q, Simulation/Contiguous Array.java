import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int maxLength = 0;
        int rSum = 0;
        
        for (int i = 0; i < nums.length; i++) 
        {
            rSum += (nums[i] == 1) ? 1 : -1;

            if (map.containsKey(rSum)) 
            {
                int length = i - map.get(rSum);
                maxLength = Math.max(maxLength, length);
            } else 
            {
                
                map.put(rSum, i);
            }
        }
        
        return maxLength;
    }
}
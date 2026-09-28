//Bucket Sort Approach

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) 
        {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) 
        {
            buckets[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) 
        {
            int num = entry.getKey();
            int freq = entry.getValue();
            buckets[freq].add(num);
        }

        int[] result = new int[k];
        int index = 0;

        for (int freq = buckets.length - 1; freq >= 1 && index < k; freq--) 
        {
            for (int num : buckets[freq]) 
            {
                result[index++] = num;
                if (index == k) 
                {
                    return result;
                }
            }
        }

        return result;
    }
}
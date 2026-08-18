from typing import List
from collections import Counter

class Solution:
    def largestInteger(self, nums: List[int], k: int) -> int:
        
        count_in_subarrays = Counter()
        n = len(nums)
        
        
        if k > n:
            return -1
        
        
        for i in range(n - k + 1):
            
            
            #set to get unique numbers 
            unique_numbers_in_subarray = set()
            for j in range(i, i + k):
                unique_numbers_in_subarray.add(nums[j])
            
            #Increase the global count for each unique number 
            for num in unique_numbers_in_subarray:
                count_in_subarrays[num] += 1
        
        
        ans = -1  
        
        # Check each number's count
        for num, count in count_in_subarrays.items():
            if count == 1:
                # update if larger than our current number
                if num > ans:
                    ans = num
        
        return ans
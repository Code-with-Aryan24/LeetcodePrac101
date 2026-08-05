from typing import List

class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        neg = []
        pos = []
        
        #Separate negatives and positives
        for num in nums:
            if num < 0:
                neg.append(num)
            else:
                pos.append(num)

        #Handle edge cases if one list is empty
        if len(neg) == 0:
            return [x * x for x in pos]  
            
        if len(pos) == 0:
            res = [x * x for x in neg]
            res.reverse()  
            return res  # Fixed typo here

        #Prepare lists for merging
        neg = [x * x for x in neg][::-1]  # Square them and reverse
        pos = [x * x for x in pos]        # Square them
        n = len(neg)
        m = len(pos)
        
        #Merge the two sorted lists
        res = []
        i = 0
        j = 0
        
        while i < n and j < m:
            if neg[i] <= pos[j]:
                res.append(neg[i])
                i += 1
            else:
                res.append(pos[j])
                j += 1
                
        # Add any remaining elements 
        while i < n:
            res.append(neg[i])
            i += 1
            
        while j < m:
            res.append(pos[j])
            j += 1
            
        return res                
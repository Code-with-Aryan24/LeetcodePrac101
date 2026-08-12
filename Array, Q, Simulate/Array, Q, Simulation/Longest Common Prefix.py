from typing import List

class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs:
            return ""
            
        # Find the shortest word 
        shortest = min(strs, key=len)
        
        for i, char in enumerate(shortest):
            
            for word in strs:
                if word[i] != char:
                    
                    return shortest[:i]
                    
        
        return shortest
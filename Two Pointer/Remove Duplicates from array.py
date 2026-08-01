class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if not nums:        # edge case for empty array
            return 0
            
        low = 0
        high = 1
        count = 1 #Assuming first element as unique
        while(high < len(nums)):
            if(nums[high] == nums[high-1]):
                high = high + 1
                continue
            else:
                nums[low+1] = nums[high]
                low = low + 1
                high = high + 1
                count = count + 1
                
        return count
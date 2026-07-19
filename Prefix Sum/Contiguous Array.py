class Solution:
    def findMaxLength(self, nums):
        # Dictionary to store first occurrence of each sum
        # Key = prefix sum, Value = first index where this sum appeared
        sum_map = {}
        
        # Initialize: sum 0 at index -1 (before we start)
        sum_map[0] = -1
        
        current_sum = 0
        max_length = 0
        
        for i, num in enumerate(nums):
            # Convert 0 to -1, keep 1 as 1
            if num == 0:
                current_sum += -1
            else:  # num == 1
                current_sum += 1
            
            # If this sum was seen before
            if current_sum in sum_map:
                # Calculate length of subarray
                length = i - sum_map[current_sum]
                max_length = max(max_length, length)
            else:
                # First time seeing this sum - store it
                sum_map[current_sum] = i
        
        return max_length
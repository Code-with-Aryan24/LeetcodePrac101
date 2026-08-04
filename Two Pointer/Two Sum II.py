#given array is sorted, we can use two pointer approach to find the two numbers that add up to the target
class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        left = 0
        right = len(numbers) - 1
        
        while left < right:
            current_sum = numbers[left] + numbers[right]
            
            if current_sum == target:
                return [left + 1, right + 1] 
            elif current_sum < target:
                left += 1  #sum is too big
            else:
                right -= 1 #sum is too small
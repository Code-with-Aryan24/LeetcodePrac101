class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        left, right = 1, num
        
        while left <= right:
            mid = (left + right) // 2
            mid_squared = mid * mid
            
            if mid_squared == num:  #check mid
                return True
            elif mid_squared < num:  #work in left
                left = mid + 1
            else:
                right = mid - 1     #work in right
                
        return False
class Solution:
    def mySqrt(self, x: int) -> int:
       
        if x==1  or x ==2 or x==3:
            return 1

        if x==0:
            return 0    
        
        left, right = 2, x // 2
        ans = 0
        
        while left <= right:
            mid = left + (right - left) // 2
            num = mid * mid
            
            if num == x:
                return mid
            elif num < x:
                ans = mid      
                left = mid + 1  # try a larger value on the right
            else:
                right = mid - 1
                
        return ans
class Solution:
    def maxProduct(self, n: int) -> int:
        max1 = 0  # Largest
        max2 = 0  # Second largest 
        
        # Convert to string 
        for char in str(n):
            digit = int(char)
            
            # If bigger than our largest
            if digit > max1:
                max2 = max1  # The old largest becomes the second largest
                max1 = digit # Update the new largest
            # If bigger than second largest
            elif digit > max2:
                max2 = digit
                
        return max1 * max2
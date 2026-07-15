class Solution:
    def trap(self, height):
        if not height:
            return 0
        
        stack = []
        total_water = 0
        
        for i, current_height in enumerate(height):
            while stack and current_height > height[stack[-1]]:
                bottom = stack.pop()
                if not stack:
                    break
                left = stack[-1]
                width = i - left - 1 #width
                water_height = min(height[left], current_height) - height[bottom]
                total_water += width * water_height
            stack.append(i)
        
        return total_water


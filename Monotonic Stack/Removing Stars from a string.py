class Solution:
    def removeStars(self, s: str) -> str:
        stack = []
        
        for char in s:
            if char == '*':
                stack.pop()  # remove the last character
            else:
                stack.append(char)  
                
        # Join remaining characters into a single string
        return "".join(stack)

        #MONOTONIC STACK
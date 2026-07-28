class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = []
        
        for ast in asteroids:
            # Flag to check if the current asteroid survives
            alive = True
            
            # Collision happens ONLY if current is moving LEFT (<0)
            # AND the top of the stack is moving RIGHT (>0)
            while stack and ast < 0 and stack[-1] > 0:
                if stack[-1] < -ast:        # Top is smaller, top explodes
                    stack.pop()
                    continue                # Keep checking the next top
                elif stack[-1] == -ast:     # Same size, both explode
                    stack.pop()
                    alive = False           # Current also dies
                    break
                else:                       # Top is larger, current explodes
                    alive = False
                    break
                    
            # If the current asteroid didn't collide or survived the collisions
            if alive:
                stack.append(ast)
                
        return stack
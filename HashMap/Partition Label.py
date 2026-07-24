class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        # Step 1: Find the last index of every character in the string
        last_occurrence = {char: i for i, char in enumerate(s)}
        
        result = []
        start = 0
        end = 0
        
        # Step 2: Loop through the string to find our cut points
        for i, char in enumerate(s):
            # Update the end boundary to be the furthest last occurrence 
            # of any character we have seen so far in this current piece.
            end = max(end, last_occurrence[char])
            
            # If our current index reaches the end boundary, we found a partition!
            if i == end:
                length = end - start + 1
                result.append(length)
                
                # Move start to the beginning of the next piece
                start = i + 1
                
        return result
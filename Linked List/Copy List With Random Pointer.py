"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return None
            
        
        old_to_new = {None: None}
        
        
        curr = head
        while curr:
            clone = Node(curr.val)  # Create the clone with the same value
            old_to_new[curr] = clone
            curr = curr.next
            
        
        curr = head
        while curr:
            clone = old_to_new[curr]               # Get the clone we made earlier
            
            
            clone.next = old_to_new[curr.next]     
            clone.random = old_to_new[curr.random] 
            
            curr = curr.next
            
        # Return the head of the cloned list
        return old_to_new[head]
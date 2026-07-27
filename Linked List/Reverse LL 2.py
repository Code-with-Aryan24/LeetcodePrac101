class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        dummy = ListNode(0, head) # Fake node before the head
        prev = dummy
        
        
        for _ in range(left - 1):
            prev = prev.next
            
        
        curr = prev.next
        
        #Pluck and move (right - left) times.
        for _ in range(right - left):
            next_node = curr.next      # The node we are plucking out
            
            
            curr.next = next_node.next 
            
            
            next_node.next = prev.next 
            
            
            prev.next = next_node
            
        # Return the real head
        return dummy.next
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def insertionSortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0)
        curr = head
        
        while curr:
            # Start searching from the beginning of our sorted dummy list
            prev = dummy
            
            # Find the correct spot to insert 'curr'
            # Stop when the next node is bigger than 'curr'
            while prev.next and prev.next.val < curr.val:
                prev = prev.next
                
            # Save the next node we need to process later
            next_node = curr.next
            
            # Insert 'curr' between 'prev' and 'prev.next'
            curr.next = prev.next
            prev.next = curr
            
            # Move to the next node in the original list
            curr = next_node
            
        return dummy.next
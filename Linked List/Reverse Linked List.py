# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prev = None
        curr = head
        
        while curr:
            next_node = curr.next  
            curr.next = prev       
            
            #Move pointers forward
            prev = curr            # prev becomes the current node
            curr = next_node       # curr moves to the saved next node
            
        #prev will be pointing to the new head
        return prev
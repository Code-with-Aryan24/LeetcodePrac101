# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        if not head or not head.next:
            return
            
        #find middle
        slow = head
        fast = head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
        
        second = slow.next
        slow.next = None
        
        #Reverse second half
        prev = None
        curr = second
        while curr:
            next_node = curr.next  
            curr.next = prev       
            prev = curr            
            curr = next_node       
        second = prev              
        
        #Merge 
        first = head
        while second:
            t1 = first.next        # Save first's next
            t2 = second.next       # Save second's next
            
            first.next = second    # Link first -> second
            second.next = t1       # Link second -> first's old next
            
            first = t1             
            second = t2            
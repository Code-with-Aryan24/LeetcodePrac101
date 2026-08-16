class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) 
        {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head.next.next; // Start TWO steps ahead!
        
        while (fast != null && fast.next != null) 
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // slow is strictly before the middle node.
        slow.next = slow.next.next;
        
        return head;
    }
}
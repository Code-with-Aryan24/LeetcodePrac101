/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null)  //edge cases
        {
            return head;
        }
        ListNode odd = head;   //initialize for odd
        ListNode even = head.next;  //for even


        ListNode evenHead = even; //keep head

        while(even!= null && even.next!=null)
        {
            odd.next = odd.next.next;  // point to next odd
            odd = odd.next;

            even.next = even.next.next;  //point to next even
            even = even.next;
        }
        odd.next = evenHead; //attach head

        return head;
    }
}
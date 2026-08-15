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
    public ListNode middleNode(ListNode head) {
        ListNode fastptr = head;
        ListNode slowptr = head;

        while(fastptr!=null && fastptr.next!=null)
        {
            slowptr = slowptr.next; //traverse one ahead
            fastptr = fastptr.next.next;  //traverse 2 ahead
        }
        return slowptr;

    }
}
/*

 Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 */

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;
        while (current != null)
        {

            while (current.next != null &&
                   prev.next.val == current.next.val)
                current = current.next;

            if (prev.next == current)
                prev = prev.next;

            else
                prev.next = current.next;
 
            current = current.next;
        }
        head = dummy.next;
        return head;
    }
}
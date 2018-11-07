/*

 Remove all elements from a linked list of integers that have value val.

 Example:

 Input:  1->2->6->3->4->5->6, val = 6
 Output: 1->2->3->4->5

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
    public ListNode removeElements(ListNode head, int val) {
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode curr = helper;
        while (curr.next != null) {
            if (curr.next.val == val) {
                ListNode next = curr.next;
                curr.next = next.next;
            }else{
                curr = curr.next;
            }
        }
        return helper.next;
    }
}
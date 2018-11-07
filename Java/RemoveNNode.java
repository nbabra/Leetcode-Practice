/*
 
 Given a linked list, remove the n-th node from the end of list and return its head.

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head, temp = new ListNode(0);
        int size = 0;
        
        temp.next = head;
        
        while (curr != null){
            size++;
            curr = curr.next;
        }
        
        size -= n;
        curr = temp;
        
        while (size > 0){
            size--;
            curr = curr.next;
        }
        
        curr.next = curr.next.next;
        
        return temp.next;
        
    }
}
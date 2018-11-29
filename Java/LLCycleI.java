//Given a linked list, determine if it has a cycle in it.

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
         
        if (head == null || head.next == null)
            return false;
        
        ListNode curr = head;
        ListNode runner = head.next;
        
        while (runner != null && runner.next != null) {
            
            if (curr == runner) 
                return true;
            
            curr = curr.next;
            runner = runner.next.next;
            
        }
        
        return false;
        
    }
}
/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.
*/

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
    public ListNode detectCycle(ListNode head) {
        
        ListNode curr = head;
        ListNode runner = head;
        
        while (runner != null && runner.next != null) {
            
            curr = curr.next;
            runner = runner.next.next;
            
            if (curr == runner){
                
                ListNode curr2 = head;
                
                while (curr2 != curr){
                    
                    curr = curr.next;
                    curr2 = curr2.next;
                    
                }
                
                return curr2;
                
            }
        }
        
        return null;
    }
}
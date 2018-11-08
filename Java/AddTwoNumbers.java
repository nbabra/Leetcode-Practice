/*

 You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example:

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.

 */

 /*

 NOTE: Does not work for all cases, for example linked lists with a length (or collective length of the two) bigger than the size of a long.

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String sum1 = "", sum2 = "";
        long result = 0;
        ListNode curr1 = l1, curr2 = l2;
        
        while (curr1 != null) {
            sum1 += Integer.toString(curr1.val);
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            sum2 += Integer.toString(curr2.val);
            curr2 = curr2.next;
        }
        System.out.println("Sum1 :" + sum1 + " Sum2: " + sum2);
        long res1 =  Long.parseLong(sum1);
        long res2 =  Long.parseLong(sum2);
        result = res1 + res2;
        System.out.print("Result: " + result);
        
        ListNode head = new ListNode(0);
        
        ListNode curr3 = head, prev = new ListNode(0);
        int i = 10;
        while (result != 0) {
            if (curr3.next == null) {
                ListNode next = new ListNode(0);
                curr3.next = next;
            }
            
            curr3.val = (int) result % i ;
            result -= curr3.val;
            result /= 10;
            prev = curr3;
            curr3 = curr3.next;    
            
        }
        prev.next = null;
        
        return head;
        
    }
}
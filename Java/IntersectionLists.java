/*
 
 Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists:

 A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
 B:     b1 → b2 → b3
 begin to intersect at node c1.


 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.

 */

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode currA = headA, currB = headB;
        while(currA != null) {
            lenA++;
            currA = currA.next;
        }
        while (currB !=null) {
            lenB++;
            currB = currB.next;
        }
        int difference;
        currA = headA;
        currB = headB;
        
        if (lenA > lenB) {
            difference = lenA - lenB;
            int i =0;
            while (i < difference) {
                currA = currA.next;
                i++;
            }
        }else{
            difference = lenB - lenA;
            int i=0;
            while (i < difference) {
                currB = currB.next;
                i++;
            }
        }
        while (currA !=null && currB != null) {
            if (currA.val == currB.val) {
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }
        return null;
        
        
        
        
        
        
        
    }
}
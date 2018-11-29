/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
*/

class Solution {
    public boolean isPalindrome(String s) {
        
        s = s.replaceAll("[^A-Za-z0-9]", ""); //remove all non-alphanumeric characters
        s = s.toLowerCase(); //change it to all lowercase
        
        int start = 0;
        int end = s.length() - 1;
        
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) //see if the corresponding chars equal each other, and then move inward
                return false;
            start++;
            end--;
        }
        
        return true;
        
    }
}
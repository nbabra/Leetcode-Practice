/*
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
*/

class Solution {
    public String addBinary(String a, String b) {
        
        String res = "";
        
        int sum = 0, i = a.length()-1, j = b.length()-1;
        
        while (i >= 0 || j >=0 || sum == 1) {
            
            if (i >=0) 
                sum += a.charAt(i) - '0';
            else
                sum += 0;
            
            if (j >= 0)
                sum += b.charAt(j) - '0';
            else
                sum += 0;
            
            res = (char)(sum % 2 + '0') + res; //if 3, add one, if 4, add 0, etc. (and add to front of str)
            
            sum /= 2; //carry over
            
            i--;
            j--;
            
        }
        
        return res; 
        
    }
}
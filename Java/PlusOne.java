/*
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
*/

class Solution {
    public int[] plusOne(int[] digits) {
        
        int n = 1;
        
        for (int i=digits.length-1; i>=0; i--) {
            
            int sum = digits[i] + n; //add the carry over to the current digit
            
            if (sum > 9) // if the current digit plus carry is a 2 digit number, it needs to be carried again
                n = 1;
            else
                n = 0;
            
            digits[i] = sum % 10; // storing the 1's place
        }
        
        if (n == 1) {
            
            int[] res = new int[digits.length+1]; //if there is still a carry over, expand array
            
            for (int j=0; j<digits.length; j++){ //copy everything over starting at index 1 on new array
                res[j+1] = digits[j];
            }
            
            res[0] = 1;
            
            return res;
        }
        
        return digits;
        
    }
}
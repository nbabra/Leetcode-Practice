/*
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

 

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"
*/

class Solution {
    public String countAndSay(int n) {
        if (n <= 0)
            return null;
        
        String res = "1";
        int i = 1;
        
        while (i < n) {
            
            StringBuilder sb = new StringBuilder();
            int count = 1;
            
            for (int j=1; j<res.length(); j++) {
                
                if (res.charAt(j) == res.charAt(j-1)) { // If the current and previous term are equal, increment count
                    
                    count++;
                    
                } else { // else add the count and the previous term in that order, then reset count to 1
                    
                    sb.append(count); 
                    sb.append(res.charAt(j-1));
                    
                    count = 1;
                    
                }
                
            }
            
            sb.append(count); //add the last set of terms to the str
            sb.append(res.charAt(res.length()-1));
            
            res = sb.toString(); //add sb to the str
            
            i++; //increment i
        }
        
        return res;
        
    }
}
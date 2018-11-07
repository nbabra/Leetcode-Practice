
/*

 For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

 Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

 I can be placed before V (5) and X (10) to make 4 and 9. 
 X can be placed before L (50) and C (100) to make 40 and 90. 
 C can be placed before D (500) and M (1000) to make 400 and 900.
 Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

 */

class Solution {
    public int val (char c) {
        int value = 0;
        if (c == 'I') {
            return 1;
        }else if (c == 'V') {
            return 5;
        }else if (c == 'X') {
            return 10;
        }else if (c == 'L') {
            return 50;
        }else if (c == 'C') {
            return 100;
        }else if (c == 'D') {
            return 500;
        }else if (c == 'M') {
            return 1000;
        }
        return -1;
    }
    public int romanToInt(String s) {
        int result = 0;
        for (int i=0; i<s.length(); i++) {
            int s1 = val(s.charAt(i));
            if (i+1 < s.length()) {
                int s2 = val(s.charAt(i+1));
                 if (s1>=s2) {
                    result += s1;
                 }else{
                    result += (s2-s1);
                    i++;
                }
            }else{
                result += s1;
                i++;
            }
            
        }
        return result;
    }
    
}
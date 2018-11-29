/*
A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.

For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
Note:

The order of output does not matter.
The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
*/

class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<String>();
        
        for (int i=0; i<12; i++) {
            for (int j=0; j<60; j++) {
                int count = countN(i) + countN(j); //adding up total digits
                if (count == num) {
                    String s = ""; //create new String for each case
                    s += i + ":"; //adding hours
                    
                    if (j<10)
                        s += "0" + j; //i.e. 9 will be 09 for 8:09
                    else
                        s += j;
                    
                    res.add(s);
                    
                }
            }
        }
        
        return res;

    }
    
    public int countN(int n) {

        int res = 0;
        
        while (n > 0) {
            
            if ((n & 1) == 1) //If the current bit equals one, increment res
                res++;
                
            n >>= 1; //bitshift n by one to the right
        }
        
        return res;
        
    }
}
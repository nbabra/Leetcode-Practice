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
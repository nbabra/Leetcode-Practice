public class Solution {
    public String reverseWords(String s) {
        String[] strArr = s.split("\\s+");
        String str = "";
        for (int i = strArr.length-1; i >= 0; i--) {
                        
                str += strArr[i];
                str += " ";
            
        }
        
        return str.trim();
        
    }
}
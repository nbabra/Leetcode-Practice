/*
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        
        Map<Character, Integer> ogMap = new HashMap<Character, Integer>();
        Map<Character, Integer> tMap = new HashMap<Character, Integer>();
        
        if (s.length() != t.length())
            return false;
        
        for (int i=0; i<s.length(); i++) {
            
            if (ogMap.containsKey(s.charAt(i))) {
                
                int incr = ogMap.get(s.charAt(i));
                ogMap.put(s.charAt(i), ++incr);
                
            }else{
                
                ogMap.put(s.charAt(i), 1);
                
            }
            
        }
        
        for (int j=0; j<t.length(); j++) {
            
            if (tMap.containsKey(t.charAt(j))) {
                
                int incr = tMap.get(t.charAt(j));
                tMap.put(t.charAt(j), ++incr);
                
            }else{
                
                tMap.put(t.charAt(j), 1);
                
            }
            
        }
        
        return ogMap.equals(tMap);
        
    }
}
/*
Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.

If there is no answer, return the empty string.
Example 1:

Input: 
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation: 
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
Example 2:

Input: 
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation: 
Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
Note:

All the strings in the input will only contain lowercase letters.
The length of words will be in the range [1, 1000].
The length of words[i] will be in the range [1, 30].
*/

class Solution {
    public String longestWord(String[] words) {
        
        Set<String> set = new HashSet<String>();
        String s = "";
        
        for (int i=0; i<words.length; i++) //Store all words in set
            set.add(words[i]);
        
        for (String w : words){
            
            // If the word length is greater or if its equal, lexographically smaller, continue 
            if (w.length() > s.length() || (w.length() == s.length() && w.compareTo(s) < 0)) {
                
                boolean wordCheck = true;
                
                for (int j=1; j<w.length(); ++j) { // Since substring, start at 1, and increment prior
                    if (!set.contains(w.substring(0,j))) { //If set does not contain substring, do not continue
                        wordCheck = false;
                        break;
                    }
                }
                
                if (wordCheck)
                    s = w;
                
            }
            
        }
        
        return s;
        
    }
}
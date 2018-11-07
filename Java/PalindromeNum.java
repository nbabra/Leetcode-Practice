
/*

 Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

 */

class Solution {
    public boolean isPalindrome(int x) {
        String original = Integer.toString(x);
        String reverse = new StringBuilder(original).reverse().toString();
        if (original.equals(reverse)){
            return true;
        }
        return false;
    }
}
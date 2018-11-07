/*

 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 An input string is valid if:

 Open brackets must be closed by the same type of brackets.
 Open brackets must be closed in the correct order.
 Note that an empty string is also considered valid.

 */

 class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        if (s.isEmpty()) {
            return true;
        }
        for (int i=0; i<s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '{' || curr == '(' || curr == '[') {
                stack.push(curr);
            }
            if (curr == '}' || curr == ')' || curr == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char last = stack.peek();
                if ( (last == '(' && curr == ')') || (last == '{' && curr == '}') || (last == '[' && curr == ']') ) {
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
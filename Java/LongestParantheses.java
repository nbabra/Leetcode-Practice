class Solution {
    public int longestValidParentheses(String s) {
        int result = 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        
        if (s.isEmpty()) 
            return result;
            
        for (int i=0; i<s.length(); i++) {
            
            char curr = s.charAt(i);
            
            if (curr == '(') {
                
                stack.push(i);
                
            }else{
                
                stack.pop();
                
                if(stack.isEmpty()){
                    
                    stack.push(i);
                    
                }else{
                    
                    result = Math.max(result, i - stack.peek() );
                    
                }
            }
        }
        return result;

    }
}

/*

 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 Example:

 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> Returns -3.
 minStack.pop();
 minStack.top();      --> Returns 0.
 minStack.getMin();   --> Returns -2.

*/

 class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> main;
    Stack<Integer> min;
    public MinStack() {
        this.main = new Stack<Integer>();
        this.min = new Stack<Integer>();
    }
    
    public void push(int x) {
        this.main.push(x);
        if (this.min.isEmpty() || x < this.min.peek()) {
            this.min.push(x);
        }else{
            this.min.push(this.min.peek());
        }
    }
    
    public void pop() {
        this.main.pop();
        this.min.pop();
    }
    
    public int top() {
        return this.main.peek();
    }
    
    public int getMin() {
        return this.min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
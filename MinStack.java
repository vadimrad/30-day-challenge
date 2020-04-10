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
    Stack<Integer> main;
    Stack<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        main = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int x) {
        main.push(x);
        if (min.size() == 0) {
            min.push(x);
        } else if (x <= min.peek()) {
            min.push(x);
        }
    }
    
    public void pop() {
        int e = main.pop();
        if (min.peek() == e) {
            min.pop();
        }
    }
    
    public int top() {
        return main.peek();
    }
    
    public int getMin() {
        return min.peek();
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

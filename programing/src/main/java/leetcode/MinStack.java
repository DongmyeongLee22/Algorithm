package leetcode;

import java.util.Stack;

public class MinStack {
    Stack<Value> s;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        s = new Stack<>();
    }

    public void push(int x) {
        Value value;
        if (s.isEmpty()) {
            value = new Value(x, x);
        } else {
            int min = Math.min(x, getMin());
            value = new Value(x, min);
        }
        s.push(value);
    }

    public void pop() {
        s.pop();
    }

    public int top() {
        return s.peek().val;
    }

    public int getMin() {
        return s.peek().min;
    }

    class Value {
        int val;
        int min;

        Value(int val, int min) {
            this.val = val;
            this.min = min;
        }
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


package cracking.StackAndQuere;

class MinStack {

    Stack<Item> stack = new Stack<>();

    void push(int data) {
        int min = Math.min(data, min());
        stack.push(new Item(data, min));
    }

    int pop() {
        return stack.pop().value;
    }

    int min() {
        if (stack.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return stack.peek().min;
    }

    int peek() {
        return stack.peek().value;
    }

    class Item {
        int value;
        int min;

        Item(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }
}

class MinStack2 {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack2() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    void push(int data) {
        if (data <= min()) {
            minStack.push(data);
        }
        stack.push(data);
    }

    int pop() {
        int data = stack.pop();
        if (data == min()) {
            minStack.pop();
        }
        return data;
    }

    int min() {
        if (minStack.isEmpty()) {
            return Integer.MAX_VALUE;
        }

        return minStack.peek();
    }

    int peek() {
        return stack.peek();
    }
}

package com.company.cracking.StackAndQuere;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class SetOfStacks {
    private List<MyStack<Integer>> stacks;
    private int capacity;

    public SetOfStacks(int capacity) {
        stacks = new ArrayList<>();
        this.capacity = capacity;
    }

    public void push(int data) {
        MyStack<Integer> stack = getLastStack();
        if (stack != null && stack.size() < capacity) {
            stack.push(data);
        } else {
            MyStack<Integer> newStack = new MyStack<>(capacity);
            newStack.push(data);
            stacks.add(newStack);
        }
    }

    private MyStack<Integer> getLastStack() {
        return stacks.get(stacks.size() - 1);
    }

    public int pop() {
        MyStack<Integer> stack = getLastStack();
        if (stack == null) {
            throw new EmptyStackException();
        }
        int data = stack.pop();
        if (stack.size() == 0) {
            stacks.remove(stack);
        }
        return data;
    }

    public int popAt(int index) {
        return leftShift(index, true);
    }

    public int leftShift(int index, boolean removeTop) {
        MyStack<Integer> stack = stacks.get(index);
        int removed;
        if (removeTop) {
            removed = stack.pop();
        } else {
            removed = stack.removeBottom();
        }

        if (stack.isEmpty()) {
            stacks.remove(index);
        } else if (stacks.size() > index + 1) {
            int value = leftShift(index + 1, false);
            stack.push(value);
        }
        return removed;
    }
}

class MyStack<T> {
    StackNode bottom, top;
    int size = 0;
    private int capacity;

    public MyStack(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void join(StackNode below, StackNode above) {
        if (below != null) below.above = above;
        if (above != null) above.below = below;
    }

    public boolean push(T data) {
        if (size >= capacity) return false;
        size++;
        StackNode node = new StackNode(data);
        if (size == 1) {
            bottom = node;
        }
        join(node, top);
        top = node;
        return true;
    }

    public T pop() {
        StackNode node = top;
        top = top.below;
        size--;
        return node.data;
    }

    public T removeBottom() {
        StackNode node = bottom;
        bottom = bottom.above;
        if (bottom == null) bottom.below = null;
        size--;
        return node.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    class StackNode {
        T data;
        StackNode below, above;

        public StackNode(T data) {
            this.data = data;
        }
    }

}

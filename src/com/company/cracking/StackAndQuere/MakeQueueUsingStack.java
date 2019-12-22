package com.company.cracking.StackAndQuere;

import java.util.EmptyStackException;
import java.util.Stack;

public class MakeQueueUsingStack<T> {

    private Stack<T> first;
    private Stack<T> last;

    public MakeQueueUsingStack() {
        first = new Stack<>();
        last = new Stack<>();
    }

    void add(T data) {
        first.push(data);
    }

    T remove() {
        shiftStacks();
        return last.pop();
    }

    T peek() {
        shiftStacks();
        return last.peek();
    }

    private void shiftStacks() {
        if (last.isEmpty() && first.isEmpty()) {
            throw new EmptyStackException();
        }
        if (last.isEmpty()) {
            while (!first.isEmpty()) {
                last.push(first.pop());
            }
        }
    }

    int size() {
        return first.size() + last.size();
    }
}

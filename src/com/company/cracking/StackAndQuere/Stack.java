package com.company.cracking.StackAndQuere;

import java.util.EmptyStackException;

public class Stack<T> {

    StackNode top;

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    //peek, push, pop, isEmpty

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T ret = top.data;
        top = top.next;
        return ret;
    }

    public void push(T data) {
        StackNode stackNode = new StackNode(data);
        stackNode.next = top;
        top = stackNode;
    }

    public boolean isEmpty() {
        return top == null;
    }

    class StackNode {
        T data;
        StackNode next;

        public StackNode(T data) {
            this.data = data;
        }
    }
}

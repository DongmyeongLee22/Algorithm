package javainterview.chapter6.TemplateMethod;


import java.util.LinkedList;

public class Stack {

    private LinkedList<Integer> stack;

    public Stack() {
        stack = new LinkedList<>();
    }

    public Stack(LinkedList<Integer> initial){
        this.stack = initial;
    }

    public void push(int value){
        stack.add(0, value);
    }

    public Integer pop(){
        return stack.remove(0);
    }

    public Stack filter(StackPredicate filter){
        LinkedList<Integer> initialState = new LinkedList<>();
        for (Integer integer : stack) {
            if (filter.isValid(integer)){
                initialState.add(integer);
            }
        }

        return new Stack(initialState);
    }
}

interface StackPredicate{
    boolean isValid(int value);
}


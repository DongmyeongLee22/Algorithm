package javainterview.jvm;

import java.util.ArrayList;
import java.util.List;

public class StackEx<E> {

    private final List<E> stackValues;
    private int stackPointer;

    public StackEx() {
        this.stackValues = new ArrayList<>();
        this.stackPointer = 0;
    }

    public void push(E value){
        stackValues.add(stackPointer, value);
        stackPointer++;
    }

    public E pop(){
        stackPointer--;
        return stackValues.get(stackPointer);
    }
}
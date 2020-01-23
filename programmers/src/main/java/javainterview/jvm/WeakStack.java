package javainterview.jvm;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class WeakStack<E> {

    private final List<WeakReference<E>> stackRefer;
    private int stackPointer = 0;


    public WeakStack() {
        this.stackRefer = new ArrayList<>();
    }

    public void push(E value){
        this.stackRefer.add(stackPointer, new WeakReference<>(value));
        this.stackPointer++;
    }

    public E pop(){
        stackPointer--;
        return this.stackRefer.get(stackPointer).get();
    }

    public E peek(){
        return this.stackRefer.get(stackPointer-1).get();
    }


}

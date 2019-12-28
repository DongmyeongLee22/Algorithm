package cracking.StackAndQuere;

import java.util.EmptyStackException;

public class MakeTreeStackOneArray {
    private int stackNum = 3;
    private int stackSize;
    private int[] values;
    private int[] size = new int[stackNum];

    public MakeTreeStackOneArray(int stackSize) {
        this.stackSize = stackSize;
        values = new int[stackSize * stackNum];
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        int index = getIndex(stackNum);
        return values[index];
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        int index = getIndex(stackNum);
        int ret = values[index];
        size[stackNum]--;
        values[index] = 0;
        return ret;
    }

    public void push(int stackNum, int data) {
        if (isFull(stackNum)) {
            throw new StackOverflowError();
        }
        int index = getIndex(stackNum);
        values[index + 1] = data;
        size[stackNum]++;
    }

    public boolean isEmpty(int stackNum) {
        return size[stackNum] == 0;
    }

    public boolean isFull(int stackNum) {
        return size[stackNum] == stackSize;
    }

    public int getIndex(int stackNum) {
        int curSize = size[stackNum];
        int offset = stackNum * stackSize;
        return offset + curSize - 1;
    }


}

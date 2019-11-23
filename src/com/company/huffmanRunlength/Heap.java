package com.company.huffmanRunlength;

import java.util.ArrayList;
import java.util.List;

public class Heap<E extends Comparable<E>> {

    private List<E> heap;

    public Heap() {
        heap = new ArrayList<>();
    }

    public void heapUp(int index) {
        int parent = (index - 1) / 2;

        if (heap.get(index).compareTo(heap.get(parent)) >= 1) {
            swap(index, parent);
            heapUp(parent);
        }
    }

    public void heapDown(int index) {
        int left = (index * 2) + 1;
        int right = (index * 2) + 2;
        int largeIndex = index;

        if (left < heap.size() && heap.get(left).compareTo(heap.get(largeIndex)) >= 1) {
            largeIndex = left;
        }

        if (right < heap.size() && heap.get(right).compareTo(heap.get(largeIndex)) >= 1) {
            largeIndex = right;
        }

        if (largeIndex != index) {
            swap(largeIndex, index);
            heapDown(largeIndex);
        }
    }

    public int size() {
        return heap.size();
    }

    public void insert(E data) {
        heap.add(data);
        heapUp(heap.size() - 1);
    }

    public E delete() {
        if (heap.size() == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        E removeDate = heap.remove(0);

        if (heap.size() != 0) {
            heap.add(0, heap.remove(heap.size() - 1));
        }

        heapDown(0);

        return removeDate;

    }

    public E get(int index){
        return heap.get(index);
    }

    public void swap(int a, int b) {
        E temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }
}

package cracking.StackAndQuere;

import java.util.NoSuchElementException;

public class Queue<T> {
    QueueNode first;
    QueueNode last;

    public T peek() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        return first.data;
    }

    public T remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        T ret = first.data;
        first = first.next;

        if (first == null) {
            last = null;
        }

        return ret;
    }

    public void add(T data) {
        QueueNode queueNode = new QueueNode(data);
        if (last != null) {
            last.next = queueNode;
        }
        last = queueNode;

        if (first == null) {
            first = last;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    class QueueNode {
        T data;
        QueueNode next;

        public QueueNode(T data) {
            this.data = data;
        }
    }
}

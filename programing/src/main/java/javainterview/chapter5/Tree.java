package javainterview.chapter5;

public interface Tree<E extends Comparable> {
    boolean search(E toFind);
}

class Node<E extends Comparable> implements Tree<E>{

    private E value;
    private Tree<E> right;
    private Tree<E> left;

    public Node(E value) {
        this.value = value;
        right = new Leaf<>();
        left = new Leaf<>();
    }

    @Override
    public boolean search(E toFind) {
        if (toFind.equals(value)){
            return true;
        }

        if (toFind.compareTo(value) > 0){
            return right.search(toFind);
        }

        return left.search(toFind);
    }

}

class Leaf<E extends Comparable> implements Tree<E>{

    @Override
    public boolean search(E toFind) {
        return false;
    }

}

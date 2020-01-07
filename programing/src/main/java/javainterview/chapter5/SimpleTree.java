package javainterview.chapter5;

// 이진 검색 트리 구현
public class SimpleTree<E extends Comparable> {
    private E value;
    private SimpleTree<E> left;
    private SimpleTree<E> right;

    public SimpleTree(E value) {
        this.value = value;
        left = null;
        right = null;

    }

    // 값 찾기
    public boolean search(final E toFind) {
        if (toFind.equals(value)) {
            return true;
        }

        if (toFind.compareTo(value) > 0 && right != null) {
            return right.search(toFind);
        }

        return left != null && left.search(toFind);
    }

    // 이진트리 값 삽입
    public void insert(final E toInsert) {
        if (toInsert.compareTo(value) < 0) {
            if (left == null) {
                left = new SimpleTree<>(toInsert);
            } else {
                left.insert(toInsert);
            }
        } else {
            if (right == null) {
                right = new SimpleTree<>(toInsert);
            } else {
                right.insert(toInsert);
            }
        }
    }

    public E getValue() {
        return value;
    }

    public SimpleTree<E> getLeft() {
        return left;
    }

    public SimpleTree<E> getRight() {
        return right;
    }
}
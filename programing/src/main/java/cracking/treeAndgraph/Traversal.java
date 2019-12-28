package cracking.treeAndgraph;

public class Traversal {

    public static void main(String[] args) {
        Traversal traversal = new Traversal();
        Node<Integer> node = new Node<>(1);

        traversal.preOrderTraversal(node);
        traversal.inOrderTraversal(node);
        traversal.postOrderTraversal(node);

    }

    void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.value);
            inOrderTraversal(node.right);
        }
    }

    void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.println(node.value);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.println(node.value);
        }
    }

}

class Node<T> {
    T value;
    Node left, right;

    public Node(T value) {
        this.value = value;
    }
}
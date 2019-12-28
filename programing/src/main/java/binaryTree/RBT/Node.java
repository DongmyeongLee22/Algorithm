package binaryTree.RBT;

public class Node {
    private int data;
    private Node parentNode;
    private Node rightNode;
    private Node leftNode;
    private boolean color;

    public boolean getColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node(int data) {
        this.data = data;
        parentNode = null;
        rightNode = null;
        leftNode = null;
        color = true;

    }

    public Node(Node nil, int data){
        this.data = data;
        parentNode = nil;
        rightNode = nil;
        leftNode = nil;
        color = false;

    }
}

package com.company.binaryTree.BST;

public class Node {

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    private Integer data;
    private Node parentNode;
    private Node leftNode;
    private Node rightNode;

    public Node(Integer data) {
        this.data = data;
        parentNode = null;
        rightNode = null;
        leftNode = null;
    }

}

package com.company.binaryTree;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BinaryTree<E> {

    private Node<E> root;

    public Node<E> makeNode(E data, Node<E> leftTree, Node<E> rightTree) {
        root = new Node<E>(data);

        if (leftTree != null)
            root.setLeftNode(leftTree);

        if (rightTree != null)
            root.setRightNode(rightTree);

        return root;
    }

    public void inorder_Traversal(Node<E> node) {
        if(node != null) {
            inorder_Traversal(node.getLeftNode());
            System.out.println(node.toString());
            inorder_Traversal(node.getRightNode());
        }
    }

    public void preorder_Traversal(Node<E> node) {
        if(node != null) {
            System.out.println(node.toString());
            preorder_Traversal(node.getLeftNode());
            preorder_Traversal(node.getRightNode());
        }
    }

    public void postorder_Traversal(Node<E> node) {
        if(node != null) {
            postorder_Traversal(node.getLeftNode());
            postorder_Traversal(node.getRightNode());
            System.out.println(node.toString());
        }
    }

    public void levelorder_Traversal(Node<E> node){

        ArrayList<Node<E>> queue = new ArrayList<>();

        queue.add(node);


        while(queue.size() > 0 ) {

            Node<E> temp = queue.get(0);

            System.out.println(temp.toString());

            if (temp.getLeftNode() != null)
                queue.add(temp.getLeftNode());

            if (temp.getRightNode() != null)
                queue.add(temp.getRightNode());

            queue.remove(0);

        }
    }

}

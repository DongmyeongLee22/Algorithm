package com.company.binaryTree.RBT;

public class Main {

    public static void main(String[] args) {
        RedBlackTree redBlackTree = new RedBlackTree();

        Node NIL = new Node(-1);
        Node root = new Node(NIL,8);
        redBlackTree.insert_Node(root);
        redBlackTree.insert_Node(new Node(NIL,6));
        redBlackTree.insert_Node(new Node(NIL,1));
        redBlackTree.insert_Node(new Node(NIL,5));
        redBlackTree.insert_Node(new Node(NIL,2));
        redBlackTree.insert_Node(new Node(NIL,4));
        redBlackTree.insert_Node(new Node(NIL,3));
        redBlackTree.insert_Node(new Node(NIL,10));
        redBlackTree.insert_Node(new Node(NIL,9));
        redBlackTree.insert_Node(new Node(NIL,7));

        redBlackTree.inorder_Traversal(root);
    }
}

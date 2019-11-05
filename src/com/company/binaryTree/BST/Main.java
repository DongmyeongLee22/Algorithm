package com.company.binaryTree.BST;

public class Main {

    public static void main(String[] args) {

        BinaryST bst = new BinaryST(5);

        bst.insert_Node(new Node(1));
        bst.insert_Node(new Node(3));
        bst.insert_Node(new Node(7));
        bst.insert_Node(new Node(2));
        bst.insert_Node(new Node(11));
        Node test = new Node(4);
        bst.insert_Node(test);
        bst.insert_Node(new Node(8));

        bst.printTree(bst.root);
        bst.searchNode(bst.root,4);
        System.out.println(bst.find_Successor(test).getData());
        bst.delete_Tree(bst,test);
        bst.printTree(bst.root);
    }

}

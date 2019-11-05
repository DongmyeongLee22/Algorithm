package com.company.binaryTree.BST;

public class BinaryST {

    Node root;

    public BinaryST(Integer data) {
        root = new Node(data);
    }

    public void insert_Node(Node newNode) {
        Node runnerNode = null;
        Node baseNode = root;

        while (baseNode != null) {

            runnerNode = baseNode;
            if (newNode.getData() > baseNode.getData())
                baseNode = baseNode.getRightNode();
            else
                baseNode = baseNode.getLeftNode();

        }
        newNode.setParentNode(runnerNode);

        if (runnerNode == null)
            root = newNode;
        else {
            if (runnerNode.getData() > newNode.getData())
                runnerNode.setLeftNode(newNode);
            else
                runnerNode.setRightNode(newNode);

        }

    }

    public void printTree(Node node) {

        if (node != null) {
            System.out.println(node.getData());
            printTree(node.getLeftNode());
            printTree(node.getRightNode());
        }
    }

    public void searchNode(Node node, Integer value){

        if(node==null){
            System.out.println("트리가 존재 하지 않습니다.");
        }else if(node.getData().equals(value))
            System.out.println("노드를 찾았습니다. 부모 노드의 데이터는 " + node.getParentNode().getData() + " 입니다.");
        else{
            if(node.getData() < value)
                searchNode(node.getRightNode(), value);
            else
                searchNode(node.getLeftNode(), value);
        }
    }

    public Node find_Min(Node node){
        while(node.getLeftNode() != null)
            node = node.getLeftNode();

        return node;
    }

    public Node find_Successor(Node node){
        if(node.getRightNode() != null)
            return find_Min(node);

        Node temp = node.getParentNode();

        while(temp!= null && temp.getRightNode() == node){
            node = temp;
            temp = temp.getParentNode();
        }

        return temp;

    }

    public Node delete_Tree(BinaryST tree, Node node){
        Node deleteNode, temp;
        if(node.getRightNode() == null || node.getLeftNode() == null)
            deleteNode = node;
        else
            deleteNode = find_Successor(node);

        if(deleteNode.getLeftNode() ==null)
            temp = deleteNode.getRightNode();
        else
            temp = deleteNode.getLeftNode();

        if(temp != null)
            temp.setParentNode(deleteNode.getParentNode());

        if(deleteNode.getParentNode() == null)
            root = temp;
        else if( deleteNode == deleteNode.getParentNode().getLeftNode())
            deleteNode.getParentNode().setLeftNode(temp);
        else
            deleteNode.getParentNode().setRightNode(temp);

        if(deleteNode != node){
            node.setData(deleteNode.getData());
        }

        return deleteNode;


    }



}

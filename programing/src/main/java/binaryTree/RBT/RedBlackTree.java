package binaryTree.RBT;

public class RedBlackTree {

    private static Node NIL = new Node(-1);
    private static Node root =NIL;

    private void left_Rotation(Node xNode) {
        Node yNode = xNode.getRightNode();
        xNode.setRightNode(yNode.getLeftNode());
        yNode.getLeftNode().setParentNode(xNode);
        yNode.setParentNode(xNode.getParentNode());

        if (xNode.getParentNode() == NIL)
            root = yNode;
        else if (xNode.getParentNode().getLeftNode() == xNode)
            xNode.getParentNode().setLeftNode(yNode);
        else
            xNode.getParentNode().setRightNode(yNode);

        yNode.setLeftNode(xNode);
        xNode.setParentNode(yNode);
    }

    private void right_Rotation(Node xNode) {
        Node yNode = xNode.getLeftNode();
        xNode.setLeftNode(yNode.getRightNode());
        yNode.getRightNode().setParentNode(xNode);
        yNode.setParentNode(xNode.getParentNode());

        if (xNode.getParentNode() == NIL)
            root = yNode;
        else if (xNode.getParentNode().getLeftNode() == xNode)
            xNode.getParentNode().setLeftNode(yNode);
        else
            xNode.getParentNode().setRightNode(yNode);

        yNode.setRightNode(xNode);
        xNode.setParentNode(yNode);
    }

    public void insert_Node(Node node) {
        Node runnerNode = root;
        Node baseNode = NIL;

        while (runnerNode != NIL) {
            baseNode = runnerNode;

            if (node.getData() > runnerNode.getData())
                runnerNode = runnerNode.getRightNode();
            else
                runnerNode = runnerNode.getLeftNode();

        }

        node.setParentNode(baseNode);

        if (baseNode == NIL)
            root = node;
        else if (node.getData() > baseNode.getData())
            baseNode.setRightNode(node);
        else
            baseNode.setLeftNode(node);

        node.setLeftNode(NIL);
        node.setRightNode(NIL);
        node.setColor(false);
        RB_Insert_Fix(node);
    }

    private void RB_Insert_Fix(Node node) {

        while (node.getParentNode() != NIL && !node.getParentNode().getColor()) {
            // CASE 1 2 3
            if (node.getParentNode().getParentNode().getLeftNode() == node.getParentNode()) {
                Node y = node.getParentNode().getParentNode().getRightNode();
                // CASE 1
                if (y != NIL && !y.getColor()) {
                    node.getParentNode().getParentNode().setColor(false);
                    node.getParentNode().setColor(true);
                    y.setColor(true);
                    node = node.getParentNode().getParentNode();
                }
                // CASE 2, 3
                else {
                    if (node.getParentNode().getRightNode() == node) {
                        node = node.getParentNode();
                        left_Rotation(node);
                    }
                    if (node.getParentNode().getParentNode() != NIL) {
                        node.getParentNode().setColor(true);
                        node.getParentNode().getParentNode().setColor(false);
                        right_Rotation(node.getParentNode().getParentNode());
                    }
                }
            }
            // CASE 4 5 6
            else {
                Node y = node.getParentNode().getParentNode().getLeftNode();
                // CASE 4
                if (y != NIL && !y.getColor()) {
                    node.getParentNode().getParentNode().setColor(false);
                    node.getParentNode().setColor(true);
                    y.setColor(true);
                    node = node.getParentNode().getParentNode();
                }
                // CASE 5, 6
                else {
                    if (node.getParentNode().getLeftNode() == node) {
                        node = node.getParentNode();
                        right_Rotation(node);
                    }
                    node.getParentNode().setColor(true);
                    node.getParentNode().getParentNode().setColor(false);
                    left_Rotation(node.getParentNode().getParentNode());
                }
            }
        }
        root.setColor(true);
    }

    public Node find_Min(Node node) {
        while (node.getLeftNode() != NIL)
            node = node.getLeftNode();

        return node;
    }

    public Node find_Successor(Node node) {
        if (node.getRightNode() != NIL)
            return find_Min(node.getRightNode());

        Node temp = node.getParentNode();

        while (temp != NIL && temp.getRightNode() == node) {
            node = temp;
            temp = temp.getParentNode();
        }

        return temp;

    }

    public Node delete_Node(Node node) {
        Node deleteNode, temp;

        int value = node.getData();
        System.out.println("parent node data is " + node.getParentNode().getData()+ " node data is " + node.getData() + " " + node.getLeftNode().getData() + " " + node.getRightNode().getData());

        if (node.getRightNode() == NIL || node.getLeftNode() == NIL)
            deleteNode = node;
        else
            deleteNode = find_Successor(node);

        System.out.println("deleteNode data is " + deleteNode.getData() + " " + deleteNode.getLeftNode().getData() + " " + deleteNode.getRightNode().getData());

        if (deleteNode.getLeftNode() == NIL)
            temp = deleteNode.getRightNode();
        else
            temp = deleteNode.getLeftNode();

        System.out.println("temp data is " + temp.getData());


        if (temp != NIL)
            temp.setParentNode(deleteNode.getParentNode());

        if (deleteNode.getParentNode() == NIL)
            root = temp;
        else if (deleteNode == deleteNode.getParentNode().getLeftNode())
            deleteNode.getParentNode().setLeftNode(temp);
        else
            deleteNode.getParentNode().setRightNode(temp);

        if (deleteNode != node) {
            node.setData(deleteNode.getData());
        }

        if (deleteNode.getColor())
            RB_Delete_Fix(temp);

        System.out.println("삭제된 노드의 값은 : " + value + "\n");
        return deleteNode;
    }

    private void RB_Delete_Fix(Node node) {

        while (node != root && node.getColor()) {
            // CASE 1 2 3 4
            if (node.getParentNode().getLeftNode() == node) {
                Node brother = node.getParentNode().getRightNode();

                // CASE 1
                if (!brother.getColor()) {
                    brother.setColor(true);
                    brother.getParentNode().setColor(false);
                    left_Rotation(node.getParentNode());
                    brother = node.getParentNode().getRightNode();
                }
                // CASE 2, 3, 4
                else {

                    // CASE 2
                    if (brother.getLeftNode().getColor() && brother.getRightNode().getColor()) {
                        brother.setColor(false);
                        node = node.getParentNode();
                    }

                    // CASE 3, 4
                    else {
                        if (!brother.getLeftNode().getColor()) {
                            brother.getLeftNode().setColor(true);
                            brother.setColor(false);
                            right_Rotation(brother);
                            brother = node.getParentNode().getRightNode();
                        }
                    }
                    brother.setColor(brother.getParentNode().getColor());
                    brother.getParentNode().setColor(true);
                    brother.getRightNode().setColor(true);
                    left_Rotation(brother);
                    node = root;
                }
            }
            // CASE 5 6 7 8
            else {

                Node brother = node.getParentNode().getLeftNode();

                // CASE 5
                if (!brother.getColor()) {
                    brother.setColor(true);
                    brother.getParentNode().setColor(false);
                    right_Rotation(node.getParentNode());
                    brother = node.getParentNode().getLeftNode();
                }
                // CASE 6, 7, 8
                else {

                    // CASE 6
                    if (brother.getRightNode().getColor() && brother.getLeftNode().getColor()) {
                        brother.setColor(false);
                        node = node.getParentNode();
                    }

                    // CASE 7, 8
                    else {
                        if (!brother.getRightNode().getColor()) {
                            brother.getRightNode().setColor(true);
                            brother.setColor(false);
                            left_Rotation(brother);
                            brother = node.getParentNode().getLeftNode();
                        }
                    }
                    brother.setColor(brother.getParentNode().getColor());
                    brother.getParentNode().setColor(true);
                    brother.getLeftNode().setColor(true);
                    right_Rotation(brother);
                    node = root;
                }
            }
        }

        node.setColor(true);
    }

    public void inorder_Traversal(Node node) {
        if (node != NIL) {
            System.out.println("parentNode : " + node.getParentNode().getData() + " leftNode : " + node.getLeftNode().getData() + " Node : " +
                    node.getData() +  " RightNode: " + node.getRightNode().getData() + " Color : " + node.getColor());
            inorder_Traversal(node.getLeftNode());
            inorder_Traversal(node.getRightNode());
        }
    }

    public static void main(String[] args) {
        RedBlackTree redBlackTree = new RedBlackTree();


        Node n1 = new Node(NIL,80);
        Node n2 = new Node(NIL,60);
        Node n3 = new Node(NIL,10);
        Node n4 = new Node(NIL,50);
        Node n5 = new Node(NIL,20);
        Node n6 = new Node(NIL,20);
        Node n7 = new Node(NIL,40);
        Node n8 = new Node(NIL,30);
        Node n9 = new Node(NIL,90);
        Node n10 = new Node(NIL,70);



        redBlackTree.insert_Node(n1);
        redBlackTree.insert_Node(n2);
        redBlackTree.insert_Node(n3);
        redBlackTree.insert_Node(n4);
        redBlackTree.insert_Node(n5);
        redBlackTree.insert_Node(n6);
        redBlackTree.insert_Node(n7);
        redBlackTree.insert_Node(n8);
        redBlackTree.insert_Node(n9);
        redBlackTree.insert_Node(n10);

        redBlackTree.inorder_Traversal(root);

        System.out.println("\n\n======================================================\n\n");
        redBlackTree.delete_Node(n1);

        redBlackTree.inorder_Traversal(root);
        redBlackTree.delete_Node(n7);
        redBlackTree.delete_Node(n5);
        redBlackTree.inorder_Traversal(root);
        if(NIL.getParentNode() != null)
            System.out.println("parent " + NIL.getParentNode().getData());
        if(NIL.getLeftNode() != null)
            System.out.println("left " + NIL.getLeftNode().getData());
        if(NIL.getRightNode() != null)
            System.out.println("right " + NIL.getRightNode().getData());
        redBlackTree.delete_Node(n9);
        redBlackTree.delete_Node(n3);
        redBlackTree.delete_Node(n4);

        redBlackTree.inorder_Traversal(root);


    }

}



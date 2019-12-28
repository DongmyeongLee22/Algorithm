package binaryTree;

public class Main {

    public static void main(String[] args) {
        BinaryTree<String> binaryTree = new BinaryTree<>();

        Node<String> n9 = binaryTree.makeNode("iguana",null,null);
        Node<String> n8 = binaryTree.makeNode("eagle",null,null);
        Node<String> n7 = binaryTree.makeNode("cat",null,null);
        Node<String> n6 = binaryTree.makeNode("hippo",null,n9);
        Node<String> n5 = binaryTree.makeNode("dog",n7,n8);
        Node<String> n4 = binaryTree.makeNode("ant",null,null);
        Node<String> n3 = binaryTree.makeNode("goose",null,n6);
        Node<String> n2 = binaryTree.makeNode("bear",n4,n5);
        Node<String> n1 = binaryTree.makeNode("fox",n2,n3);

        System.out.println("indrder_Traversal");
        binaryTree.inorder_Traversal(n1);


        System.out.println("preorder_Traversal");
        binaryTree.preorder_Traversal(n1);


        System.out.println("postorder_Traversal");
        binaryTree.postorder_Traversal(n1);


        System.out.println("levelorder_Traversal");
        binaryTree.levelorder_Traversal(n1);

    }
}

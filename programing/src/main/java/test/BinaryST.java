package test;

public class BinaryST<E> {

    Node<Integer> root;

    public BinaryST(Node<Integer> root) {
        this.root = root;
    }

    public void insert_Tree(Node<Integer> newNode) {

        Node<Integer> baseNode = root;
        Node<Integer> runnerNode = null;

        while (baseNode != null) {
            runnerNode = baseNode;
            if (baseNode.getData() > newNode.getData())
                baseNode = baseNode.getLeftNode();
            else
                baseNode = baseNode.getRightNode();
        }

        if (runnerNode == null)
            root = newNode;
        else {
            newNode.setParentNode(runnerNode);
            if (runnerNode.getData() > newNode.getData())
                runnerNode.setLeftNode(newNode);
            else
                runnerNode.setRightNode(newNode);
        }
    }

    private Node<Integer> find_MIN(Node<Integer> root) {
        while (root.getLeftNode() != null)
            find_MIN(root.getLeftNode());
        return root;
    }

    private Node<Integer> find_Processor(Node<Integer> node) {
        if (node.getRightNode() != null)
            return find_MIN(node.getRightNode());

        Node<Integer> parent = node.getParentNode();

        while (parent != null && parent.getRightNode() == node) {
            node = parent;
            parent = parent.getParentNode();
        }
        return parent;
    }

    public void serach_Tree(Node<Integer> rootNode ,Integer value){
        if(rootNode == null)
            System.out.println("존재 하지 않음");
        else if(rootNode.getData().equals(value))
            System.out.println(rootNode.getData());
        else{
            if(rootNode.getData() > value)
                serach_Tree(rootNode.getLeftNode(),value);
            else
                serach_Tree(rootNode.getRightNode(),value);
        }

    }

    public Node<Integer> delete_Tree(Node<Integer> node){
        Node<Integer> delete, replace;

        if(node.getRightNode() == null || node.getLeftNode() == null)
            delete = node;
        else
            delete = find_Processor(node);

        if(delete.getRightNode() == null)
            replace = delete.getLeftNode();
        else
            replace = delete.getRightNode();

        if(replace != null)
            replace.setParentNode(delete.getParentNode());

        if(delete.getParentNode()==null)
            root = replace;
        else if(delete.getParentNode().getLeftNode() == delete)
            delete.getParentNode().setLeftNode(replace);
        else
            delete.getParentNode().setRightNode(replace);

        if(delete != node)
            node.setData(delete.getData());

        return delete;

    }


}

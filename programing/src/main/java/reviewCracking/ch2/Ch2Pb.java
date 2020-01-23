package reviewCracking.ch2;

import java.util.HashSet;

public class Ch2Pb {

    public boolean rmoveDuplicateValue(Node root) {
        if (root == null) {
            return false;
        }

        while (root.next != null) {
            Node runner = root;

            while (runner.next != null) {
                if (root.value == runner.next.value) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }

            root = root.next;
        }

        return true;
    }

    public boolean removeDuplicateValue(Node root) {
        if (root == null) {
            return false;
        }

        HashSet<Integer> set = new HashSet<>();
        Node pri = null;

        while (root != null) {
            if (set.contains(root.value)) {
                pri.next = root.next;
            } else {
                set.add(root.value);
                pri = root;
            }
            root = root.next;
        }

        return true;
    }

    private static int count = 0;

    public int countLastK(Node root, int k) {
        if (root == null) {
            return 0;
        }

        int ret = countLastK(root.next, k) + 1;

        if (ret == k) {
            System.out.println(root.value);
        }

        return ret;

    }

    public Node countKThLast(Node root, int k) {
        if (root == null) {
            return null;
        }

        Node node = countKThLast(root.next, k);
        count++;

        if (count == k) {
            return root;
        }

        return node;
    }

    public Node countKth(Node root, int k) {
        Node runner = root;
        for (int i = 0; i < k; i++) {
            runner = runner.next;
        }

        while (runner != null) {
            runner = runner.next;
            root = root.next;
        }

        return root;
    }

    public void deletethisNode(Node node) {
        while (node != null) {
            node.value = node.next.value;
            if (node.next.next == null) {
                node.next = null;
            }
            node = node.next;
        }
    }

    public void linkPartitionValue(Node root, int x) {

        if (root == null) {
            return;
        }

        Node left = null;
        Node right = null;

        while (root != null) {

            if (root.value < x) {
                if (left == null) {
                    left = root;
                } else {
                    left.next = root;
                }
            } else {
                if (right == null) {
                    right = root;
                } else {
                    right.next = root;
                }
            }

            root = root.next;
        }

        left.next = right;
    }

    Node Link(Node root, int x) {
        Node head = root;
        Node tail = root;

        while (root != null) {
            Node next = root.next;
            if (root.value < x) {
                root.next = head;
                head = root;
            } else {
                tail.next = root;
                tail = root;
            }
            root = next;
        }

        tail.next = null;

        return head;
    }

    Node sumNode(Node node1, Node node2) {
        return sumNode(node1, node2, 0);
    }

    private Node sumNode(Node node1, Node node2, int c) {

        if (node1 == null && node2 == null && c == 0) {
            return null;
        }

        int value = c;

        if (node1 != null) {
            value += node1.value;
        }

        if (node2 != null) {
            value += node2.value;
        }

        Node ret = new Node(value);
        c = value / 10;

        ret.next = sumNode(node1 != null ? node1.next : null,
                node2 != null ? node2.next : null,
                c);

        return ret;


    }

    private Node sumNode2(Node node1, Node node2, int c) {
        if (node1 == null && node2 == null){
            return null;
        }

        int len1 = getLength(node1);
        int len2 = getLength(node2);

        if(len1 > len2){
            node2 = addZerosTo(node2, len1 - len2);
        }else {
            node1 = addZerosTo(node1, len2 - len1);
        }

        SumNode sumNode = sumNodeWithClass(node1, node2);

        if (sumNode.carry == 0){
            return sumNode.node;
        }else{
            return beforeInsert(sumNode.node, sumNode.carry);
        }
    }

    private SumNode sumNodeWithClass(Node node1, Node node2) {
        if(node1 == null || node2 == null){
            return new SumNode();
        }

        SumNode sumNode = sumNodeWithClass(node1.next, node2.next);

        int sum = node1.value + node2.value + sumNode.carry;
        int carry = sum / 10;
        int value = sum % 10;

        sumNode.node = beforeInsert(sumNode.node, value);
        sumNode.carry = carry;

        return sumNode;
    }

    private Node addZerosTo(Node node, int count) {
        Node temp = node;
        for(int i = 0; i < count ; i ++){
            temp = beforeInsert(temp, 0);
        }
        return temp;
    }

    private Node beforeInsert(Node node, int value) {
        Node before = new Node(0);
        before.next = node;
        return before;
    }

    private int getLength(Node node) {
        int len = 0;

        return len;
    }
}

class SumNode{
    Node node;
    int carry = 0;
}

class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        next = null;
    }
}

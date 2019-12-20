package com.company.cracking.linkedlist;

import java.util.HashSet;

class Node {

    int val;
    Node next;


    public Node(int val) {
        this.val = val;
    }

    public Node() {

    }
}

public class LinkedList {

    public static void main(String[] args) {
        Node n1 = new Node();
        n1.val = 7;
        n1.next = new Node(1);
        n1.next.next = new Node(6);
        Node n2 = new Node(5);
        n2.next = new Node(9);
        n2.next.next = new Node(2);

        LinkedList linkedList = new LinkedList();
        Node getNode = linkedList.addLists2(n1, n2, 0);

        while (getNode != null) {
            System.out.println(getNode.val);
            getNode = getNode.next;
        }

    }

    // ================================ 1 ===================================//
    void deleteDuplicate(Node node) {
        HashSet<Integer> set = new HashSet<>();
        Node previous = null;

        while (node != null) {
            if (set.contains(node.val)) {
                previous.next = node.next;
            } else {
                set.add(node.val);
                previous = node;
            }
            node = node.next;
        }
    }

    void deleteDuplicateUsingRunner(Node node) {
        Node current = node;
        while (current.next != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.val == current.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    // ================================ 2 ===================================//
    // 원소 반환하지 않아도 될 때 가장 간단
    int printKthToLast(Node node, int k) {
        if (node == null) {
            return 0;
        }

        int count = printKthToLast(node.next, k) + 1;
        if (k == count) {
            System.out.println(k + "번째 데이터는" + node.val);
        }

        return count;
    }

    Node kthToLast(Node node, int k) {
        Index index = new Index();
        return kthToLast(node, k, index);
    }

    Node kthToLast(Node node, int k, Index index) {

        if (node == null) {
            return null;
        }
        Node current = kthToLast(node, k, index);
        index.val = index.val + 1;

        if (index.val == k) {
            return node;
        }

        return current;
    }

    // Runner로 공간복잡도 O(1)만들기
    Node kthToLastUsingRunner(Node node, int k) {
        if (node == null) {
            return null;
        }

        Node runner = node;
        Node current = runner;

        for (int i = 0; i < k; i++) {
            if (runner == null) return null;
            runner = runner.next;
        }

        while (runner.next != null) {
            runner = runner.next;
            current = current.next;
        }

        return current;
    }

    // ================================ 3 ===================================//
    boolean deleteMiddleNode(Node node) {
        if (node == null || node.next == null) {
            return false;
        }

        node.val = node.next.val;
        node.next = node.next.next;

        return true;
    }

    // ================================ 4 ===================================//
    Node partition(Node node, int x) {
        Node beforeSt = null;
        Node beforeEnd = null;
        Node afterSt = null;
        Node afterEnd = null;

        while (node != null) {
            if (node.val < x) {
                if (beforeSt == null) {
                    beforeSt = node;
                    beforeEnd = node;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = beforeEnd.next;
                }
            } else {
                if (afterSt == null) {
                    afterSt = node;
                    afterEnd = node;
                } else {
                    afterEnd.next = node;
                    afterEnd = afterSt.next;
                }
            }
            node = node.next;
        }
        if (beforeSt == null) {
            return afterSt;
        }

        beforeEnd.next = afterSt;
        return beforeSt;
    }

    // 두개의 필드 노드로 구하기
    Node partitionUsingTwoNode(Node node, int x) {
        Node head = node;
        Node tail = node;
        while (node != null) {

            if (node.val < x) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }

            node = node.next;
        }

        tail.next = null;

        return head;
    }

    // ================================ 5 ===================================//
    Node addList(Node n1, Node n2, int carry) {
        if (n1 == null && n2 == null && carry == 0) {
            return null;
        }

        Node ret = new Node();

        int data = carry;

        if (n1 != null) {
            data += n1.val;
        }
        if (n2 != null) {
            data += n2.val;
        }

        carry = data / 10;
        ret.val = data % 10;

        if (n1 != null || n2 != null) {
            ret.next = addList(n1 == null ? null : n1.next,
                    n2 == null ? null : n2.next,
                    carry);
        }

        return ret;
    }

    Node addLists2(Node n1, Node n2, int carry) {
        if (n1 == null && n2 == null) {
            return null;
        }

        int len1 = getNodeLength(n1);
        int len2 = getNodeLength(n2);

        if (len1 > len2) {
            n2 = addZerosList(n2, len1 - len2);
        } else {
            n1 = addZerosList(n1, len2 - len1);
        }

        PartialSum sum = sumListHelper(n1, n2);

        if (sum.carry == 0) {
            return sum.node;
        } else {
            return insertBefore(sum.node, sum.carry);
        }


    }

    private PartialSum sumListHelper(Node n1, Node n2) {
        if (n1 == null && n2 == null) {
            return new PartialSum();
        }

        PartialSum sum = sumListHelper(n1.next, n2.next);
        int data = sum.carry + n1.val + n2.val;
        Node request = insertBefore(sum.node, data % 10);
        sum.node = request;
        sum.carry = data / 10;
        return sum;
    }

    private Node addZerosList(Node node, int padding) {
        Node ret = node;
        for (int i = 0; i < padding; i++) {
            ret = insertBefore(ret, 0);
        }
        return ret;
    }

    private Node insertBefore(Node node, int value) {
        Node ret = new Node(value);
        if (node != null) {
            ret.next = node;
        }
        return ret;
    }

    private int getNodeLength(Node node) {
        int ret = 0;
        while (node != null) {
            ret++;
            node = node.next;
        }
        return ret;
    }

    // Wapper 클래스 구현
    class Index {
        public int val = 0;
    }

    class PartialSum {
        Node node = null;
        int carry = 0;
    }
}

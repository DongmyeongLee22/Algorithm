package com.company.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    public static void main(String[] args) {
        Node node1 = new Node(1, new ArrayList<>());
        Node node2 = new Node(2, new ArrayList<>());
        Node node3 = new Node(3, new ArrayList<>());
        Node node4 = new Node(4, new ArrayList<>());

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Solution solution = new Solution();
        Node node = solution.cloneGraph(node1);
        int i = 1;

    }

    /* 내가 푼거..
        static class Solution {
        Map<Node, Node> map;
        Node ret;

        public Node cloneGraph(Node node) {
            map = new HashMap<>();
            ret = new Node(node.val, new ArrayList<>());
            Node cur = ret;

            map.put(node, ret);

            cloneGraph(node, cur);

            return ret;
        }

        public void cloneGraph(Node node, Node cur) {
            for (Node neighbor : node.neighbors) {
                if (cur.neighbors.contains(map.get(neighbor))) return;

                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                }
                cur.neighbors.add(map.get(neighbor));
                cloneGraph(neighbor, map.get(neighbor));
            }
        }
    }
    */

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    // Good Idea!!
    static class Solution {

        Map<Node, Node> map = new HashMap<>();

        public Node cloneGraph(Node node) {

            if (node == null) return null;
            Node newNode = new Node(node.val, new ArrayList<Node>());
            map.put(node, newNode);

            for (Node n : node.neighbors) {
                if (!map.containsKey(n))
                    newNode.neighbors.add(cloneGraph(n));
                else
                    newNode.neighbors.add(map.get(n));
            }

            return newNode;
        }
    }
}

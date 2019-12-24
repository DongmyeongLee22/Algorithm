package com.company.cracking.treeAndgraph;

import java.util.LinkedList;
import java.util.Queue;

public class 노드사이의경로 {
    boolean search(Graph g, Node start, Node end) {
        if (start == end) return true;

        Queue<Node> q = new LinkedList<>();

        for (Node u : g.nodes) {
            u.state = State.Unvisited;
        }

        start.state = State.Visiting;
        q.add(start);
        Node temp;
        while (!q.isEmpty()) {
            temp = q.poll();
            if (temp != null) {
                for (Node n : temp.children) {
                    if (n.state == State.Unvisited) {
                        if (n == end) {
                            return true;
                        } else {
                            n.state = State.Visiting;
                            q.add(n);
                        }
                    }
                }
                temp.state = State.Visited;
            }
        }
        return false;
    }

    enum State {Unvisited, Visited, Visiting}

    class Graph {
        public Node[] nodes;
    }

    class Node {
        public int val;
        public State state;
        public Node[] children;
    }
}


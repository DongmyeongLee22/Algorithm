package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    ;

    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) return null;
            Map<Node, Node> map = new HashMap<>();
            Node ret = new Node(head.val, null, null);
            Node cur = ret;

            map.put(head, ret);

            while (head != null) {
                if (head.next != null) {
                    if (!map.containsKey(head.next)) {
                        map.put(head.next, new Node(head.next.val, null, null));
                    }
                    cur.next = map.get(head.next);
                }

                if (head.random != null) {
                    if (!map.containsKey(head.random)) {
                        map.put(head.random, new Node(head.random.val, null, null));
                    }
                    cur.random = map.get(head.random);
                }

                head = head.next;
                cur = cur.next;
            }
            return ret;
        }
    }
}

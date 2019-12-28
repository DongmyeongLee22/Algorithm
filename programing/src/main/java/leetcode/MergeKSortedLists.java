package leetcode;

import java.util.PriorityQueue;

public class MergeKSortedLists {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) return null;
            ListNode ret = null;
            ListNode cur = null;
            PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);

            for (ListNode node : lists) {
                if (node == null) continue;
                ListNode test = node;
                pq.offer(node);
            }

            while (!pq.isEmpty()) {
                ListNode node = pq.poll();
                if (ret == null) {
                    ret = node;
                    cur = ret;
                } else {
                    cur.next = node;
                    cur = cur.next;
                }

                if (node.next != null) {
                    pq.offer(node.next);
                }
            }

            return ret;
        }
    }

}

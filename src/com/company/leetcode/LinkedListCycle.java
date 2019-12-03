package com.company.leetcode;

public class LinkedListCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode runner = head;
            ListNode walker = runner;

            while (runner != null) {
                runner = runner.next;
                if (runner == walker) {
                    return true;
                }
                if (runner != null) {
                    runner = runner.next;
                    walker = walker.next;
                }
            }

            return false;
        }
    }
}

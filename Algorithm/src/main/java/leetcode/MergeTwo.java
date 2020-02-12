package leetcode;

public class MergeTwo {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ret = null;
        ListNode cur = null;

        while (l1 != null || l2 != null) {
            if (ret == null) {
                if (l2 == null || (l1 != null && l1.val < l2.val)) {
                    ret = l1;
                    cur = l1;
                    l1 = l1.next;
                } else {
                    ret = l2;
                    cur = l2;
                    l2 = l2.next;
                }
            } else {
                if (l2 == null || (l1 != null && l1.val < l2.val)) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
        }
        return ret;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}


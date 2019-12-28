package leetcode;

public class MiddleLinkedList {

    int count = 0;

    public ListNode middleNodeWithWalkerRunner(ListNode head){
        ListNode walker = head;
        ListNode runner = head;

        while (runner != null){
            runner = runner.next;

            if (runner != null){
                runner = runner.next;
                walker = walker.next;
            }
        }

        return walker;
    }

    public ListNode middleNode(ListNode head) {

        countNode(head);

        return getNode(head, count);

    }

    public void countNode(ListNode node){
        if(node == null) return;
        count++;
        countNode(node.next);
    }

    public ListNode getNode(ListNode head, int count){
        ListNode ret = head;

        for(int i = 0; i < (count / 2); i++){
            ret = ret.next;
        }

        return ret;
    }

}
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}

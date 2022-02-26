package algorithm.leetcode.problem_24;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode(0, head);
        ListNode ret = head.next;
        while (pre.next != null && pre.next.next != null) {
            ListNode cur = pre.next;
            ListNode next = pre.next.next;
            cur.next = next.next;
            next.next = cur;
            pre.next = next;
            pre = cur;
        }
        return ret;
    }
}

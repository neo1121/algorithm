package algorithm.leetcode.problem_203;

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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode pre = new ListNode(0, head);
        ListNode cur = head;
        head = pre;
        while (cur != null) {
            if (cur.val == val)
                pre.next = cur.next;
            else pre = pre.next;
            cur = cur.next;
        }
        return head.next;
    }

}

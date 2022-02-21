package algorithm.leetcode.problem_2181;

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
    public ListNode mergeNodes(ListNode head) {
        ListNode cur = head.next;
        ListNode next = cur.next;
        while (next != null) {
            if (next.val != 0) {
                cur.val += next.val;
                next = next.next;
            } else {
                cur.next = next.next;
                cur = cur.next;
                next = cur == null ? null : cur.next;
            }
        }
        return head.next;
    }
}

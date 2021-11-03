package algorithm.leetcode.problem_61;

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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode end = head;
        int len = 1;
        while (end.next != null) {
            len++;
            end = end.next;
        }
        end.next = head;
        for (int i = 0; i < len - k % len; i++) {
            head = head.next;
            end = end.next;
        }
        end.next = null;
        return head;
    }

}

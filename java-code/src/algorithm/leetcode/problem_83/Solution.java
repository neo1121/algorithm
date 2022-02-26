package algorithm.leetcode.problem_83;

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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode ans = head;
        while (head.next != null) {
            ListNode next = head.next;
            if (head.val == next.val)
                head.next = next.next;
            else head = head.next;
        }
        return ans;
    }
}

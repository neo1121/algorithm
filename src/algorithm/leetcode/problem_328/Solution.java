package algorithm.leetcode.problem_328;

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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode cur = evenHead;
        while (cur.next != null && cur.next.next != null) {
            oddHead.next = cur.next;
            cur.next = cur.next.next;
            oddHead = oddHead.next;
            cur = cur.next;
        }
        if (cur.next != null) {
            oddHead.next = cur.next;
            oddHead = oddHead.next;
            cur.next = null;
        }
        oddHead.next = evenHead;
        return head;
    }
}

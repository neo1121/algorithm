package algorithm.leetcode.problem_86;

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

    // for interview
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode sH = null, sT = null, bH = null, bT = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < x) {
                ListNode[] nodes = putNode(sH, sT, head);
                sH = nodes[0];
                sT = nodes[1];
            } else {
                ListNode[] nodes = putNode(bH, bT, head);
                bH = nodes[0];
                bT = nodes[1];
            }
            head = next;
        }
        if (sH != null) {
            if (sT != null)
                sT.next = bH;
            else sH.next = bH;
        }
        return sH != null ? sH : bH;
    }

    public ListNode[] putNode(ListNode head, ListNode tail, ListNode fresh) {
        if (head == null) {
            head = fresh;
        } else if (tail == null) {
            tail = fresh;
            head.next = tail;
        } else {
            tail.next = fresh;
            tail = tail.next;
        }
        return new ListNode[]{head, tail};
    }

}

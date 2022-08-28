package algorithm.leetcode.problem_206;

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

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode reverseHead = head;
        ListNode next = head.next;
        head.next = null;
        while (next != null) {
            ListNode cur = next;
            next = next.next;
            cur.next = reverseHead;
            reverseHead = cur;
        }
        // now "head" is the last node of this reversed linked list
        return reverseHead;
    }

}

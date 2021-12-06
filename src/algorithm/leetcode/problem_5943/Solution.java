package algorithm.leetcode.problem_5943;

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
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        ListNode copy = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null) {
            // 奇数个节点
            // 慢指针在中间节点
            while (copy.next != slow) {
                copy = copy.next;
            }
            copy.next = slow.next;
        } else {
            // 偶数个节点
            // 慢指针在中间节点的前一个节点
            slow.next = slow.next.next;
        }
        return head;
    }
}

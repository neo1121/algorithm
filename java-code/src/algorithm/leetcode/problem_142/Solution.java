package algorithm.leetcode.problem_142;

import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head))
                return head;
            set.add(head);
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        boolean noCycle = true;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                noCycle = false;
                break;
            }
        }
        if (noCycle)
            return null;
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

package algorithm.leetcode.problem_2130;

import java.util.Stack;

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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        Stack<Integer> stack = new Stack<>();
        while (fast != null) {
            stack.push(fast.val);
            fast = fast.next;
        }
        int ret = Integer.MIN_VALUE;
        while (head != null) {
            ret = Math.max(head.val + stack.pop(), ret);
            head = head.next;
        }
        return ret;
    }
}

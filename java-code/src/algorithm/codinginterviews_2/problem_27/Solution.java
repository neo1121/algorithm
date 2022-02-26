package algorithm.codinginterviews_2.problem_27;

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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;
        Stack<Integer> stack = new Stack<>();
        while (slow != null) {
            stack.push(slow.val);
            slow = slow.next;
        }
        fast = head;
        while (!stack.isEmpty()) {
            if (fast.val != stack.pop()) return false;
            fast = fast.next;
        }
        return true;
    }
}

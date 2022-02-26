package algorithm.leetcode.problem_234;

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

    // for written examination
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode headCopy = head;
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        while (headCopy != null) {
            if (headCopy.val != stack.pop())
                return false;
            headCopy = headCopy.next;
        }
        return true;
    }

    // for written examination (less space)
    public boolean isPalindrome2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;   //the first node of the right part
        Stack<Integer> stack = new Stack<>();
        while (slow != null) {
            stack.push(slow.val);
            slow = slow.next;
        }
        while (!stack.empty()) {
            if (head.val != stack.pop())
                return false;
            head = head.next;
        }
        return true;
    }

    // for interview
    public boolean isPalindrome3(ListNode head) {
        // find the mid-node
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse the latter part
        fast = slow.next;
        slow.next = null;
        while (fast != null) {
            ListNode cur = fast;
            fast = fast.next;
            cur.next = slow;
            slow = cur;
        }
        fast = slow;
        // now "slow" is the head of reversed linked list
        // judge
        boolean ans = true;
        while (head != null && slow != null) {
            if (head.val != slow.val) {
                ans = false;
                break;
            }
            head = head.next;
            slow = slow.next;
        }
        // restore the list
        slow = fast.next;
        fast.next = null;
        while (slow != null) {
            ListNode cur = slow;
            slow = slow.next;
            cur.next = fast;
            fast = cur;
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode headCopy = head;
        for (int i = 2; i <= 5; i++) {
            headCopy.next = new ListNode(i);
            headCopy = headCopy.next;
        }
        boolean ans = new Solution().isPalindrome3(head);
        System.out.println(ans);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}

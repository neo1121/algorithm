package algorithm.leetcode.problem_237;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public void deleteNode(ListNode node) {
        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }
}

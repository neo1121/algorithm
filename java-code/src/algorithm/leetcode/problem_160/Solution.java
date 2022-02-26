package algorithm.leetcode.problem_160;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode endA = headA;
        ListNode endB = headB;
        int stepA = 1;
        int stepB = 1;
        while (endA.next != null) {
            stepA++;
            endA = endA.next;
        }
        while (endB.next != null) {
            stepB++;
            endB = endB.next;
        }
        if (endA != endB)
            return null;
        // endA equal to endB, then two lists must intersect
        endA = headA;
        endB = headB;
        while (stepA > stepB) {
            stepA--;
            endA = endA.next;
        }
        while (stepA < stepB) {
            stepB--;
            endB = endB.next;
        }
        while (endA != endB) {
            endA = endA.next;
            endB = endB.next;
        }
        return endA;
    }
}

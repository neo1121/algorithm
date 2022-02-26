package algorithm.leetcode.problem_23;

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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1) return null;
        if (lists.length == 1) return lists[0];
        ListNode ans = lists[0];
        for (int i = 1; i < lists.length; i++)
            ans = merge(ans, lists[i]);
        return ans;
    }

    public ListNode merge(ListNode headA, ListNode headB) {
        ListNode ret = new ListNode();
        ListNode cur = ret;
        while (headA != null && headB != null) {
            if (headA.val <= headB.val) {
                cur.next = headA;
                headA = headA.next;
            } else {
                cur.next = headB;
                headB = headB.next;
            }
            cur = cur.next;
        }
        while (headA != null) {
            cur.next = headA;
            cur = cur.next;
            headA = headA.next;
        }
        while (headB != null) {
            cur.next = headB;
            cur = cur.next;
            headB = headB.next;
        }
        return ret.next;
    }
}

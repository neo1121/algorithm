package algorithm.leetcode.problem_21;

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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode ret = node;
        while (l1 != null && l2 != null) {
            node.next = new ListNode();
            node = node.next;
            if (l1.val < l2.val) {
                node.val = l1.val;
                l1 = l1.next;
            } else {
                node.val = l2.val;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            node.next = new ListNode();
            node = node.next;
            node.val = l1.val;
            l1 = l1.next;
        }
        while(l2!=null){
            node.next = new ListNode();
            node = node.next;
            node.val = l2.val;
            l2 = l2.next;
        }
        return ret.next;
    }
}

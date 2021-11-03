package algorithm.leetcode.problem_725;

import java.util.ArrayList;

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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length += 1;
            cur = cur.next;
        }
        cur = head;
        ListNode[] list = new ListNode[k];
        if (length <= k) {
            // length <= k => partLength <=1
            for (int i = 0; i < k; i++) {
                if (i < length) {
                    ListNode next = cur.next;
                    cur.next = null;
                    list[i] = cur;
                    cur = next;
                } else {
                    list[i] = null;
                }
            }
        } else {
            // length > k => partLength > 1; remainder
            int partLength = length / k;
            int remainder = length % k;
            for (int i = 0; i < k; i++) {
                list[i] = cur;
                for (int j = 0; j < partLength - 1; j++) {
                    cur = cur.next;
                }
                cur = remainder-- > 0 ? cur.next : cur;
                ListNode next = cur.next;
                cur.next = null;
                cur = next;
            }
        }
        return list;
    }
}

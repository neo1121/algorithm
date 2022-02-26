package algorithm.leetcode.problem_382;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    public List<Integer> list;
    public int size;

    public Solution(ListNode head) {
        list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        size = list.size();
    }

    public int getRandom() {
        int index = new Random().nextInt(size);
        return list.get(index);
    }
}

package algorithm.leetcode.problem_138;

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public Node copyRandomList2(Node head) {
        if (head == null) return null;
        Node cur = head;
        // 1 -> 2 -> 3
        // 1 -> 1' -> 2 -> 2' -> 3 -> 3'
        while (cur != null) {
            Node next = cur.next;
            Node copy = new Node(cur.val);
            cur.next = copy;
            copy.next = next;
            cur = next;
        }
        cur = head;
        // copy random
        while (cur != null) {
            Node next = cur.next.next;
            Node copy = cur.next;
            copy.random = cur.random == null ? null : cur.random.next;
            cur = next;
        }
        // split
        cur = head;
        Node ans = head.next;
        while (cur != null) {
            Node next = cur.next.next;
            Node copy = cur.next;
            cur.next = next;
            cur = cur.next;
            copy.next = cur == null ? null : cur.next;
        }
        return ans;
    }
}

package algorithm.leetcode.problem_148;

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

    // for written examination
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        ArrayList<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        progress(nodes, 0, nodes.size() - 1);
        for (int i = 0; i < nodes.size() - 1; i++)
            nodes.get(i).next = nodes.get(i + 1);
        nodes.get(nodes.size() - 1).next = null;
        return nodes.get(0);
    }

    public void progress(ArrayList<ListNode> list, int l, int r) {
        if (l >= r) return;
        swap(list, (int) (l + Math.random() * (r - l + 1)), r);
        int[] p = partitionArray(list, l, r);
        progress(list, l, p[0]);
        progress(list, p[1], r);
    }

    public int[] partitionArray(ArrayList<ListNode> list, int l, int r) {
        int i = l;
        int less = l - 1;
        int more = r;
        int val = list.get(r).val;
        while (i < more) {
            if (list.get(i).val < val)
                swap(list, i++, ++less);
            else if (list.get(i).val > val)
                swap(list, i, --more);
            else i++;
        }
        swap(list, i, r);
        return new int[]{less, more};
    }

    public void swap(ArrayList<ListNode> list, int i, int j) {
        ListNode nodeI = list.get(i);
        ListNode nodeJ = list.get(j);
        list.set(i, nodeJ);
        list.set(j, nodeI);
    }

    // merge
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        head = sortList2(head);
        fast = sortList2(fast);
        return merge(head, fast);
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode ret = new ListNode();
        ListNode retHead = ret;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                ret.next = head1;
                head1 = head1.next;
            } else {
                ret.next = head2;
                head2 = head2.next;
            }
            ret = ret.next;
        }
        while (head1 != null) {
            ret.next = head1;
            ret = ret.next;
            head1 = head1.next;
        }
        while (head2 != null) {
            ret.next = head2;
            ret = ret.next;
            head2 = head2.next;
        }
        return retHead.next;
    }

}

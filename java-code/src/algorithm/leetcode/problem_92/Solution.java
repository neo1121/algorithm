package algorithm.leetcode.problem_92;

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


    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode headCopy = new ListNode();
        headCopy.next = head;
        head = headCopy;
        int i = 1;
        while (i < left) {
            head = head.next;
            i++;
        }
        // the last node before the reverse list
        ListNode leftOne = head;
        // the first node of the reverse list
        ListNode reverseHead = head.next;

        while (i < right + 1) {
            head = head.next;
            i++;
        }
        // the first node after the reverse list
        ListNode rightOne = head.next;
        head.next = null;

        // reverseHead will be the last node of the reverse list
        leftOne.next = reverseList(reverseHead);
        reverseHead.next = rightOne;
        return headCopy.next;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode reverseHead = head;
        ListNode next = head.next;
        head.next = null;
        while (next != null) {
            ListNode cur = next;
            next = cur.next;
            cur.next = reverseHead;
            reverseHead = cur;
        }
        return reverseHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode headCopy = head;
        for (int i = 2; i <= 5; i++) {
            headCopy.next = new ListNode(i);
            headCopy = headCopy.next;
        }
        head = new Solution().reverseBetween(head, 2, 4);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}

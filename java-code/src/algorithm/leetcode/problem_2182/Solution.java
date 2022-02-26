package algorithm.leetcode.problem_2182;

import java.util.PriorityQueue;

public class Solution {
    static class Record {
        public char val;
        public int count;

        public Record(char val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<Record> maxHeap = new PriorityQueue<>((o1, o2) -> o2.val - o1.val);
        int[] temp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > 0) {
                maxHeap.add(new Record((char) (i + 'a'), temp[i]));
            }
        }
        char pre = ' ';
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Record first = maxHeap.poll();
            if (first.val != pre) {
                for (int i = 0; i < repeatLimit && first.count > 0; i++, first.count--) {
                    sb.append(first.val);
                }
                pre = first.val;
            } else {
                Record second = maxHeap.poll();
                if (second == null) {
                    break;
                }
                sb.append(second.val);
                second.count -= 1;
                if (second.count > 0) {
                    maxHeap.add(second);
                }
                pre = second.val;
            }
            if (first.count > 0) {
                maxHeap.add(first);
            }
        }
        return sb.toString();
    }
}

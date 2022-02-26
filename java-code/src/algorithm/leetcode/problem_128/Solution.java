package algorithm.leetcode.problem_128;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public static class UnionFindMap {
        public HashMap<Integer, Integer> father = new HashMap<>();
        public HashMap<Integer, Integer> size = new HashMap<>();

        public UnionFindMap(int[] nums) {
            for (int num : nums) {
                father.put(num, num);
                size.put(num, 1);
            }
        }

        private int findHead(int num) {
            Stack<Integer> stack = new Stack<>();
            while (num != father.get(num)) {
                stack.push(num);
                num = father.get(num);
            }
            while (!stack.isEmpty()) {
                father.put(stack.pop(), num);
            }
            return num;
        }

        public void union(int num1, int num2) {
            if (!father.containsKey(num1) || !father.containsKey(num2)) {
                return;
            }
            int head1 = findHead(num1);
            int head2 = findHead(num2);
            if (head1 == head2) {
                return;
            }
            int small = size.get(head1) > size.get(head2) ? head2 : head1;
            int big = small == head1 ? head2 : head1;
            father.put(small, big);
            size.put(big, size.get(big) + size.get(small));
            size.remove(small);
        }
    }

    public int longestConsecutive(int[] nums) {
        UnionFindMap unionFindMap = new UnionFindMap(nums);
        for (int num : nums) {
            if (num < 1000000000) {
                unionFindMap.union(num, num + 1);
            }
        }
        int ans = 0;
        for (Integer value : unionFindMap.size.values()) {
            ans = Math.max(ans, value);
        }
        return ans;
    }
}

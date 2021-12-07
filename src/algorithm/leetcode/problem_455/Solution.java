package algorithm.leetcode.problem_455;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        PriorityQueue<Integer> contentQueue = new PriorityQueue<>();
        PriorityQueue<Integer> cookieQueue = new PriorityQueue<>();
        contentQueue.addAll(Arrays.stream(g).boxed().collect(Collectors.toList()));
        cookieQueue.addAll(Arrays.stream(s).boxed().collect(Collectors.toList()));
        int count = 0;
        while (!cookieQueue.isEmpty() && !contentQueue.isEmpty()) {
            int cookie = cookieQueue.poll();
            if (cookie >= contentQueue.peek()) {
                count += 1;
                contentQueue.poll();
            }
        }
        return count;
    }

    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; ) {
            if (s[j] >= g[i]) {
                count += 1;
                i += 1;
                j += 1;
            } else {
                j += 1;
            }
        }
        return count;
    }
}
